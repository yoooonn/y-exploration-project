package top.yooonn.explore.javalib.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Method;

/**
 * @author yooonn
 * @date 2023.01.03
 */
public class Portal {

    public static void main(String[] args) throws InterruptedException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Foo.class);
        enhancer.setUseFactory(false);
        // enhancer.setCallback(new FooMethodInterceptor());
        enhancer.setCallbacks(new Callback[]{new FooMethodInterceptor(), NoOp.INSTANCE});
        enhancer.setCallbackFilter(new FooCallbackFilter());
        Foo foo = ((Foo) enhancer.create());
        System.out.println(foo.getA());
        foo.b();
        System.out.println(foo.equals(null));
        printDeclaredMethodsOf(foo.getClass());
        Thread.sleep(1000000000000L);
    }

    private static void printDeclaredMethodsOf(Class<? extends Foo> fooClass) {
        for (Method method : fooClass.getDeclaredMethods()) {
            System.out.println(method);
        }
    }
}
