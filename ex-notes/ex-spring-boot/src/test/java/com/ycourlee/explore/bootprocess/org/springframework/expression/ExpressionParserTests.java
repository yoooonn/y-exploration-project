package com.ycourlee.explore.bootprocess.org.springframework.expression;

import com.ycourlee.explore.bootprocess.BootProcessApplicationTests;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.TestPropertySource;

/**
 * @author yongjiang
 * @date 2022.04.04
 */
@TestPropertySource(properties = {
        "hello=info"
})
public class ExpressionParserTests extends BootProcessApplicationTests{

    private static final Logger log = LoggerFactory.getLogger(ExpressionParserTests.class);

    private ExpressionParser parser = new SpelExpressionParser();

    private static final String PREFIX = "PREFIX";

    @Test
    public void mainTest() {
        // String exp = "#{cat.getName}";
        String exp = "'say '.concat(#hello)";
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("cat", new Cat().setName("hello, spel"));
        context.setVariable("hello", "world");
        Object value = parser.parseExpression(exp).getValue(context);
        log.info("value: {}", value);
    }

    @Setter
    @Getter
    @ToString
    @Accessors(chain = true)
    static class Cat {

        private String name;
        private String color;
    }
}
