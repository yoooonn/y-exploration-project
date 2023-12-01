package top.yooonn.explore.faste.spring.boot.data.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DatabaseDriver;

/**
 * @author yooonn
 * @date 2022.10.29
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "faste.data")
public class FasteDataConfiguration {

    private DbConfig db;

    @Setter
    @Getter
    public static class DbConfig {

        private DatabaseDriver dbType;

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
}
