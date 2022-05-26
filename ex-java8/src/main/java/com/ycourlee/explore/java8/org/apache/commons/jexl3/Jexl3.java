package com.ycourlee.explore.java8.org.apache.commons.jexl3;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;

import java.nio.charset.StandardCharsets;

/**
 * @author yooonn
 * @date 2021.08.20
 */
public class Jexl3 {


    public static final JexlBuilder JEXL_BUILDER = new JexlBuilder();

    public static final JexlEngine JEXL_ENGINE_DEFAULT = jexlEngine();

    static {
        JEXL_BUILDER.charset(StandardCharsets.UTF_8);
    }

    public static JexlEngine jexlEngine() {
        return JEXL_BUILDER.create();
    }

    public static JexlExpression expressive(String expression) {
        return JEXL_ENGINE_DEFAULT.createExpression(expression);
    }

    public static Object evaluate(JexlExpression expression) {
        return expression.evaluate(null);
    }

}
