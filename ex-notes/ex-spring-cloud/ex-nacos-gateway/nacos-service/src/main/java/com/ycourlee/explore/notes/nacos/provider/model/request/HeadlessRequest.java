package com.ycourlee.explore.notes.nacos.provider.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @author yongjiang
 * @date 2021.11.22
 */
@Setter
@Getter
@ToString
public class HeadlessRequest {

    @NotEmpty
    private String headless;
}
