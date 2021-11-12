package com.ycourlee.explore.notes.mapstruct.converter;

import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author yongjiang
 * @date 2021.10.26
 */
@Mapper
public interface AutomaticConversionTypeConverter {

    AutomaticConversionTypeConverter INSTANCE = Mappers.getMapper(AutomaticConversionTypeConverter.class);

    Dto asDto(Entity entity);

    @Setter
    @Getter
    class Entity {

        private byte   aByte;
        private char   aChar;
        private float  aFloat;
        private double aDouble;
        private int    anInt;
        private long   aLong;
        private short  aShort;
    }

    @Setter
    @Getter
    class Dto {

        private Byte      aByte;
        private Character aChar;
        private Float     aFloat;
        private Double    aDouble;
        private Integer   anInt;
        private Long      aLong;
        private Short     aShort;
    }
}
