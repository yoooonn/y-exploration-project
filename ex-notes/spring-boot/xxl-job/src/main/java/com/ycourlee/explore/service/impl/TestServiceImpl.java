package com.ycourlee.explore.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yooonn
 * @date 2021.01.23
 */
@Slf4j
@Service
public class TestServiceImpl {

    public void test(String cityId) {
        log.info("cityId = {}", cityId);
    }
}
