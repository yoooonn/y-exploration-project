package com.ycourlee.explore.notes.algorithm;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yooonn
 * @date 2022.05.28
 */
public class DlxAlgorithmTest {

    private static final Logger log = LoggerFactory.getLogger(DlxAlgorithmTest.class);

    @Test
    void mainTest() {
        DlxAlgorithm algorithm2 = new DlxAlgorithm();
        algorithm2.initWith(new ArrayList<>(Arrays.asList(
                "0,0,1,0,1,1,0",
                "1,0,0,1,0,0,1",
                "0,1,1,0,0,1,0",
                "1,0,0,1,0,0,0",
                "0,1,0,0,0,0,1",
                "0,0,0,1,1,0,1"
        ))).dancing();
        log.info("algorithm2.ans: {}", algorithm2.ans);
    }
}
