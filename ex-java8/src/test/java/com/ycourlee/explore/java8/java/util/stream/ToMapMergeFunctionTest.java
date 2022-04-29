package com.ycourlee.explore.java8.java.util.stream;

import com.ycourlee.tranquil.core.CommonConstants;
import lombok.ToString;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author yongjiang
 * @date 2021.09.08
 */
public class ToMapMergeFunctionTest extends CommonConstants {

    private static final Logger log = LoggerFactory.getLogger(ToMapMergeFunctionTest.class);
    private static List<Ok> data = new ArrayList<>();

    static {
        data.add(new Ok(1, 2));
        data.add(new Ok(1, 4));
        data.add(new Ok(1, 1));
        data.add(new Ok(1, 3));

        data.add(new Ok(2, 2));
        data.add(new Ok(2, 1));
        data.add(new Ok(2, 4));
        data.add(new Ok(2, 3));

        data.add(new Ok(3, 2));
        data.add(new Ok(3, 1));
        data.add(new Ok(3, 3));
        data.add(new Ok(3, 4));
    }

    @Test
    public void mainTest() {
        Map<Integer, Ok> map = data.stream().collect(Collectors.toMap(k -> k.id, v -> v, new BinaryOperator<Ok>() {
            @Override
            public Ok apply(Ok e1, Ok e2) {
                log.info("e1 {}", e1);
                log.info("e2 {}", e2);
                if (e1.weight > e2.weight) {
                    return e1;
                } else {
                    return e2;
                }
            }
        }));
        Assertions.assertThat(map).extractingByKey(1).extracting("weight").isEqualTo(4);
        Assertions.assertThat(map).extractingByKey(2).extracting("weight").isEqualTo(4);
        Assertions.assertThat(map).extractingByKey(3).extracting("weight").isEqualTo(4);
    }

    @ToString
    static class Ok {

        Integer id;
        Integer weight;

        public Ok(Integer id, Integer weight) {
            this.id = id;
            this.weight = weight;
        }

    }
}
