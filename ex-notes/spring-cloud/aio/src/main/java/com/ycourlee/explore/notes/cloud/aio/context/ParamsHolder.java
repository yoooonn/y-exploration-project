package com.ycourlee.explore.notes.cloud.aio.context;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 * @date 2022.11.18
 */
@Component
@Getter
public class ParamsHolder {

    @Value("${flying.str:}")
    private String str;
}
