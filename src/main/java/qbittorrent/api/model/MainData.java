package qbittorrent.api.model;

import com.google.gson.annotations.SerializedName;

public record MainData(@SerializedName("server_state")
                       ServerState serverState) {
}
