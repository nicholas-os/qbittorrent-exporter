package qbittorrent.exporter.handler;

import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qbittorrent.api.ApiClient;
import qbittorrent.api.model.MainData;
import qbittorrent.api.model.Preferences;
import qbittorrent.api.model.ServerState;
import qbittorrent.api.model.Torrent;
import qbittorrent.exporter.collector.QbtCollector;

import java.util.List;

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
    public void handleRequest(HttpServerExchange exchange) {
        LOGGER.info("Beginning prometheus metrics collection...");
        final long start = System.nanoTime();
        try {
            final List<Torrent> torrents = client.getTorrents();
            final Preferences preferences = client.getPreferences();
            final MainData data = client.getMainData();
            final ServerState serverState = data.serverState();

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

            for (Torrent torrent : torrents) {
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
            }

            final List<String> states = torrents.stream().map(Torrent::state).distinct().toList();
            for (String state : states) {
                final long count = torrents.stream().filter(t -> t.state().equals(state)).count();
                collector.setTorrentStates(state, count);
            }

            final long duration = (System.nanoTime() - start) / 1_000_000;
            LOGGER.info("Completed in {}ms", duration);
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, CONTENT_TYPE);
            exchange.getResponseSender().send(registry.scrape());
        } catch (Exception e) {
            LOGGER.error("An error occurred calling API", e);
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, CONTENT_TYPE);
            exchange.setStatusCode(500);
            exchange.getResponseSender().send("An error occurred. " + e.getMessage());
        }
    }
}
