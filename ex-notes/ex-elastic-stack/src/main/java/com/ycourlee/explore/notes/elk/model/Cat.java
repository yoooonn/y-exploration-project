package com.ycourlee.explore.notes.elk.model;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author yongjiang
 * @date 2022.03.04
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Cat {

    private Integer id;
    private String name;
}
