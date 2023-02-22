package com.person.gtech.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * java使用AES加密解密 AES-256-ECB加密，与mysql数据库AES加密算法通用
 * <p>
 * 数据库AES加密解密方式如下
 * -- 加密
 * SELECT to_base64(AES_ENCRYPT('password','1Ve2t5G%X0uopC81'));
 * -- 解密
 * SELECT AES_DECRYPT(from_base64('8G9m8VNJZctBNIyz9swKQw=='),'1Ve2t5G%X0uopC81');
 *
 * @author 彭心潮
 */
@Slf4j
public class EncryptUtils {

    private EncryptUtils() {
    }

    /**
     * 算法/加密模式/填充方式
     */
    private static final String AES_ECB_PKCS_5_PADDING = "AES/ECB/PKCS5Padding";

    private static final int KEY_LENGTH = 32;

    /**
     * 加密
     *
     * @param str 需要加密的字符串
     * @param key 密钥
     */
    public static String sha256Encrypt(String str, String key) {
        if (StringUtils.isAnyBlank(str, key)) {
            return str;
        }
        // 判断Key是否为32位
        if (key.length() != KEY_LENGTH) {
            return str;
        }

        byte[] raw = key.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, "AES");
        // "算法/模式/补码方式"
        try {
            Cipher cipher = Cipher.getInstance(AES_ECB_PKCS_5_PADDING);// NOSONAR
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypted = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
            // 此处使用BASE64做转码功能，同时能起到2次加密的作用
            return new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            log.error("Sha256加密异常, 加密字符:{}, 错误信息:{}", str, e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }


    public static boolean sha256Decrypt(String str, String key) {
        if (StringUtils.isAnyBlank(str, key)) {
            return true;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            //AES/ECB/PKCS5Padding 格式为 "算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance(AES_ECB_PKCS_5_PADDING);// NOSONAR
            //设置为解密模式，解密的key
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            //base64解密
            byte[] decodeBuffer = new BASE64Decoder().decodeBuffer(str);
            //aes解密
            byte[] bytes = cipher.doFinal(decodeBuffer);
            if (bytes.length == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}