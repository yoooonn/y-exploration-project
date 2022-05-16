package com.ycourlee.explore.javalib.util;

import com.google.zxing.WriterException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author yooonn
 * @date 2022.05.11
 */
public class QrCodeUtilTests {

    private static final Logger log = LoggerFactory.getLogger(QrCodeUtilTests.class);

    @Test
    void mainTest() throws IOException, WriterException {
        String fooTextQrCode = QrCodeUtils.getQRCodeImageInBase64("foo text", 300, 300);
        String baidu = QrCodeUtils.getQRCodeImageInBase64("https://www.baidu.com", 300, 300);
        log.info("fooTextQrCode: {}", fooTextQrCode);
        log.info("baidu: {}", baidu);
    }
}
