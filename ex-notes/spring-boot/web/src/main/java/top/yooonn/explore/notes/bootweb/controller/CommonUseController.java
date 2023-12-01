package top.yooonn.explore.notes.bootweb.controller;

import top.yooonn.explore.notes.bootweb.context.ApplicationEventPublisherHolder;
import top.yooonn.explore.notes.bootweb.event.FooEvent;
import top.yooonn.explore.notes.bootweb.event.FooRequestProcessingEvent;
import top.yooonn.explore.notes.bootweb.event.SimpleEvent;
import top.yooonn.explore.notes.bootweb.service.GenericService;
import com.ycourlee.tranquil.web.dto.Response;
import lombok.SneakyThrows;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

/**
 * @author yooonn
 * @date 2021.10.21
 */
@RestController
@RequestMapping("/common")
public class CommonUseController extends ApplicationEventPublisherHolder {

    private static final Logger log = LoggerFactory.getLogger(CommonUseController.class);

    @Autowired
    private GenericService genericService;

    @SneakyThrows
    @PostMapping("/ping/{message}")
    public Response ping(@PathVariable(required = false) String message, HttpServletRequest request, HttpServletResponse response) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Response ping = genericService.ping(message);
        CompletableFuture.runAsync(() -> {
            publisher.publishEvent(new FooRequestProcessingEvent("/common/ping/{message}", new Object[]{message}));
        });
        publisher.publishEvent(new SimpleEvent("/ping/" + message));
        publisher.publishEvent(new FooEvent("/ping/" + message));
        stopWatch.stop();
        log.info("stopWatch.prettyPrint(): {}", stopWatch.prettyPrint());
        return ping;
    }

    @SneakyThrows
    @PostMapping("/base64/encode/{plaintext}")
    public Response base64Encode(@NonNull @PathVariable String plaintext,
                                 HttpServletRequest request, HttpServletResponse response) {
        Thread.sleep(1000);
        return Response.success(Base64.encodeBase64URLSafe(plaintext.getBytes(StandardCharsets.UTF_8)));
    }

    @PostMapping("/base64/decode/{ciphertext}")
    public Response base64Decode(@NonNull @PathVariable String ciphertext,
                                 HttpServletRequest request, HttpServletResponse response) {
        return Response.success(Base64.decodeBase64(ciphertext.getBytes(StandardCharsets.UTF_8)));
    }
}
