package com.ycourlee.explore.java8.java.io;

import com.ycourlee.root.mocks.UnitTestResource;
import lombok.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;

/**
 * @author yongjiang
 * @date 2021.08.24
 */
public class ObjectStreamTest extends UnitTestResource {

    private static final Logger log = LoggerFactory.getLogger(ObjectStreamTest.class);

    private final String targetFile = TEMP_DIR + "/serialize-test.txt";

    private final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(targetFile));

    public ObjectStreamTest() throws IOException {}

    @Test
    public void serializeClassWithAllSerializableFieldTest() throws IOException, ClassNotFoundException {
        Resource resource = Resource.builder()
                .string("abc")
                .integer(12)
                .aLong(3)
                .build();
        objectOutputStream.writeObject(resource);
        readTest();
    }

    @Test
    public void write2Test() throws IOException, ClassNotFoundException {
        Resource resource = Resource.builder()
                .string("abc")
                .integer(12)
                .aLong(3)
                .obj(new ArrayList<>())
                .build();
        objectOutputStream.writeObject(resource);
        readTest();
    }

    @Test
    public void write3Test() throws IOException, ClassNotFoundException {
        Resource2 resource2 = Resource2.builder()
                .string("sun")
                .integer(14)
                // .aLong(5)
                .obj(new ArrayList<>())
                .build();
        objectOutputStream.writeObject(resource2);

        read2Test();
    }

    @Test
    public void readTest() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(targetFile));
        Resource resource = ((Resource) objectInputStream.readObject());
        log.info(resource.toString());
    }

    @Test
    public void read2Test() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(targetFile));
        Resource2 resource = ((Resource2) objectInputStream.readObject());
        log.info(resource.toString());
    }

    @Setter
    @Getter
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class Resource implements Serializable {

        private static final long serialVersionUID = 3445797591275825836L;

        private String  string;
        private Integer integer;
        private long    aLong;
        private Object  obj;
    }

    @Setter
    @Getter
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class Resource2 implements Serializable {

        private static final long serialVersionUID = -4437394147964028000L;

        private           String  string;
        private           Integer integer;
        private transient long    aLong;
        private transient Object  obj;
    }


    @Setter
    @Getter
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class Resource3 {

        private String  string;
        private Integer integer;
        private long    aLong;
        private Object  obj;
    }

    @Setter
    @Getter
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class Resource4 implements Serializable {

        private static final long serialVersionUID = -4437394147964028000L;

        private           String    string;
        private           Integer   integer;
        private transient long      aLong;
        private           Resource3 obj;
    }
}
