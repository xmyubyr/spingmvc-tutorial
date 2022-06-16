package com.example.aliasAs;

import java.util.Map;

public class KernelConfig {
    private String splashUrl;
    private String serverType;
    private String platformVersion;
    private String loglevel;
    private Map<String, String> paramSplash;

    public String getSplashUrl() {
        return splashUrl;
    }

    public void setSplashUrl(String splashUrl) {
        this.splashUrl = splashUrl;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getLoglevel() {
        return loglevel;
    }

    public void setLoglevel(String loglevel) {
        this.loglevel = loglevel;
    }

    public Map<String, String> getParamSplash() {
        return paramSplash;
    }

    public void setParamSplash(Map<String, String> paramSplash) {
        this.paramSplash = paramSplash;
    }
}
