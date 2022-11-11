package com.ycourlee.explore.notes.mapstruct.converter.date;

import lombok.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;

/**
 * @author yooonn
 * @date 2021.10.21
 */
@Mapper
public interface DateConverter {

    DateConverter INSTANCE = Mappers.getMapper(DateConverter.class);

    @Mapping(target = "date", expression = "java(entity.getDate().getTime())")
    Dto asDto(Entity entity);

    @Setter
    @Getter
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    class Entity {

        private Date date;
    }

    @Setter
    @Getter
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    class Dto {

        private Long date;
    }
}
