package com.ycourlee.explore.solution.crypto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author yongjiang
 * @date 2021.02.03
 */
public class AesUtil {

    public static final String DEFAULT_KEY = "!*t!xI&cGp3&4Wl4";
    private static final Logger log = LoggerFactory.getLogger(AesUtil.class);
    private static final int BUFFER_SIZE = 512;
    /**
     * 算法/加密模式/补码填充方式
     */
    private static final String AES_TRANSFORM_PKCS5P = "AES/ECB/PKCS5Padding";

    /**
     * update()？？
     *
     * @param data 数据
     * @param key  密钥
     * @return 加密后的数据
     */
    public static byte[] encrypt(byte[] data, String key) {
        if (key.length() != 16) {
            return null;
        }
        try {
            if (data == null || data.length == 0) {
                return null;
            }
            byte[] raw = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKey = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(AES_TRANSFORM_PKCS5P);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        } catch (Exception ignored) {
        }
        return null;
    }

    /**
     * @param data 数据
     * @param key  密钥
     * @return 解密后的数据
     */
    public static byte[] decrypt(byte[] data, String key) {
        if (key.length() != 16) {
            return null;
        }
        try {
            if (data == null || data.length == 0) {
                return null;
            }
            byte[] raw = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKey = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(AES_TRANSFORM_PKCS5P);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);


            return cipher.doFinal(data);
        } catch (Exception ignored) {
        }
        return null;
    }

    /**
     * 等效 select to_base64(AES_ENCRYPT(plaintext, key));
     *
     * @param plaintext 明文
     * @param key       密钥
     * @return 密文
     */
    public static String ciphertext(String plaintext, String key) {
        byte[] encrypt = encrypt(plaintext.getBytes(StandardCharsets.UTF_8), key);
        return encrypt == null ? null : Base64.getEncoder().encodeToString(encrypt);
    }

    public static String ciphertext(String plaintext) {
        return ciphertext(plaintext, DEFAULT_KEY);
    }

    /**
     * 等效 select AES_DECRYPT(from_base64(ciphertext), key);
     *
     * @param ciphertext 密文
     * @param key        密钥
     * @return 明文
     */
    public static String plaintext(String ciphertext, String key) {
        byte[] decrypt = decrypt(Base64.getDecoder().decode(ciphertext.getBytes(StandardCharsets.UTF_8)), key);
        return decrypt == null ? null : new String(decrypt);
    }

    public static String plaintext(String ciphertext) {
        return plaintext(ciphertext, DEFAULT_KEY);
    }
}