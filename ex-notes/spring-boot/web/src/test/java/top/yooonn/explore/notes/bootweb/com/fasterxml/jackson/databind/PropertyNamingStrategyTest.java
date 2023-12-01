package top.yooonn.explore.notes.bootweb.com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/**
 * @author yooonn
 * @date 2022.12.11
 */
public class PropertyNamingStrategyTest {

    private static final Logger log = LoggerFactory.getLogger(PropertyNamingStrategyTest.class);

    @Test
    public void mainTest() {
        String nihaoWorld = PropertyNamingStrategy.LOWER_CAMEL_CASE.nameForField(null, null, "niHao");
        assertThat(nihaoWorld).isEqualTo("niHao");
    }
}
