package com.ycourlee.explore.notes.bootweb.inject;

import com.ycourlee.explore.notes.bootweb.model.bo.CatBO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author yongjiang
 * @date 2022.01.11
 */
@Setter
@Getter
@Component
public class ValueViewer {

    private List<Long> list = Arrays.asList(123L, 2345L);

    private CatBO cat;
}
