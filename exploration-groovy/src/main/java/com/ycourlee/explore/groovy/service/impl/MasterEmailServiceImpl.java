package com.ycourlee.explore.groovy.service.impl;

import com.ycourlee.explore.groovy.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author yongjiang
 * @date 2021.07.06
 */
@Service("masterEmailServiceImpl")
public class MasterEmailServiceImpl implements EmailService {

    private static final Logger log = LoggerFactory.getLogger(MasterEmailServiceImpl.class);
    @Override
    public void sendEmail(String text) {
        log.info("master email service send an email: {}", text);
    }
}
