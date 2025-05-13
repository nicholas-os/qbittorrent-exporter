package qbittorrent.api.model;

import com.google.gson.annotations.SerializedName;

public record Torrent(

        @SerializedName("amount_left")
        long amountLeft,

        @SerializedName("max_ratio")
        double maxRatio,

        @SerializedName("auto_tmm")
        boolean autoTmm,

        @SerializedName("availability")
        double availability,

        @SerializedName("num_incomplete")
        long numIncomplete,

        @SerializedName("seeding_time_limit")
        long seedingTimeLimit,

        @SerializedName("force_start")
        boolean forceStart,

        @SerializedName("save_path")
        String savePath,

        @SerializedName("num_seeds")
        long numSeeds,

        @SerializedName("dl_limit")
        long dlLimit,

        @SerializedName("eta")
        long eta,

        @SerializedName("last_activity")
        long lastActivity,

        @SerializedName("num_leechs")
        long numLeechs,

        @SerializedName("num_complete")
        long numComplete,

        @SerializedName("seen_complete")
        long seenComplete,

        @SerializedName("tracker")
        String tracker,

        @SerializedName("uploaded")
        long uploaded,

        @SerializedName("completion_on")
        long completionOn,

        @SerializedName("ratio_limit")
        double ratioLimit,

        @SerializedName("state")
        String state,

        @SerializedName("added_on")
        long addedOn,

        @SerializedName("time_active")
        long timeActive,

        @SerializedName("total_size")
        long totalSize,

        @SerializedName("seq_dl")
        boolean seqDl,

        @SerializedName("downloaded_session")
        long downloadedSession,

        @SerializedName("completed")
        long completed,

        @SerializedName("f_l_piece_prio")
        boolean fLPiecePrio,

        @SerializedName("priority")
        long priority,

        @SerializedName("super_seeding")
        boolean superSeeding,

        @SerializedName("upspeed")
        long upspeed,

        @SerializedName("downloaded")
        long downloaded,

        @SerializedName("tags")
        String tags,

        @SerializedName("uploaded_session")
        long uploadedSession,

        @SerializedName("size")
        long size,

        @SerializedName("up_limit")
        long upLimit,

        @SerializedName("magnet_uri")
        String magnetUri,

        @SerializedName("max_seeding_time")
        long maxSeedingTime,

        @SerializedName("name")
        String name,

        @SerializedName("progress")
        double progress,

        @SerializedName("category")
        String category,

        @SerializedName("dlspeed")
        long dlspeed,

        @SerializedName("hash")
        String hash,

        @SerializedName("ratio")
        double ratio) {
}
