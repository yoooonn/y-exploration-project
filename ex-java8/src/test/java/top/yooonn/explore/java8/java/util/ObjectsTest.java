package top.yooonn.explore.java8.java.util;

import org.junit.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yooonn
 * @date 2023.01.05
 */
public class ObjectsTest {

    @Test
    public void mainTest() {
        Byte a = ((byte) 13);
        Integer b = 13;
        assertThat(Objects.equals(a, b)).isFalse();
        assertThat(Objects.equals(a.intValue(), b)).isTrue();
    }
}
