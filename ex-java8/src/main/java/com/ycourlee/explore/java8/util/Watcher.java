package com.ycourlee.explore.java8.util;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author yooonn
 * @date 2023.03.16
 */
@Setter
@Getter
@Builder(setterPrefix = "with")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Watcher<C> {

    private static final Logger log = LoggerFactory.getLogger(Watcher.class);

    private List<String> propsToWatch;

    private Class<C> target;

    public void watchAllWith(Object obj) {
        if (!obj.getClass().equals(target)) {
            throw new IllegalArgumentException("Only support class '" + target.getSimpleName() + "'");
        }
        StringBuilder prints = new StringBuilder(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append('\n');

        printPropWatchResult(prints, obj, target.getDeclaredFields());
    }

    public void watchWith(Object obj) {
        if (!obj.getClass().equals(target)) {
            throw new IllegalArgumentException("Only support class '" + target.getSimpleName() + "'");
        }
        StringBuilder prints = new StringBuilder(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append('\n');

        printPropWatchResult(prints, obj, ((Supplier<Field[]>) () -> {
            if (propsToWatch == null || propsToWatch.isEmpty()) {
                return null;
            }
            List<Field> fields = new ArrayList<>(propsToWatch.size());
            try {
                for (String prop : propsToWatch) {
                    fields.add(target.getDeclaredField(prop));
                }
            } catch (NoSuchFieldException e) {
                log.error(e.getMessage());
            }
            return fields.toArray(new Field[0]);
        }).get());
    }

    private static void printPropWatchResult(StringBuilder prints, Object obj, Field[] fields) {
        if (fields != null && fields.length > 0) {
            prints.append("Props").append('\n');
            try {
                for (Field field : fields) {
                    field.setAccessible(true);
                    prints.append(field.getName()).append(": ").append(field.get(obj).toString()).append('\n');
                }
            } catch (IllegalAccessException e) {
                log.error(e.getMessage());
            }
        }
    }
}
