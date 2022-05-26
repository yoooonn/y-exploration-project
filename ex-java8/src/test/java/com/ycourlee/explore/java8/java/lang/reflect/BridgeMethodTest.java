package com.ycourlee.explore.java8.java.lang.reflect;

import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author yooonn
 * @date 2021.12.28
 */
public class BridgeMethodTest extends AbstractTest {

    // @SuppressWarnings({"rawtypes", "unchecked"})
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
