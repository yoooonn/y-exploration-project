package com.ycourlee.explore.solution.excel;

import com.ycourlee.tranquil.core.CommonConstants;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jiangyong
 */
public class AbstractEnvironment extends CommonConstants {

    protected InputStream recoveryFromEncodedString(String encodedString) {
        byte[] bytes = Base64Utils.decodeFromString(encodedString);
        return new ByteArrayInputStream(bytes);
    }

    protected static String asEncodedStringFromFile(String file) {
        FileInputStream inputStream;
        String encodedFileStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
            encodedFileStream = Base64Utils.encodeToString(bytes);
            System.out.println("encodedFileStream = " + encodedFileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedFileStream;
    }
}
