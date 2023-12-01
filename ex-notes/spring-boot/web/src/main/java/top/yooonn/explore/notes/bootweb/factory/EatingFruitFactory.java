package top.yooonn.explore.notes.bootweb.factory;

import top.yooonn.explore.notes.bootweb.service.EatingFruitSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

/**
 * @author yooonn
 * @date 2022.03.24
 */
@Component
public class EatingFruitFactory {

    @Autowired
    private List<EatingFruitSteps> eatingFruit;

    public Iterator<EatingFruitSteps> get() {
        return eatingFruit.iterator();
    }
}
