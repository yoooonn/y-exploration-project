package com.ycourlee.explore.solution.crypto.factories;

import com.ycourlee.explore.solution.crypto.BCJcaJceHelperHolder;
import com.ycourlee.explore.solution.crypto.CipherAlgMode;
import com.ycourlee.explore.solution.crypto.aes.CipherParam;
import com.ycourlee.explore.solution.crypto.util.Assert;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;

/**
 * @author yongjiang
 * @date 2021.12.10
 */
public class DefaultCipherFactory extends BCJcaJceHelperHolder implements Factory<Cipher, CipherParam> {

    @Override
    public Cipher generate(CipherParam cipherParam) throws Exception {
        Assert.notNull(cipherParam.getTransform(), "No transform given");
        Assert.notNull(cipherParam.getMode(), "No cipher mode given");
        Assert.notNull(cipherParam.getSecretKey(), "No secret key given");
        Cipher cipher = helper.createCipher(cipherParam.getTransform());
        if (CipherAlgMode.CBC.equals(cipherParam.extractMode())) {
            Assert.notNull(cipherParam.getCbcModeIv(), "No cbc mode IV");
            cipher.init(cipherParam.getMode(), cipherParam.getSecretKey(), new IvParameterSpec(cipherParam.getCbcModeIv().getBytes(StandardCharsets.UTF_8)));
        } else {
            cipher.init(cipherParam.getMode(), cipherParam.getSecretKey());
        }
        return cipher;
    }
}
