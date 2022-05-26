package com.ycourlee.explore.java8.other;

import com.ycourlee.tranquil.core.CommonConstants;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yooonn
 */
public class SplitPage extends CommonConstants {

    @Test
    public void aTest() {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < TEST_CASE_ONE_HUNDRED; i++) {
            list.add("a" + i);
        }

        System.out.println(list.size());

        int pageSize = 1000;
        int fromIndex = 0;
        int effectedRows = 0;
        while (fromIndex < list.size()) {
            int toIndex = Math.min(fromIndex + pageSize, list.size());
            List<String> strings = list.subList(fromIndex, toIndex);
            System.out.println("strings = " + Arrays.toString(strings.toArray()));
            effectedRows += strings.size();
            fromIndex = toIndex;
        }
        System.out.println(effectedRows);
    }
}
