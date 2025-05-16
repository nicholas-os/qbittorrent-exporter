package qbittorrent.exporter.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qbittorrent.api.ApiClient;
import qbittorrent.api.model.Torrent;
import qbittorrent.exporter.collector.QbtCollector;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class QbtHttpHandler implements HttpHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(QbtHttpHandler.class);
    private static final String CONTENT_TYPE = "text/plain;charset=utf-8";

    private final PrometheusMeterRegistry registry;
    private final QbtCollector collector;
    private final ApiClient client;

    public QbtHttpHandler(final ApiClient client) {
        this.client = client;
        this.registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        this.collector = new QbtCollector();
        this.registry.getPrometheusRegistry().register(collector);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        LOGGER.debug("Beginning prometheus metrics collection...");
        final var start = Instant.now();
        try {

            var getTorrentsCompletable = CompletableFuture.supplyAsync(client::getTorrents);
            var getPreferencesCompletable = CompletableFuture.supplyAsync(client::getPreferences);
            var getMainDataCompletable = CompletableFuture.supplyAsync(client::getMainData);

            CompletableFuture
                    .allOf(getTorrentsCompletable, getPreferencesCompletable, getMainDataCompletable).join();

            final var torrents = getTorrentsCompletable.join();
            final var preferences = getPreferencesCompletable.join();
            final var data = getMainDataCompletable.join();
            final var serverState = data.serverState();

            collector.clear();
            collector.setAppVersion(client.getVersion());
            collector.setTotalTorrents(torrents.size());
            collector.setGlobalAlltimeDownloadedBytes(serverState.alltimeDl());
            collector.setGlobalAlltimeUploadedBytes(serverState.alltimeUl());
            collector.setGlobalSessionDownloadedBytes(serverState.dlInfoData());
            collector.setGlobalSessionUploadedBytes(serverState.upInfoData());
            collector.setGlobalDownloadSpeedBytes(serverState.dlInfoSpeed());
            collector.setGlobalUploadSpeedBytes(serverState.upInfoSpeed());
            collector.setGlobalRatio(Double.parseDouble(serverState.globalRatio()));
            collector.setAppDownloadRateLimitBytes(serverState.dlRateLimit());
            collector.setAppUploadRateLimitBytes(serverState.upRateLimit());
            collector.setAppAlternateDownloadRateLimitBytes(preferences.altDlLimit());
            collector.setAppAlternateUploadRateLimitBytes(preferences.altUpLimit());
            collector.setAppAlternateRateLimitsEnabled(serverState.useAltSpeedLimits());
            collector.setAppMaxActiveDownloads(preferences.maxActiveDownloads());
            collector.setAppMaxActiveUploads(preferences.maxActiveUploads());
            collector.setAppMaxActiveTorrents(preferences.maxActiveTorrents());

            torrents.forEach(torrent -> {
                collector.setTorrentDownloadSpeedBytes(torrent.name(), torrent.dlspeed());
                collector.setTorrentUploadSpeedBytes(torrent.name(), torrent.upspeed());
                collector.setTorrentTotalDownloadedBytes(torrent.name(), torrent.downloaded());
                collector.setTorrentSessionDownloadedBytes(torrent.name(), torrent.downloadedSession());
                collector.setTorrentTotalUploadedBytes(torrent.name(), torrent.uploaded());
                collector.setTorrentSessionUploadedBytes(torrent.name(), torrent.uploadedSession());
                collector.setTorrentEta(torrent.name(), torrent.eta());
                collector.setTorrentProgress(torrent.name(), torrent.progress());
                collector.setTorrentTimeActive(torrent.name(), torrent.timeActive());
                collector.setTorrentSeeders(torrent.name(), torrent.numSeeds());
                collector.setTorrentLeechers(torrent.name(), torrent.numLeechs());
                collector.setTorrentRatio(torrent.name(), torrent.ratio());
                collector.setTorrentAmountLeftBytes(torrent.name(), torrent.amountLeft());
                collector.setTorrentSizeBytes(torrent.name(), torrent.size());
                collector.setTorrentInfo(torrent);
            });

            for (String state : torrents.stream().map(Torrent::state).distinct().toList()) {
                collector.setTorrentStates(
                        state,
                        torrents.stream().filter(t -> t.state().equals(state)).count()
                );
            }

            LOGGER.info("Completed in {}", Duration.between(start, Instant.now()));
            exchange.getResponseHeaders().put("Content-Type", List.of(CONTENT_TYPE));

            var responseBode = registry.scrape();
            exchange.sendResponseHeaders(200, responseBode.length());
            var os = exchange.getResponseBody();
            os.write(responseBode.getBytes(StandardCharsets.UTF_8));
            os.close();
        } catch (Exception e) {
            LOGGER.error("An error occurred calling API", e);
            var response = "An error occurred. " + e.getMessage();
            exchange.getResponseHeaders().put("Content-Type", List.of(CONTENT_TYPE));
            exchange.sendResponseHeaders(500, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes(StandardCharsets.UTF_8));
            os.close();
        }
    }
}


