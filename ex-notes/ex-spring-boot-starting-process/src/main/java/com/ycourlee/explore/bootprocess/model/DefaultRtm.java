package com.ycourlee.explore.bootprocess.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yongjiang
 * @date 2022.02.18
 */
@Setter
@Getter
@ToString
@ApiModel
public class DefaultRtm {

    private Long timestamp;
    private String rid;
    private Integer code;
    private String msg;
    private Object data;
}
