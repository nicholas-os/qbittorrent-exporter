package qbittorrent.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ServerState(
        @JsonProperty("refresh_interval") long refreshInterval,
        @JsonProperty("dht_nodes") long dhtNodes,
        @JsonProperty("total_peer_connections") long totalPeerConnections,
        @JsonProperty("average_time_queue") long averageTimeQueue,
        @JsonProperty("free_space_on_disk") long freeSpaceOnDisk,
        @JsonProperty("total_queued_size") long totalQueuedSize,
        @JsonProperty("dl_info_data") long dlInfoData,
        @JsonProperty("queueing") boolean queueing,
        @JsonProperty("connection_status") String connectionStatus,
        @JsonProperty("alltime_ul") long alltimeUl,
        @JsonProperty("up_info_speed") long upInfoSpeed,
        @JsonProperty("read_cache_overload") String readCacheOverload,
        @JsonProperty("global_ratio") String globalRatio,
        @JsonProperty("dl_rate_limit") long dlRateLimit,
        @JsonProperty("write_cache_overload") String writeCacheOverload,
        @JsonProperty("queued_io_jobs") long queuedIoJobs,
        @JsonProperty("total_buffers_size") long totalBuffersSize,
        @JsonProperty("read_cache_hits") String readCacheHits,
        @JsonProperty("use_alt_speed_limits") boolean useAltSpeedLimits,
        @JsonProperty("up_info_data") long upInfoData,
        @JsonProperty("total_wasted_session") long totalWastedSession,
        @JsonProperty("up_rate_limit") long upRateLimit,
        @JsonProperty("alltime_dl") long alltimeDl,
        @JsonProperty("dl_info_speed") long dlInfoSpeed) {}
