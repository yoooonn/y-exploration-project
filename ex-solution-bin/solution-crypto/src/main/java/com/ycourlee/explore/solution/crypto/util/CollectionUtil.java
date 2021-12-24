package com.ycourlee.explore.solution.crypto.util;

import java.util.Collection;

/**
 * created on 2021.04.24
 *
 * @author yongjiang
 */
public class CollectionUtil {

    public static boolean isEmpty(Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> coll) {
        return coll != null && !coll.isEmpty();
    }

    public static boolean isEmpty(Object[] coll) {
        return coll == null || coll.length == 0;
    }

    public static boolean isNotEmpty(Object[] coll) {
        return coll != null && coll.length != 0;
    }
}
