package top.yooonn.explore.groovy.service.impl;

import top.yooonn.explore.groovy.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
 * @date 2021.07.06
 */
public class MasterEmailServiceImpl implements EmailService {

    private static final Logger log = LoggerFactory.getLogger(MasterEmailServiceImpl.class);

    @Override
    public void sendEmail(String text) {
        log.info("master email service send an email: {}", text);
    }
}
