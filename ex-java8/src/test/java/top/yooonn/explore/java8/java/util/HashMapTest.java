package top.yooonn.explore.java8.java.util;

import top.yooonn.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yooonn
 * @date 2023.02.27
 */
public class HashMapTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(HashMapTest.class);

    @Test
    public void testPutMethod() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(null, "foo");
        map.put(null, "bar");
        log.info("map.get(null): {}", map.get(null));
    }

    @Test
    public void nullKeyTest() {
        Map<String, Object> map = new HashMap<>();
        map.put(null, "foo");
        map.put(null, "bar");
        log.info("map.get(null): {}", map.get(null));
    }

    @Test
    public void tableSizeForTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method tableSizeFor = getTableSizeFor();
        HashMap<Object, Object> obj = new HashMap<>();
        for (int i = 0; i < 18; i++) {
            Object invoke = tableSizeFor.invoke(obj, i);
            log.info("invoke: {} {}", i, invoke);
        }
    }

    @Test
    public void mainTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<Object, Object> map = new HashMap<>(1);
        /*
         * HashMap的hash算法为 hashcode ^ (hashcode>>>16, hashcode高16位)
         */
        map.put(1, 13);
    }

    private static Method getTableSizeFor() throws NoSuchMethodException {
        Method tableSizeFor = HashMap.class.getDeclaredMethod("tableSizeFor", int.class);
        tableSizeFor.setAccessible(true);
        return tableSizeFor;
    }
}
