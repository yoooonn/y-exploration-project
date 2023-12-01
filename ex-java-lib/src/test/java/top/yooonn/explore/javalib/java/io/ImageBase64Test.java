package top.yooonn.explore.javalib.java.io;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.file.FileReader;
import top.yooonn.explore.javalib.AbstractTest;
import org.junit.jupiter.api.Test;

/**
 * @author yooonn
 * @date 2021.12.14
 */
public class ImageBase64Test extends AbstractTest {

    @Test
    void mainTest() {
        FileReader reader = FileReader.create(newFile(TEMP_DIR + "/long_text_2021-12-14-17-36-03.txt"));
        String base64 = reader.readString();
        Base64.decodeToFile(base64, newFile(TEMP_DIR + "/b.png"));
    }
}
