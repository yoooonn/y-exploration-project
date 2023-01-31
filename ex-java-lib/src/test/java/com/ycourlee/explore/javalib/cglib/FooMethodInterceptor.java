package com.ycourlee.explore.javalib.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yooonn
 * @date 2023.01.03
 */
public class FooMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("I am in FooMethodInterceptor start");
        Object res = methodProxy.invokeSuper(o, objects);
        System.out.println("I am in FooMethodInterceptor end");
        return res;
    }
}
