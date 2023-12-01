package top.yooonn.explore.notes.bootweb.other;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
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

            private String content = "hello";

            {
                log.info("\"static\": {}", "static");
            }

            public Message() {
                log.info("\"init\": {}", "init");
            }

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
