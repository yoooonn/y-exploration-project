package com.ycourlee.explore.bootprocess.controller;

import com.ycourlee.root.core.domain.context.Rtm;
import com.ycourlee.root.mocks.UnitTestResource;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;
import java.io.IOException;

/**
 * @author yongjiang
 * @date 2021.08.23
 */
@RestController
@RequestMapping("/multipart")
public class MultipartRequestController extends UnitTestResource {

    @PostMapping("/upload")
    public Rtm uploadFile(@NonNull @RequestParam MultipartRequest request) {
        MultipartFile image = request.getFile("image");
        if (image == null) {
            return Rtm.error();
        }
        String filename = image.getOriginalFilename();
        try {
            image.transferTo(new File(TEMP_DIR + "/upload-image-" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
