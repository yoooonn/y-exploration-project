package com.ycourlee.explore.notes.bootweb.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yooonn
 * @date 2022.10.29
 */
@ConfigurationProperties(prefix = "custom.sql-runner.init")
public class SqlInitRunnerConfiguration {
    private boolean whenStart = true;

    private boolean whenDestroyed = false;

    private String scriptLocation = "classpath*:META-INF/init-sql-20221030.sql";

    public boolean isWhenStart() {
        return whenStart;
    }

    public void setWhenStart(boolean whenStart) {
        this.whenStart = whenStart;
    }

    public boolean isWhenDestroyed() {
        return whenDestroyed;
    }

    public void setWhenDestroyed(boolean whenDestroyed) {
        this.whenDestroyed = whenDestroyed;
    }

    public String getScriptLocation() {
        return scriptLocation;
    }

    public void setScriptLocation(String scriptLocation) {
        this.scriptLocation = scriptLocation;
    }
}
