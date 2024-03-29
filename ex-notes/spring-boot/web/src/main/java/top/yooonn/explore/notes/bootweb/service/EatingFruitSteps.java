package top.yooonn.explore.notes.bootweb.service;

import org.springframework.core.Ordered;

/**
 * @author yooonn
 * @date 2022.03.24
 */
public interface EatingFruitSteps extends Ordered {

    String name();

    void beforeEat();

    void eat();

    void afterEat();
}
