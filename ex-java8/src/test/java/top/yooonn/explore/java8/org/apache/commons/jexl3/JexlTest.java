package top.yooonn.explore.java8.org.apache.commons.jexl3;

import top.yooonn.explore.java8.mocks.Cat;
import org.apache.commons.jexl3.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * @author yooonn
 * @date 2021.08.20
 */
public class JexlTest {

    private static final Logger log = LoggerFactory.getLogger(JexlTest.class);

    @Test
    public void mainTest() throws Exception {
        JexlBuilder jexlBuilder = new JexlBuilder();
        jexlBuilder.charset(StandardCharsets.UTF_8);
        jexlBuilder.arithmetic(new JexlArithmetic(true));
        // jexlBuilder.antish(true);

        JexlEngine jexlEngine = jexlBuilder.create();
        // JexlExpression expression = jexlEngine.createExpression("(say.length() ==5 && age == 18) && age + 1 == 19 && cat.getName().equals('world')");
        JexlExpression expression = jexlEngine.createExpression("1==1 && 3!=4");
        JexlContext context = new MapContext();

        context.set("say", "hello");
        context.set("age", 18);
        context.set("cat", new Cat("world", "red"));

        log.info("JSON.toJSONString(context): {}", context.get("cat.name()"));

        log.info("expression.getSourceText(): {}", expression.getSourceText());
        log.info("expression.getParsedText(): {}", expression.getParsedText());


        Object evaluate = expression.evaluate(null);

        log.info("evaluate: {}", evaluate);
    }


    @Test
    public void main2Test() throws Exception {
        JexlBuilder jexlBuilder = new JexlBuilder();
        jexlBuilder.charset(StandardCharsets.UTF_8);
        jexlBuilder.arithmetic(new JexlArithmetic(true));
        jexlBuilder.antish(true);

        JexlEngine jexlEngine = jexlBuilder.create();
        JexlExpression expression = jexlEngine.createExpression("(name.length() ==5 && age == 18) && age + 1 == 19");

        JexlContext context = new MapContext();

        context.set("name", "hello");
        context.set("age", 18);

        log.info("JSON.toJSONString(context): {}", context.get("cat.name()"));

        log.info("expression.getSourceText(): {}", expression.getSourceText());
        log.info("expression.getParsedText(): {}", expression.getParsedText());


        Object evaluate = expression.evaluate(context);
        log.info("evaluate: {}", evaluate);
    }

}
