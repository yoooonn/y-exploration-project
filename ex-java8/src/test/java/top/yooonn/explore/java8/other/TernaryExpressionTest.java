package top.yooonn.explore.java8.other;

import top.yooonn.explore.java8.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author yooonn
 * @date 2021.04.08
 */
@Slf4j
public class TernaryExpressionTest {

    @Test
    public void judgesTest() {
        Long id = null;
        UserEntity build = UserEntity.builder().id(id == null || id == 0 ? null : id).build();
        log.info("build = {}", build);
    }
}
