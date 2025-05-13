package qbittorrent.api.model;

import com.google.gson.annotations.SerializedName;

public record ServerState(

        @SerializedName("refresh_interval")
        long refreshInterval,

        @SerializedName("dht_nodes")
        long dhtNodes,

        @SerializedName("total_peer_connections")
        long totalPeerConnections,

        @SerializedName("average_time_queue")
        long averageTimeQueue,

        @SerializedName("free_space_on_disk")
        long freeSpaceOnDisk,

        @SerializedName("total_queued_size")
        long totalQueuedSize,

        @SerializedName("dl_info_data")
        long dlInfoData,

        @SerializedName("queueing")
        boolean queueing,

        @SerializedName("connection_status")
        String connectionStatus,

        @SerializedName("alltime_ul")
        long alltimeUl,

        @SerializedName("up_info_speed")
        long upInfoSpeed,

        @SerializedName("read_cache_overload")
        String readCacheOverload,

        @SerializedName("global_ratio")
        String globalRatio,

        @SerializedName("dl_rate_limit")
        long dlRateLimit,

        @SerializedName("write_cache_overload")
        String writeCacheOverload,

        @SerializedName("queued_io_jobs")
        long queuedIoJobs,

        @SerializedName("total_buffers_size")
        long totalBuffersSize,

        @SerializedName("read_cache_hits")
        String readCacheHits,

        @SerializedName("use_alt_speed_limits")
        boolean useAltSpeedLimits,

        @SerializedName("up_info_data")
        long upInfoData,

        @SerializedName("total_wasted_session")
        long totalWastedSession,

        @SerializedName("up_rate_limit")
        long upRateLimit,

        @SerializedName("alltime_dl")
        long alltimeDl,

        @SerializedName("dl_info_speed")
        long dlInfoSpeed
) {
}
