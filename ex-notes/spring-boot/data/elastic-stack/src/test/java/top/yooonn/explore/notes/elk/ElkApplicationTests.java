package top.yooonn.explore.notes.elk;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author yooonn
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ElkApplicationTests {

    protected static final String INDEX = "kibana_sample_data_logs";
}
