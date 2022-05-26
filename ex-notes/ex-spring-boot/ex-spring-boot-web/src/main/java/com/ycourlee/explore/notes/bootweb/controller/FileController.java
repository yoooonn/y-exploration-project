package com.ycourlee.explore.notes.bootweb.controller;

import com.ycourlee.explore.notes.bootweb.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yooonn
 * @date 2021.11.17
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;
}
