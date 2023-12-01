package top.yooonn.explore.java8.java.util.stream;

import top.yooonn.explore.java8.AbstractTest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yooonn
 * @date 2022.03.29
 */
public class StreamTests extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(StreamTests.class);

    @Test
    public void testMapReturnNull() {
        List<Foo> foos = Arrays.asList(new Foo().setFoo(1), new Foo().setFoo(null), new Foo().setFoo(3));
        List<Integer> fooIntegers = foos.stream().map(Foo::getFoo).filter(Objects::nonNull).sorted().collect(Collectors.toList());
        assertThat(fooIntegers.size()).isEqualTo(2);
        assertThat(fooIntegers).contains(1);
        assertThat(fooIntegers).contains(3);
    }

    @Test
    public void mainTest() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4);

        boolean match = data.stream().allMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                boolean b = integer % 2 == 0;
                log.info("integer: {}", integer);
                return b;
            }
        });

        log.info("match: {}", match);
    }

    @Setter
    @Getter
    @ToString
    @Accessors(chain = true)
    static class Foo {

        private Integer foo;
    }
}
