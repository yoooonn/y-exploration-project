package top.yooonn.explore.notes.mapstruct.converter.property;

import lombok.*;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;

/**
 * @author yooonn
 * @date 2021.09.10
 */
@Mapper
@MapperConfig
public interface SamePropertyNameDiffPropertyTypeConverter {

    SamePropertyNameDiffPropertyTypeConverter INSTANCE = Mappers.getMapper(SamePropertyNameDiffPropertyTypeConverter.class);

    @Mapping(target = "valid", expression = "java(Helper.booleanAsInteger(entity.getValid()))")
    Dto asDto(Entity entity);

    @Mapping(source = "datetime", target = "datetimeString", dateFormat = "yyyy-MM-dd HH:mm:ss")
    Dto asDto2(Entity entity);

    /**
     * 当同名的属性不同类型时，自动选择以source中该属性名对应类型类型作为参数类型，以target中该属性名对应类型作为返回类型的方法
     * <p>
     * 当存在 TypeA methodA(TypeB)和TypeA methodB(TypeB) 时，此时会出现编译异常：...ambiguous...
     *
     * @param bool boolean
     * @return integer
     */
    default Integer booleanAsInteger(Boolean bool) {
        return bool != null && bool ? 1 : 0;
    }

    class Helper {

        /**
         * 当同名的属性不同类型时，
         *
         * @param bool
         * @return
         */
        static Integer booleanAsInteger(Boolean bool) {
            return bool != null && bool ? 1 : 0;
        }
    }

    @Setter
    @Getter
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    class Entity {

        private String  name;
        private Date    datetime;
        private Boolean valid;
    }

    @Setter
    @Getter
    @ToString
    class Dto {

        private String  name;
        private String  datetimeString;
        private Integer valid;
    }
}
