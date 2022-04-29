package com.ycourlee.explore.notes.mapstruct.converter.nested;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Date;

/**
 * @author yongjiang
 * @date 2021.10.25
 */
@Mapper(uses = NestedClassPropertyConverter.CompanyConverter.class
)
public interface NestedClassPropertyConverter {

    NestedClassPropertyConverter INSTANCE = Mappers.getMapper(NestedClassPropertyConverter.class);

    @Mappings({
            @Mapping(target = "name", source = "user.name"),
    })
    Employee asEmployee(User user, Company company, String name);

    enum Status {
        OFFICIAL,
        NON_OFFICIAL
    }

    @Mapper
    interface CompanyConverter {

        @Mappings({
                @Mapping(target = "name", source = "name"),
                @Mapping(target = "belongingGroup", source = "group")
        })
        Company asCompany(String name, Group group);
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    class Company {

        private String name;
        private Date   buildupDate;
        private Group  belongingGroup;
    }

    @Setter
    @Getter
    class Group {

        private String  name;
        private Date    buildupDate;
        private Integer companies;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    class User {

        private String name;
    }

    @Setter
    @Getter
    class Employee {

        private String  name;
        private Status  status;
        private Company company;
    }
}
