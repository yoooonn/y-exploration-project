package com.ycourlee.explore.bootprocess.other;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yongjiang
 * @date 2022.03.03
 */
public class MethodInsideClassTests {

    private static final Logger log = LoggerFactory.getLogger(MethodInsideClassTests.class);

    /**
     *
     */
    @Test
    public void mainTest() {

        log.info("\"starting\": {}", "starting");

        class Message {

            public Message() {
                log.info("\"init\": {}", "init");
            }

            {
                log.info("\"static\": {}", "static");
            }

            private String content = "hello";

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        Message message = new Message();

        log.info("message.content: {}", message.content);

    }
}
