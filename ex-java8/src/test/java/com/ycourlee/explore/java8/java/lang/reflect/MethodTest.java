package com.ycourlee.explore.java8.java.lang.reflect;

import com.ycourlee.explore.java8.model.Computer;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author yongjiang
 * @date 2021.11.10
 */
public class MethodTest {

    @Test
    public void mainTest() throws NoSuchMethodException {
        Method add = Computer.class.getMethod("add", int.class, int.class);
        Parameter[] parameters = add.getParameters();
        System.out.println("parameters[0].getName() = " + parameters[0].getName());
        System.out.println("parameters[1].getName() = " + parameters[1].getName());
    }
}
