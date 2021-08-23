package com.ycourlee.explore.okhttp;

import com.ycourlee.explore.okhttp.configuration.OkhttpConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jiangyong
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OkhttpConfiguration.class})
@TestPropertySource("classpath:application.properties")
public class OkhttpApplicationTests {
}
