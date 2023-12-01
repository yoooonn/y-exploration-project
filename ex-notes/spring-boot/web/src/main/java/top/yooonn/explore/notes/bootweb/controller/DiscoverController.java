package top.yooonn.explore.notes.bootweb.controller;

import com.ycourlee.tranquil.web.dto.Response;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author yooonn
 * @date 2022.03.24
 */
@RestController
@RequestMapping("/discover")
public class DiscoverController {

    @Nonnull
    @SneakyThrows
    @PostMapping("/big-decimal")
    public Response bigDecimal() {
        return Response.success().pin("big_decimal_0_scale",
                new BigDecimal("14241234.1215251")
                        .setScale(2, RoundingMode.HALF_UP));
    }
}
