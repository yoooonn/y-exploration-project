package com.ycourlee.explore.bootprocess.service;

/**
 * @author yongjiang
 * @date 2022.03.24
 */
public class AbstractEatingFruitSteps implements EatingFruitSteps {

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public void beforeEat() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void afterEat() {

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
