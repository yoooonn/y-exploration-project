package top.yooonn.explore.notes.mavendependence.a;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
 * @date 2021.10.22
 */
public class Helper {

    private static final Logger log = LoggerFactory.getLogger(Helper.class);

    public static void log(String s) {
        Pair<String, String> pair = new ImmutablePair<>("logged: ", s);
        log.info("pair: {}", JSON.toJSONString(pair));
    }
}
