package com.ycourlee.explore.bootprocess.controller;

import com.ycourlee.root.core.domain.context.Rtm;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author yongjiang
 * @date 2022.03.24
 */
@RestController
@RequestMapping("/discover")
public class DiscoverController {

    @SneakyThrows
    @PostMapping("/big-decimal")
    public Rtm bigDecimal() {
        return Rtm.success().pin("big_decimal_0_scale",
                new BigDecimal("14241234.1215251")
                        .setScale(2, RoundingMode.HALF_UP));
    }
}
