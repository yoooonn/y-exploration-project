package com.ycourlee.explore.notes.springredission.org.redisson.api;

import com.ycourlee.explore.notes.springredission.RedissionSpringApplicationTests;
import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RPriorityQueue;
import org.redisson.client.codec.Codec;

/**
 * @author yooonn
 * @date 2022.04.04
 */
public class RedissonClientTests extends RedissionSpringApplicationTests {


    @Test
    void mainTest() {
        Codec codec;
        RPriorityQueue<Object> priorityQueue = redissonClient.getPriorityQueue("this:is:a:pq");
    }

    @Test
    void main2Test() {
        RList<String> list = redissonClient.getList("this:is:a:list");

    }
}
