package com.ycourlee.explore.groovy.service.impl;

import com.ycourlee.explore.groovy.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yongjiang
 * @date 2021.07.06
 */
public class SlaveEmailServiceImpl implements EmailService {

    private static final Logger log = LoggerFactory.getLogger(SlaveEmailServiceImpl.class);

    @Override
    public void sendEmail(String text) {
        log.info("send an email: {}", text);
    }
}
