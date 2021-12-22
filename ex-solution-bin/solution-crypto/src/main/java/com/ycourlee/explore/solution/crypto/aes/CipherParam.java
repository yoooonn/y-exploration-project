package com.ycourlee.explore.solution.crypto.aes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.crypto.SecretKey;

/**
 * @author yongjiang
 * @date 2021.12.10
 */
@Setter
@Getter
@ToString
public class CipherParam {

    private Integer mode;

    private SecretKey secretKey;

    private String transform;
}
