package top.yooonn.explore.groovy.groovy.lang;

import com.ycourlee.tranquil.core.CommonConstants;
import groovy.lang.GroovyClassLoader;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yooonn
 * @date 2021.07.06
 */
public class GroovyClassLoaderTest extends CommonConstants {

    private static final Logger log = LoggerFactory.getLogger(GroovyClassLoaderTest.class);

    @Test
    public void parseClassTest() throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        Class<?> aClass = groovyClassLoader.parseClass(new File(RESOURCE_DIR + "/a.txt"));
        Object instance = aClass.newInstance();
        Method sendEmail = aClass.getDeclaredMethod("sendEmail", String.class);
        Object yooonn = sendEmail.invoke(instance, "yooonn");
        log.info("yooonn = {}", yooonn);
    }

    @Test
    public void aTest() {
    }
}
