package top.yooonn.explore.javalib.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author yooonn
 * @date 2023.01.03
 */
public class FooCallbackFilter implements CallbackFilter {

    /**
     * @param method method
     * @return callbacks index
     */
    @Override
    public int accept(Method method) {
        switch (method.getName()) {
            case "b":
            case "equals":
                return 0;
            default:
                return 1;
        }
    }
}
