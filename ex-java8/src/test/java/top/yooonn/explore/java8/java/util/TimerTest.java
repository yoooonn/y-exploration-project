package top.yooonn.explore.java8.java.util;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author yooonn
 * @date 2022.12.14
 */
public class TimerTest {

    @Test
    public void mainTest() throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(1);
            }
        }, 0, 1000);
        while (true) {

        }
    }
}
