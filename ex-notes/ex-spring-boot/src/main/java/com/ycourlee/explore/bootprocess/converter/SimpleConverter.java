package com.ycourlee.explore.bootprocess.converter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yongjiang
 * @date 2021.11.03
 */
@Mapper(componentModel = "spring")
public interface SimpleConverter {

    Logger log = LoggerFactory.getLogger(SimpleConverter.class);

    E asE(Long id, String name);

    E asE(Long id, String name, @MappingTarget E e);

    EDto asEDto(E e);

    default String asString(Integer a) {
        log.info("long max {}", Long.MAX_VALUE);
        log.info("long min {}", Long.MIN_VALUE);

        log.info("integer max {}", Integer.MAX_VALUE);
        log.info("integer min {}", Integer.MIN_VALUE);

        return a.toString();
    }

    @Setter
    @Getter
    @ToString
    @Accessors(chain = true)
    class E {
        private Integer id;
        private String name;
    }

    @Setter
    @Getter
    @ToString
    class EDto {
        private Long id;
        private String name;
    }
}
