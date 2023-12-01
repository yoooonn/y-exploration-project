package top.yooonn.explore.java8.java.lang.reflect;

import top.yooonn.explore.java8.AbstractTest;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author yooonn
 * @date 2021.12.28
 */
public class BridgeMethodTest extends AbstractTest {

    @Test
    public void main3Test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        A<Integer> a = new B();
        A<Integer> a2 = new C();
        System.out.println(a.fn(1));
        Class<? extends A> a2Class = a2.getClass();
        System.out.println(a2Class.getSimpleName());
        Method[] methods = a2Class.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Method fn = a2Class.getMethod("fn", Integer.class);
        System.out.println(fn.invoke(a2, 3));
    }

    static class A<T> {

        protected T fn(T t) {return t;}
    }

    static class B extends A<Integer> {

        @Override
        protected Integer fn(Integer integer) {
            return super.fn(integer);
        }
    }

    static class C extends A<Integer> {
    }

    @Test
    public void groupMethodParamTest() {
        Parent<Integer> parent = new Child();
        System.out.println(parent.max(Arrays.asList(3, 1, 5)));
    }

    interface Parent<T> {

        T max(List<T> ts);
    }

    static class Child implements Parent<Integer> {

        @Override
        public Integer max(List<Integer> s) {
            return s == null || s.isEmpty() ? Integer.MAX_VALUE : s.stream().max(Integer::compareTo).get();
        }
    }

    @Test
    public void mainTest() {
        NodeImpl node = new NodeImpl(5);
        Method[] methods = node.getClass().getMethods();
        Arrays.stream(methods).forEach(System.out::println);
        Node n = node;
        n.setData("hello");
        Integer data = node.data;
        System.out.println(data);

    }

    public static class Node<T> {

        public T data;

        public Node(T data) {
            this.data = data;
        }

        public void setData(T data) {
            System.out.println("Node.setData");
            this.data = data;
        }
    }

    public static class NodeImpl extends Node<Integer> {

        public NodeImpl(Integer date) {
            super(date);
        }

        @Override
        public void setData(Integer data) {
            System.out.println("NodeImpl.setData");
            super.setData(data);
        }
    }
}
