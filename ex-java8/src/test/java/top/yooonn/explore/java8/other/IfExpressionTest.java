package top.yooonn.explore.java8.other;

import org.junit.Test;

/**
 * @author yooonn
 * @date 2021.09.26
 */
public class IfExpressionTest {

    @Test
    public void mainTest() {
        boolean a = false;
        boolean b = getBoolean();


        try {
            if (a = b) {
                System.out.println("1 = " + 1);
            }
        } catch (Exception e) {

        } finally {
            System.out.println("a = " + a);
        }
    }

    private boolean getBoolean() {

        return false;
    }
}
