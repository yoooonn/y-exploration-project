package com.ycourlee.explore.solution.crypto.aes;

import com.ycourlee.explore.solution.crypto.CipherAlgMode;
import com.ycourlee.explore.solution.crypto.Constant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

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

    private String cbcModeIv;

    @Nullable
    public CipherAlgMode extractMode() {
        if (StringUtils.isEmpty(transform)) {
            return null;
        }
        String[] split = transform.split(Constant.SLASH, 3);
        if (split.length == 3) {
            return CipherAlgMode.valueOf(split[1].toUpperCase());
        }
        return null;
    }
}
