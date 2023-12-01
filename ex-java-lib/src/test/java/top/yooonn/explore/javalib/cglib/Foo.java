package top.yooonn.explore.javalib.cglib;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yooonn
 * @date 2023.01.03
 */
@Setter
@Getter
@ToString
public class Foo {

    private Integer a;

    public void b() {
        System.out.println("I am in foo");
    }
}
