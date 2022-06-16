package com.example.aliasAs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientConfig {
    private ServerConfig serverConfig;
    private Map<String, String> deviceConfig;
    private KernelConfig kernelConfig;
    private ConsoleConfig consoleConfig;
    private Map<String, String> stringsConfig;
    private List<String> forceGetParamNames = new ArrayList();
    private Map<String, Object> gameConfig = new HashMap();
    private GameServiceConfig gameServiceConfig;

    public ServerConfig getServerConfig() {
        return serverConfig;
    }

    public void setServerConfig(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }

    public Map<String, String> getDeviceConfig() {
        return deviceConfig;
    }

    public void setDeviceConfig(Map<String, String> deviceConfig) {
        this.deviceConfig = deviceConfig;
    }

    public KernelConfig getKernelConfig() {
        return kernelConfig;
    }

    public void setKernelConfig(KernelConfig kernelConfig) {
        this.kernelConfig = kernelConfig;
    }

    public ConsoleConfig getConsoleConfig() {
        return consoleConfig;
    }

    public void setConsoleConfig(ConsoleConfig consoleConfig) {
        this.consoleConfig = consoleConfig;
    }

    public Map<String, String> getStringsConfig() {
        return stringsConfig;
    }

    public void setStringsConfig(Map<String, String> stringsConfig) {
        this.stringsConfig = stringsConfig;
    }

    public List<String> getForceGetParamNames() {
        return forceGetParamNames;
    }

    public void setForceGetParamNames(List<String> forceGetParamNames) {
        this.forceGetParamNames = forceGetParamNames;
    }

    public Map<String, Object> getGameConfig() {
        return gameConfig;
    }

    public void setGameConfig(Map<String, Object> gameConfig) {
        this.gameConfig = gameConfig;
    }

    public GameServiceConfig getGameServiceConfig() {
        return gameServiceConfig;
    }

    public void setGameServiceConfig(GameServiceConfig gameServiceConfig) {
        this.gameServiceConfig = gameServiceConfig;
    }
}
