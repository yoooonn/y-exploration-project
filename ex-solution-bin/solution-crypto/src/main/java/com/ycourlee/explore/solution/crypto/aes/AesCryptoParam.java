package com.ycourlee.explore.solution.crypto.aes;

import com.ycourlee.explore.solution.crypto.util.StarMasker;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author yongjiang
 * @date 2021.12.10
 */
@Setter
@Getter
@Accessors(chain = true)
public class AesCryptoParam {

    private String rawKey;

    private String transform;

    @Override
    public String toString() {
        return "AesCryptoParam{" +
                "rawKey='" + StarMasker.mask(rawKey, 2) + '\'' +
                ", aesTransform='" + transform + '\'' +
                '}';
    }
}
