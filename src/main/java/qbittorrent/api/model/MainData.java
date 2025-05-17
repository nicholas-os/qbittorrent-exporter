package qbittorrent.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MainData(@JsonProperty("server_state") ServerState serverState) {}
