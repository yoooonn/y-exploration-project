package top.yooonn.explore.notes.java.nio;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * 抽象类{@link ByteBuffer}是抽象类{@link java.nio.Buffer}的子类
 * <p>{@link java.nio.Buffer}提供了{@code buffer}的
 * 容量, 两个指针属性和一个标记为,并声明了它们三者的移动逻辑关系的方法.
 *
 * @author yooonn
 * @date 2022.07.24
 */
class ByteBufferTests {

    /**
     *
     */
    @Test
    void mainTest() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(((byte) 61));
        buffer.flip();
        buffer.rewind();
        buffer.mark();
        buffer.reset();
        buffer.flip();
        buffer.compact();
        buffer.clear();
    }
}
