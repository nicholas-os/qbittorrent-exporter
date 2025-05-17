package qbittorrent.api.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public record Preferences(

        @JsonProperty("embedded_tracker_port")
        long embeddedTrackerPort,

        @JsonProperty("limit_lan_peers")
        boolean limitLanPeers,

        @JsonProperty("max_ratio_enabled")
        boolean maxRatioEnabled,

        @JsonProperty("web_ui_domain_list")
        String webUiDomainList,

        @JsonProperty("proxy_password")
        String proxyPassword,

        @JsonProperty("alternative_webui_path")
        String alternativeWebuiPath,

        @JsonProperty("announce_to_all_trackers")
        boolean announceToAllTrackers,

        @JsonProperty("send_buffer_watermark")
        long sendBufferWatermark,

        @JsonProperty("torrent_changed_tmm_enabled")
        boolean torrentChangedTmmEnabled,

        @JsonProperty("dl_limit")
        long dlLimit,

        @JsonProperty("autorun_program")
        String autorunProgram,

        @JsonProperty("async_io_threads")
        long asyncIoThreads,

        @JsonProperty("resolve_peer_countries")
        boolean resolvePeerCountries,

        @JsonProperty("web_ui_clickjacking_protection_enabled")
        boolean webUiClickjackingProtectionEnabled,

        @JsonProperty("bypass_auth_subnet_whitelist_enabled")
        boolean bypassAuthSubnetWhitelistEnabled,

        @JsonProperty("rss_auto_downloading_enabled")
        boolean rssAutoDownloadingEnabled,

        @JsonProperty("temp_path_enabled")
        boolean tempPathEnabled,

        @JsonProperty("pex")
        boolean pex,

        @JsonProperty("incomplete_files_ext")
        boolean incompleteFilesExt,

        @JsonProperty("send_buffer_low_watermark")
        long sendBufferLowWatermark,

        @JsonProperty("preallocate_all")
        boolean preallocateAll,

        @JsonProperty("dyndns_username")
        String dyndnsUsername,

        @JsonProperty("current_network_interface")
        String currentNetworkInterface,

        @JsonProperty("autorun_enabled")
        boolean autorunEnabled,

        @JsonProperty("scheduler_days")
        long schedulerDays,

        @JsonProperty("limit_tcp_overhead")
        boolean limitTcpOverhead,

        @JsonProperty("mail_notification_ssl_enabled")
        boolean mailNotificationSslEnabled,

        @JsonProperty("proxy_peer_connections")
        boolean proxyPeerConnections,

        @JsonProperty("dyndns_enabled")
        boolean dyndnsEnabled,

        @JsonProperty("enable_super_seeding")
        boolean enableSuperSeeding,

        @JsonProperty("random_port")
        boolean randomPort,

        @JsonProperty("anonymous_mode")
        boolean anonymousMode,

        @JsonProperty("rss_max_articles_per_feed")
        long rssMaxArticlesPerFeed,

        @JsonProperty("ip_filter_enabled")
        boolean ipFilterEnabled,

        @JsonProperty("mail_notification_smtp")
        String mailNotificationSmtp,

        @JsonProperty("web_ui_https_cert_path")
        String webUiHttpsCertPath,

        @JsonProperty("enable_coalesce_read_write")
        boolean enableCoalesceReadWrite,

        @JsonProperty("banned_IPs")
        String bannedIPs,

        @JsonProperty("schedule_to_hour")
        long scheduleToHour,

        @JsonProperty("rss_processing_enabled")
        boolean rssProcessingEnabled,

        @JsonProperty("save_path")
        String savePath,

        @JsonProperty("save_path_changed_tmm_enabled")
        boolean savePathChangedTmmEnabled,

        @JsonProperty("encryption")
        long encryption,

        @JsonProperty("proxy_auth_enabled")
        boolean proxyAuthEnabled,

        @JsonProperty("ip_filter_path")
        String ipFilterPath,

        @JsonProperty("web_ui_csrf_protection_enabled")
        boolean webUiCsrfProtectionEnabled,

        @JsonProperty("max_ratio_act")
        long maxRatioAct,

        @JsonProperty("mail_notification_email")
        String mailNotificationEmail,

        @JsonProperty("proxy_username")
        String proxyUsername,

        @JsonProperty("web_ui_address")
        String webUiAddress,

        @JsonProperty("max_connec")
        long maxConnec,

        @JsonProperty("announce_ip")
        String announceIp,

        @JsonProperty("export_dir_fin")
        String exportDirFin,

        @JsonProperty("add_trackers")
        String addTrackers,

        @JsonProperty("dht")
        boolean dht,

        @JsonProperty("send_buffer_watermark_factor")
        long sendBufferWatermarkFactor,

        @JsonProperty("web_ui_username")
        String webUiUsername,

        @JsonProperty("current_interface_address")
        String currentInterfaceAddress,

        @JsonProperty("slow_torrent_dl_rate_threshold")
        long slowTorrentDlRateThreshold,

        @JsonProperty("max_seeding_time")
        long maxSeedingTime,

        @JsonProperty("web_ui_host_header_validation_enabled")
        boolean webUiHostHeaderValidationEnabled,

        @JsonProperty("dont_count_slow_torrents")
        boolean dontCountSlowTorrents,

        @JsonProperty("schedule_from_hour")
        long scheduleFromHour,

        @JsonProperty("use_https")
        boolean useHttps,

        @JsonProperty("proxy_type")
        long proxyType,

        @JsonProperty("disk_cache")
        long diskCache,

        @JsonProperty("max_ratio")
        double maxRatio,

        @JsonProperty("rss_refresh_interval")
        long rssRefreshInterval,

        @JsonProperty("web_ui_port")
        long webUiPort,

        @JsonProperty("upload_slots_behavior")
        long uploadSlotsBehavior,

        @JsonProperty("limit_utp_rate")
        boolean limitUtpRate,

        @JsonProperty("bittorrent_protocol")
        long bittorrentProtocol,

        @JsonProperty("disk_cache_ttl")
        long diskCacheTtl,

        @JsonProperty("dyndns_password")
        String dyndnsPassword,

        @JsonProperty("bypass_local_auth")
        boolean bypassLocalAuth,

        @JsonProperty("upload_choking_algorithm")
        long uploadChokingAlgorithm,

        @JsonProperty("enable_os_cache")
        boolean enableOsCache,

        @JsonProperty("ip_filter_trackers")
        boolean ipFilterTrackers,

        @JsonProperty("schedule_from_min")
        long scheduleFromMin,

        @JsonProperty("queueing_enabled")
        boolean queueingEnabled,

        @JsonProperty("category_changed_tmm_enabled")
        boolean categoryChangedTmmEnabled,

        @JsonProperty("max_seeding_time_enabled")
        boolean maxSeedingTimeEnabled,

        @JsonProperty("max_uploads_per_torrent")
        long maxUploadsPerTorrent,

        @JsonProperty("socket_backlog_size")
        long socketBacklogSize,

        @JsonProperty("web_ui_upnp")
        boolean webUiUpnp,

        @JsonProperty("proxy_port")
        long proxyPort,

        @JsonProperty("bypass_auth_subnet_whitelist")
        String bypassAuthSubnetWhitelist,

        @JsonProperty("listen_port")
        long listenPort,

        @JsonProperty("mail_notification_sender")
        String mailNotificationSender,

        @JsonProperty("upnp")
        boolean upnp,

        @JsonProperty("create_subfolder_enabled")
        boolean createSubfolderEnabled,

        @JsonProperty("alt_up_limit")
        long altUpLimit,

        @JsonProperty("max_active_downloads")
        long maxActiveDownloads,

        @JsonProperty("slow_torrent_inactive_timer")
        long slowTorrentInactiveTimer,

        @JsonProperty("max_active_uploads")
        long maxActiveUploads,

        @JsonProperty("lsd")
        boolean lsd,

        @JsonProperty("utp_tcp_mixed_mode")
        long utpTcpMixedMode,

        @JsonProperty("auto_delete_mode")
        long autoDeleteMode,

        @JsonProperty("outgoing_ports_min")
        long outgoingPortsMin,

        @JsonProperty("slow_torrent_ul_rate_threshold")
        long slowTorrentUlRateThreshold,

        @JsonProperty("web_ui_https_key_path")
        String webUiHttpsKeyPath,

        @JsonProperty("enable_multi_connections_from_same_ip")
        boolean enableMultiConnectionsFromSameIp,

        @JsonProperty("proxy_torrents_only")
        boolean proxyTorrentsOnly,

        @JsonProperty("locale")
        String locale,

        @JsonProperty("alternative_webui_enabled")
        boolean alternativeWebuiEnabled,

        @JsonProperty("max_connec_per_torrent")
        long maxConnecPerTorrent,

        @JsonProperty("alt_dl_limit")
        long altDlLimit,

        @JsonProperty("recheck_completed_torrents")
        boolean recheckCompletedTorrents,

        @JsonProperty("enable_upload_suggestions")
        boolean enableUploadSuggestions,

        @JsonProperty("mail_notification_password")
        String mailNotificationPassword,

        @JsonProperty("save_resume_data_interval")
        long saveResumeDataInterval,

        @JsonProperty("schedule_to_min")
        long scheduleToMin,

        @JsonProperty("dyndns_service")
        long dyndnsService,

        @JsonProperty("dyndns_domain")
        String dyndnsDomain,

        @JsonProperty("temp_path")
        String tempPath,

        @JsonProperty("proxy_ip")
        String proxyIp,

        @JsonProperty("announce_to_all_tiers")
        boolean announceToAllTiers,

        @JsonProperty("max_uploads")
        long maxUploads,

        @JsonProperty("enable_embedded_tracker")
        boolean enableEmbeddedTracker,

        @JsonProperty("mail_notification_enabled")
        boolean mailNotificationEnabled,

        @JsonProperty("web_ui_session_timeout")
        long webUiSessionTimeout,

        @JsonProperty("file_pool_size")
        long filePoolSize,

        @JsonProperty("start_paused_enabled")
        boolean startPausedEnabled,

        @JsonProperty("add_trackers_enabled")
        boolean addTrackersEnabled,

        @JsonProperty("checking_memory_use")
        long checkingMemoryUse,

        @JsonProperty("mail_notification_auth_enabled")
        boolean mailNotificationAuthEnabled,

        @JsonProperty("up_limit")
        long upLimit,

        @JsonProperty("scheduler_enabled")
        boolean schedulerEnabled,

        @JsonProperty("auto_tmm_enabled")
        boolean autoTmmEnabled,

        @JsonProperty("outgoing_ports_max")
        long outgoingPortsMax,

        @JsonProperty("max_active_torrents")
        long maxActiveTorrents,

        @JsonProperty("mail_notification_username")
        String mailNotificationUsername,

        @JsonProperty("export_dir")
        String exportDir) {
}
