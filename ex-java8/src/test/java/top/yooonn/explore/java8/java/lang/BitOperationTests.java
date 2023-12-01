package top.yooonn.explore.java8.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 位运算
 *
 * @author yooonn
 * @date 2022.06.20
 */
public class BitOperationTests {

    private static final Logger log = LoggerFactory.getLogger(BitOperationTests.class);

    @Before
    public void setup() {
        log.info("Integer.MAX_VALUE: {}", Integer.MAX_VALUE);
        log.info("Integer.MIN_VALUE: {}", Integer.MIN_VALUE);
    }

    @After
    public void teardown() {
        log.info("(1 << 31) - 1: {}", (1 << 31) - 1);
        log.info("-(1 << 31): {}", -(1 << 31));
    }

    /**
     * x * 10 ==
     */
    @Test
    public void multi10Test() {
        int[] arr = {1, 4, 2};
        int res = 0;
        for (int j : arr) {
            res = (res << 3) + (res << 1) + j;
        }
        log.info("res: {}", res);
    }

    @Test
    public void bitOpImplementDivide() {
        int a = 42;
        int b = 6;
        // 2^5 + 2^3 + 2^1 = 42
        //       2^2 + 2^1 = 6
    }

    @Test
    public void addImplByBitOperationTest() {
        log.info("add(123, 456): {}", add(123, 456));
        log.info("add(-(1<<31), -1): {}", add(-(1 << 31), -1));
        log.info("add(-100, 3): {}", add(-100, 3));
    }

    @Test
    public void subtractImplByBitOperationTest() {
        log.info("subtract(13, 7): {}", subtract(13, 7));
        log.info("subtract(992, 1307): {}", subtract(992, 1307));
        log.info("subtract(-(1<<31), 1): {}", subtract(-(1 << 31), 1));
    }

    @Test
    public void multiplyImplByBitOperationTest() {
        log.info("multiply(12, 5): {}", multiply(12, 5));
        log.info("multiply((1 << 31) - 1, 1): {}", multiply((1 << 31) - 1, -1));
    }

    @Test
    public void divideImplByBitOperationTest() {
        // log.info("divide(10, 3): {}", divide(10, 3));
        // log.info("divide(2147483647, -1): {}", divide(2147483647, -1));
        // log.info("divide(-2147483648, -1): {}", divide(-2147483648, -1));
        log.info("divide(-2147483648, 2): {}", divide(-2147483648, 2));
        // log.info("divide(-2147483648, -2147483647): {}", divide(-2147483648, 2147483647));
    }

    @Test
    public void negativeTest() {
        assertThat(negative(-2147483648)).isEqualTo(-2147483648);
    }

    @Test
    public void testMain() {
        long a = Long.MAX_VALUE - 1000;
        long b = Long.MAX_VALUE - 10;
        int c = (int) (a + b);
        log.info("c: {}", c);
        int c2 = add(((int) a), ((int) b));
        log.info("c2: {}", c2);
    }

    /**
     * 两数相加: 不带进位时的和 + 进位部分, 迭代计算, 直至进位部分为0
     * <p>
     * 不带进位时的和是, a + b -> a ^ b
     * 进位部分是, a + b -> (a & b) << 1
     * <p>
     * 位运算计算两个数的加法:
     * <ol>
     *     <li>计算加数a, 被加数b不带进位的"和", noCarrySum</li>
     *     <li>计算加数a, 被加数b相加产生的"进位", carry</li>
     *     <li>如果carry不是0, 则noCarrySum给到加数a, carry给到加数b, 重复步骤1</li>
     * </ol>
     * <p>
     * <pre>
     * 假设计算13, 8的和.
     *                     13: 1101
     *                     8:  1000
     * 不带进位的和为          0101
     * 进位为                  1000 << 1 -> 10000
     * 此时就成了计算0101(5), 10000(16)的和
     *                     5: 00101
     *                    16: 10000
     * 不带进位的和为         10101
     * 进位为                     0
     * 终止, 所以13, 8的和为10101(21)
     * </pre>
     *
     * @param a integer number a
     * @param b integer number b
     * @return sum of a, b
     */
    private int add(int a, int b) {
        while (b != 0) {
            int noCarrySum = a ^ b;
            int carry = (a & b) << 1;
            a = noCarrySum;
            b = carry;
        }
        return a;
    }

    /**
     * 减去一个数等于加上这个数的负数
     *
     * @param a a
     * @param b b
     * @return subtract
     */
    private int subtract(int a, int b) {
        return add(a, negative(b));
    }

    private int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        boolean negative = a < 0 != b < 0;
        a = a < 0 ? negative(a) : a;
        b = b < 0 ? negative(b) : b;
        int ans = 0;
        for (int i = 30; i >= 0; i = subtract(i, 1)) {
            if (b >= (1 << i)) {
                ans = add(ans, a << i);
                b = subtract(b, 1 << i);
            }
            if (b == 0) {
                break;
            }
        }
        if (negative) {
            return negative(ans);
        }
        return ans;
    }

    private int divide(int a, int b) {
        if (a == negative(1 << 31) && b == -1) {
            return (1 << 31) - 1;
        }
        boolean negative = a < 0 != b < 0;
        a = a < 0 ? negative(a) : a;
        b = b < 0 ? negative(b) : b;
        int arest = 0;
        if (a == negative(1 << 31)) {
            a = (1 << 31) - 1;
            arest = 1;
        }
        if (b == negative(1 << 31)) {
            if (arest != 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int ans = 0;
        for (int i = 30; i >= 0; ) {
            if ((a >> i) >= b) {
                a = subtract(a, b << i);
                ans = add(ans, 1 << i);
                if (arest != 0) {
                    a = add(a, arest);
                    arest = 0;
                    continue;
                }
            }
            if (a == 0) {
                break;
            }
            i = subtract(i, 1);
        }
        if (negative) {
            return negative(ans);
        }
        return ans;
    }

    /**
     * 一个数的负数, 是该数的补码加1对应的数
     *
     * @param x x
     * @return negative of x
     */
    private int negative(int x) {
        return add(~x, 1);
    }

    @Test
    public void mainTest() {
        int x = 32;
        log.info("x << 1: {}", x << 1);
        log.info("x << 1 | 1: {}", x << 1 | 1);
        log.info("x: {}", x);
    }
}
