package top.yooonn.explore.okhttp;

import top.yooonn.explore.okhttp.autoconfiguration.OkhttpAutoConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yooonn
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OkhttpAutoConfiguration.class})
@TestPropertySource("classpath:application.properties")
public class OkhttpApplicationTests {
}
