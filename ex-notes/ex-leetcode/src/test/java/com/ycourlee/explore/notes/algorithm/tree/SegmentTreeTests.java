package com.ycourlee.explore.notes.algorithm.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yooonn
 * @date 2022.06.20
 */
public class SegmentTreeTests {

    @Test
    void mainTest() {
        SegmentTree tree = new SegmentTree(1000);
        int ans1 = tree.query(1, 40, 1);
        assertEquals(40, ans1);
        int ans3 = tree.query(3, 12, 1);
        assertEquals(10, ans3);
        tree.update(3, 12, 2, 1);
        int ans2 = tree.query(1, 40, 1);
        assertEquals(60, ans2);
    }
}
