package top.yooonn.explore.notes.bootweb.controller;

import top.yooonn.explore.notes.bootweb.service.FileService;
import com.ycourlee.tranquil.web.dto.Response;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yooonn
 * @date 2021.11.17
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);
    private final FileService fileService;

    @PostMapping("/upload")
    public Response upload(@RequestPart("file") MultipartFile file) {
        log.info("file size: {}", file.getSize());
        return Response.success();
    }
}
