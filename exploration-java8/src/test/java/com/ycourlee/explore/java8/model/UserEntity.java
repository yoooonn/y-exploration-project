package com.ycourlee.explore.java8.model;

import lombok.Builder;
import lombok.ToString;

/**
 * @author yongjiang
 * @date 2021.04.08
 */
@Builder
@ToString
public class UserEntity {

    private Long   id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
