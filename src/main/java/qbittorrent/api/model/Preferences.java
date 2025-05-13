package qbittorrent.api.model;

import com.google.gson.annotations.SerializedName;

public record Preferences(

        @SerializedName("embedded_tracker_port")
        long embeddedTrackerPort,

        @SerializedName("limit_lan_peers")
        boolean limitLanPeers,

        @SerializedName("max_ratio_enabled")
        boolean maxRatioEnabled,

        @SerializedName("web_ui_domain_list")
        String webUiDomainList,

        @SerializedName("proxy_password")
        String proxyPassword,

        @SerializedName("alternative_webui_path")
        String alternativeWebuiPath,

        @SerializedName("announce_to_all_trackers")
        boolean announceToAllTrackers,

        @SerializedName("send_buffer_watermark")
        long sendBufferWatermark,

        @SerializedName("torrent_changed_tmm_enabled")
        boolean torrentChangedTmmEnabled,

        @SerializedName("dl_limit")
        long dlLimit,

        @SerializedName("autorun_program")
        String autorunProgram,

        @SerializedName("async_io_threads")
        long asyncIoThreads,

        @SerializedName("resolve_peer_countries")
        boolean resolvePeerCountries,

        @SerializedName("web_ui_clickjacking_protection_enabled")
        boolean webUiClickjackingProtectionEnabled,

        @SerializedName("bypass_auth_subnet_whitelist_enabled")
        boolean bypassAuthSubnetWhitelistEnabled,

        @SerializedName("rss_auto_downloading_enabled")
        boolean rssAutoDownloadingEnabled,

        @SerializedName("temp_path_enabled")
        boolean tempPathEnabled,

        @SerializedName("pex")
        boolean pex,

        @SerializedName("incomplete_files_ext")
        boolean incompleteFilesExt,

        @SerializedName("send_buffer_low_watermark")
        long sendBufferLowWatermark,

        @SerializedName("preallocate_all")
        boolean preallocateAll,

        @SerializedName("dyndns_username")
        String dyndnsUsername,

        @SerializedName("current_network_interface")
        String currentNetworkInterface,

        @SerializedName("autorun_enabled")
        boolean autorunEnabled,

        @SerializedName("scheduler_days")
        long schedulerDays,

        @SerializedName("limit_tcp_overhead")
        boolean limitTcpOverhead,

        @SerializedName("mail_notification_ssl_enabled")
        boolean mailNotificationSslEnabled,

        @SerializedName("proxy_peer_connections")
        boolean proxyPeerConnections,

        @SerializedName("dyndns_enabled")
        boolean dyndnsEnabled,

        @SerializedName("enable_super_seeding")
        boolean enableSuperSeeding,

        @SerializedName("random_port")
        boolean randomPort,

        @SerializedName("anonymous_mode")
        boolean anonymousMode,

        @SerializedName("rss_max_articles_per_feed")
        long rssMaxArticlesPerFeed,

        @SerializedName("ip_filter_enabled")
        boolean ipFilterEnabled,

        @SerializedName("mail_notification_smtp")
        String mailNotificationSmtp,

        @SerializedName("web_ui_https_cert_path")
        String webUiHttpsCertPath,

        @SerializedName("enable_coalesce_read_write")
        boolean enableCoalesceReadWrite,

        @SerializedName("banned_IPs")
        String bannedIPs,

        @SerializedName("schedule_to_hour")
        long scheduleToHour,

        @SerializedName("rss_processing_enabled")
        boolean rssProcessingEnabled,

        @SerializedName("save_path")
        String savePath,

        @SerializedName("save_path_changed_tmm_enabled")
        boolean savePathChangedTmmEnabled,

        @SerializedName("encryption")
        long encryption,

        @SerializedName("proxy_auth_enabled")
        boolean proxyAuthEnabled,

        @SerializedName("ip_filter_path")
        String ipFilterPath,

        @SerializedName("web_ui_csrf_protection_enabled")
        boolean webUiCsrfProtectionEnabled,

        @SerializedName("max_ratio_act")
        long maxRatioAct,

        @SerializedName("mail_notification_email")
        String mailNotificationEmail,

        @SerializedName("proxy_username")
        String proxyUsername,

        @SerializedName("web_ui_address")
        String webUiAddress,

        @SerializedName("max_connec")
        long maxConnec,

        @SerializedName("announce_ip")
        String announceIp,

        @SerializedName("export_dir_fin")
        String exportDirFin,

        @SerializedName("add_trackers")
        String addTrackers,

        @SerializedName("dht")
        boolean dht,

        @SerializedName("send_buffer_watermark_factor")
        long sendBufferWatermarkFactor,

        @SerializedName("web_ui_username")
        String webUiUsername,

        @SerializedName("current_interface_address")
        String currentInterfaceAddress,

        @SerializedName("slow_torrent_dl_rate_threshold")
        long slowTorrentDlRateThreshold,

        @SerializedName("max_seeding_time")
        long maxSeedingTime,

        @SerializedName("web_ui_host_header_validation_enabled")
        boolean webUiHostHeaderValidationEnabled,

        @SerializedName("dont_count_slow_torrents")
        boolean dontCountSlowTorrents,

        @SerializedName("schedule_from_hour")
        long scheduleFromHour,

        @SerializedName("use_https")
        boolean useHttps,

        @SerializedName("proxy_type")
        long proxyType,

        @SerializedName("disk_cache")
        long diskCache,

        @SerializedName("max_ratio")
        double maxRatio,

        @SerializedName("rss_refresh_interval")
        long rssRefreshInterval,

        @SerializedName("web_ui_port")
        long webUiPort,

        @SerializedName("upload_slots_behavior")
        long uploadSlotsBehavior,

        @SerializedName("limit_utp_rate")
        boolean limitUtpRate,

        @SerializedName("bittorrent_protocol")
        long bittorrentProtocol,

        @SerializedName("disk_cache_ttl")
        long diskCacheTtl,

        @SerializedName("dyndns_password")
        String dyndnsPassword,

        @SerializedName("bypass_local_auth")
        boolean bypassLocalAuth,

        @SerializedName("upload_choking_algorithm")
        long uploadChokingAlgorithm,

        @SerializedName("enable_os_cache")
        boolean enableOsCache,

        @SerializedName("ip_filter_trackers")
        boolean ipFilterTrackers,

        @SerializedName("schedule_from_min")
        long scheduleFromMin,

        @SerializedName("queueing_enabled")
        boolean queueingEnabled,

        @SerializedName("category_changed_tmm_enabled")
        boolean categoryChangedTmmEnabled,

        @SerializedName("max_seeding_time_enabled")
        boolean maxSeedingTimeEnabled,

        @SerializedName("max_uploads_per_torrent")
        long maxUploadsPerTorrent,

        @SerializedName("socket_backlog_size")
        long socketBacklogSize,

        @SerializedName("web_ui_upnp")
        boolean webUiUpnp,

        @SerializedName("proxy_port")
        long proxyPort,

        @SerializedName("bypass_auth_subnet_whitelist")
        String bypassAuthSubnetWhitelist,

        @SerializedName("listen_port")
        long listenPort,

        @SerializedName("mail_notification_sender")
        String mailNotificationSender,

        @SerializedName("upnp")
        boolean upnp,

        @SerializedName("create_subfolder_enabled")
        boolean createSubfolderEnabled,

        @SerializedName("alt_up_limit")
        long altUpLimit,

        @SerializedName("max_active_downloads")
        long maxActiveDownloads,

        @SerializedName("slow_torrent_inactive_timer")
        long slowTorrentInactiveTimer,

        @SerializedName("max_active_uploads")
        long maxActiveUploads,

        @SerializedName("lsd")
        boolean lsd,

        @SerializedName("utp_tcp_mixed_mode")
        long utpTcpMixedMode,

        @SerializedName("auto_delete_mode")
        long autoDeleteMode,

        @SerializedName("outgoing_ports_min")
        long outgoingPortsMin,

        @SerializedName("slow_torrent_ul_rate_threshold")
        long slowTorrentUlRateThreshold,

        @SerializedName("web_ui_https_key_path")
        String webUiHttpsKeyPath,

        @SerializedName("enable_multi_connections_from_same_ip")
        boolean enableMultiConnectionsFromSameIp,

        @SerializedName("proxy_torrents_only")
        boolean proxyTorrentsOnly,

        @SerializedName("locale")
        String locale,

        @SerializedName("alternative_webui_enabled")
        boolean alternativeWebuiEnabled,

        @SerializedName("max_connec_per_torrent")
        long maxConnecPerTorrent,

        @SerializedName("alt_dl_limit")
        long altDlLimit,

        @SerializedName("recheck_completed_torrents")
        boolean recheckCompletedTorrents,

        @SerializedName("enable_upload_suggestions")
        boolean enableUploadSuggestions,

        @SerializedName("mail_notification_password")
        String mailNotificationPassword,

        @SerializedName("save_resume_data_interval")
        long saveResumeDataInterval,

        @SerializedName("schedule_to_min")
        long scheduleToMin,

        @SerializedName("dyndns_service")
        long dyndnsService,

        @SerializedName("dyndns_domain")
        String dyndnsDomain,

        @SerializedName("temp_path")
        String tempPath,

        @SerializedName("proxy_ip")
        String proxyIp,

        @SerializedName("announce_to_all_tiers")
        boolean announceToAllTiers,

        @SerializedName("max_uploads")
        long maxUploads,

        @SerializedName("enable_embedded_tracker")
        boolean enableEmbeddedTracker,

        @SerializedName("mail_notification_enabled")
        boolean mailNotificationEnabled,

        @SerializedName("web_ui_session_timeout")
        long webUiSessionTimeout,

        @SerializedName("file_pool_size")
        long filePoolSize,

        @SerializedName("start_paused_enabled")
        boolean startPausedEnabled,

        @SerializedName("add_trackers_enabled")
        boolean addTrackersEnabled,

        @SerializedName("checking_memory_use")
        long checkingMemoryUse,

        @SerializedName("mail_notification_auth_enabled")
        boolean mailNotificationAuthEnabled,

        @SerializedName("up_limit")
        long upLimit,

        @SerializedName("scheduler_enabled")
        boolean schedulerEnabled,

        @SerializedName("auto_tmm_enabled")
        boolean autoTmmEnabled,

        @SerializedName("outgoing_ports_max")
        long outgoingPortsMax,

        @SerializedName("max_active_torrents")
        long maxActiveTorrents,

        @SerializedName("mail_notification_username")
        String mailNotificationUsername,

        @SerializedName("export_dir")
        String exportDir) {
}
