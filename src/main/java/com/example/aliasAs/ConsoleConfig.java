package com.example.aliasAs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ConsoleConfig {
    @JsonProperty("TCustomView")
    private Map<String, String> TCustomView;
    @JsonProperty("BCustomView")
    private Map<String, String> BCustomView;
    @JsonProperty("LCustomView")
    private Map<String, String> LCustomView;
    @JsonProperty("RCustomView")
    private Map<String, String> RCustomView;
    private Map<String, String> paramConsole;
    private Map<String, String> leaderboardConfig;
    private String lobbyUrl;
    private String cashiertype;
    @JsonIgnore
    public Map<String, String> getTCustomView() {
        return TCustomView;
    }

    public void setTCustomView(Map<String, String> TCustomView) {
        this.TCustomView = TCustomView;
    }
    @JsonIgnore
    public Map<String, String> getBCustomView() {
        return BCustomView;
    }

    public void setBCustomView(Map<String, String> BCustomView) {
        this.BCustomView = BCustomView;
    }
    @JsonIgnore
    public Map<String, String> getLCustomView() {
        return LCustomView;
    }

    public void setLCustomView(Map<String, String> LCustomView) {
        this.LCustomView = LCustomView;
    }
    @JsonIgnore
    public Map<String, String> getRCustomView() {
        return RCustomView;
    }

    public void setRCustomView(Map<String, String> RCustomView) {
        this.RCustomView = RCustomView;
    }

    public Map<String, String> getParamConsole() {
        return paramConsole;
    }

    public void setParamConsole(Map<String, String> paramConsole) {
        this.paramConsole = paramConsole;
    }

    public Map<String, String> getLeaderboardConfig() {
        return leaderboardConfig;
    }

    public void setLeaderboardConfig(Map<String, String> leaderboardConfig) {
        this.leaderboardConfig = leaderboardConfig;
    }

    public String getLobbyUrl() {
        return lobbyUrl;
    }

    public void setLobbyUrl(String lobbyUrl) {
        this.lobbyUrl = lobbyUrl;
    }

    public String getCashiertype() {
        return cashiertype;
    }

    public void setCashiertype(String cashiertype) {
        this.cashiertype = cashiertype;
    }
}
