package top.yooonn.explore.javalib.cn.hutool.core.util;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import top.yooonn.explore.javalib.AbstractTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yooonn
 * @date 2022.02.17
 */
public class HttpUtilTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(HttpUtilTest.class);

    private static final Pattern pattern = Pattern.compile("<td>(\\d{18})</td>");

    private static final Pattern chinese = Pattern.compile("([\u4E00-\u9FFF]{1,})");

    @Test
    void main2Test() {
        String s = "\t\t\t\t\t\t\t<td>130503195303227957</td>";
        Matcher matcher = pattern.matcher(s);
        log.info("matcher.find(): {}", matcher.find());
    }

    @Test
    void mainTest() {
        FileReader fileReader = FileReader.create(new File(RESOURCE_DIR + "/idcard/idcard-urls.json"));
        String json = fileReader.readString();
        JSONObject object = JSON.parseObject(json);
        JSONArray list = object.getJSONArray("list");
        StringBuilder builder = new StringBuilder();
        list.forEach(group -> {
            JSONObject jsonObject = (JSONObject) group;
            String url = jsonObject.getString("url");
            HttpResponse response = HttpUtil.createGet(url).contentType(ContentType.TEXT_HTML.getValue()).execute();
            File tempFile = new File(TEMP_DIR + "/html" + url.substring(url.lastIndexOf("/")));
            FileWriter fileWriter = FileWriter.create(tempFile);
            fileWriter.write(response.body());
            FileReader reader = FileReader.create(tempFile);
            List<String> strings = reader.readLines();
            for (int i = 0; i < strings.size(); i++) {
                Matcher matcher = pattern.matcher(strings.get(i));
                if (!matcher.find()) {
                    continue;
                }
                Matcher name = chinese.matcher(strings.get(i - 1));
                if (!name.find()) {
                    log.error(strings.get(i - 1));
                    continue;
                }
                builder.append(name.group(1))
                        .append(", ")
                        .append(matcher.group(1))
                        .append(System.lineSeparator());
            }
            tempFile.delete();
        });
        FileWriter idcard = FileWriter.create(new File(RESOURCE_DIR + "/idcard/idcard-1.txt"));
        idcard.write(builder.toString());
    }
}
