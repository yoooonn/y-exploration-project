package com.ycourlee.explore.notes.bootweb.controller;

import com.ycourlee.explore.basic.dao.ActorMapper;
import com.ycourlee.explore.notes.bootweb.service.ConcurrencyService;
import com.ycourlee.tranquil.web.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yooonn
 * @date 2022.06.23
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/concurrency")
public class ConcurrencyController {

    private final ConcurrencyService concurrencyService;
    private final ActorMapper        actorMapper;

    @PostMapping("/run/add-age/{uid}")
    public ApiResponse<Integer> runAddAge(@PathVariable Long uid) throws InterruptedException {
        concurrencyService.addAge(uid);
        return ApiResponse.success(actorMapper.selectByPrimaryKey(uid).getAge());
    }

    @PostMapping("/run/add-age-no-lock/{uid}")
    public ApiResponse<Integer> runAddAgeNoLock(@PathVariable Long uid) throws InterruptedException {
        concurrencyService.addAgeNoLock(uid);
        return ApiResponse.success(actorMapper.selectByPrimaryKey(uid).getAge());
    }
}
