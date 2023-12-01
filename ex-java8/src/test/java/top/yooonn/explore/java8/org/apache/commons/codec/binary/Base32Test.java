package top.yooonn.explore.java8.org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base32;
import org.junit.Test;

/**
 * @author yooonn
 */
public class Base32Test {

    public final String[] base32Lookup =
            {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "b", "c", "d", "e", "f", "g", "h",
                    "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    @Test
    public void xTest() {
        Base32 base32 = new Base32();
        byte[] encode = base32.encode(new byte[]{});
        System.out.println("new String(encode) = " + new String(encode));
    }

    @Test
    public void base32EncodeTest() {
        String s = base32Encode("11100111010010001111000001101");
        System.out.println("s = " + s);
    }

    private String base32Encode(final String str) {
        String unit = "";
        StringBuilder sb = new StringBuilder();
        for (int start = 0; start < str.length(); start = start + 5) {
            unit = str.substring(start, Math.min(start + 5, str.length()));
            sb.append(base32Lookup[convertToIndex(unit)]);
        }
        return sb.toString();
    }

    private int convertToIndex(String str) {
        int length = str.length();
        int result = 0;
        for (int index = 0; index < length; index++) {
            result += str.charAt(index) == '0' ? 0 : 1 << (length - 1 - index);
        }
        return result;
    }
}
