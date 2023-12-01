package top.yooonn.explore.faste.spring.boot.data.utils;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author yooonn
 * @date 2022.10.29
 */
public class Templates {

    private Templates() {}

    public static <T> void runIfNotNull(T o, Consumer<T> consumer) {
        if (Objects.nonNull(o)) {
            consumer.accept(o);
        }
    }

    public static <T> void runCarelesslyIfNotNull(T o, ThrowableConsumer<T> consumer) {
        if (Objects.nonNull(o)) {
            try {
                consumer.accept(o);
            } catch (Exception e) {
                if (e instanceof RuntimeException) {
                    throw ((RuntimeException) e);
                }
                throw new RuntimeException(e);
            }
        }
    }

    public static <T> void runSafelyIfNotNull(T o, ThrowableConsumer<T> consumer) {
        if (Objects.nonNull(o)) {
            try {
                consumer.accept(o);
            } catch (Exception ignore) {
            }
        }
    }

    public static <T> void runIfNotEmpty(Collection<T> coll, Consumer<Collection<T>> consumer) {
        if (coll != null && !coll.isEmpty()) {
            consumer.accept(coll);
        }
    }

    public static void runCarelessly(Runnable code) {
        try {
            code.run();
        } catch (Exception ignore) {
        }
    }

    public static void closeQuietlyIfNotNull(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException ignore) {
            }
        }
    }

    public static void closeQuietlyIfNotNull(AutoCloseable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (Exception ignore) {
            }
        }
    }

    @FunctionalInterface
    interface ThrowableConsumer<T> {

        void accept(T t) throws Exception;
    }
}
