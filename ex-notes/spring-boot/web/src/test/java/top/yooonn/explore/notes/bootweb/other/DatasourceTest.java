package top.yooonn.explore.notes.bootweb.other;

import top.yooonn.explore.notes.bootweb.BootProcessApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;

/**
 * @author yooonn
 * @date 2022.12.14
 */
public class DatasourceTest extends BootProcessApplicationTests {

    private static final Logger            log = LoggerFactory.getLogger(DatasourceTest.class);
    @Autowired
    @Qualifier("dbHealthContributor")
    private              HealthContributor healthContributor;

    @Test
    public void mainTest() {
        DataSourceHealthIndicator dbIndicator = (DataSourceHealthIndicator) healthContributor;
        Health health = dbIndicator.getHealth(true);
        log.info("health: {}", health);
    }
}
