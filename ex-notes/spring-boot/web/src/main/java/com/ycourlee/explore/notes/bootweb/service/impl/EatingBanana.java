package com.ycourlee.explore.notes.bootweb.service.impl;

import com.ycourlee.explore.notes.bootweb.service.AbstractEatingFruitSteps;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

/**
 * @author yooonn
 * @date 2022.03.24
 */
@Service
public class EatingBanana extends AbstractEatingFruitSteps {

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
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
