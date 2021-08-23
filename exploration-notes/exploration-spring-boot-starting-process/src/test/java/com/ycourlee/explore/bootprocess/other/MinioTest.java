package com.ycourlee.explore.bootprocess.other;

import com.ycourlee.explore.bootprocess.SpringTestEnv;
import com.ycourlee.root.storage.FileOperation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;

/**
 * @author yongjiang
 */
public class MinioTest extends SpringTestEnv {

    @Autowired
    private FileOperation fileOperation;

    @Test
    public void uploadTest() {
        fileOperation.upload(mockMultipartFile2());
    }

    private MultipartFile mockMultipartFile() {
        return new MockMultipartFile("a.txt", "hello, world".getBytes(StandardCharsets.UTF_8));
    }

    private MultipartFile mockMultipartFile2() {
        return new MockMultipartFile("a.txt", "a","text/plain","hello, world".getBytes(StandardCharsets.UTF_8));
    }
}
