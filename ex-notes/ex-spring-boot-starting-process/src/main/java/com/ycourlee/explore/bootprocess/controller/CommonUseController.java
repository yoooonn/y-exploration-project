package com.ycourlee.explore.bootprocess.controller;

import com.ycourlee.explore.bootprocess.context.ApplicationEventPublisherHolder;
import com.ycourlee.explore.bootprocess.event.SimpleTransactionalEvent;
import com.ycourlee.explore.bootprocess.service.GenericService;
import com.ycourlee.root.core.domain.context.Rtm;
import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;

/**
 * @author yongjiang
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
    public Rtm ping(@PathVariable(required = false) String message, HttpServletRequest request, HttpServletResponse response) {
        log.info("StreamUtils.copyToByteArray(request.getInputStream()): {}", new String(StreamUtils.copyToByteArray(request.getInputStream())));

        Rtm ping = genericService.ping(message);

        publisher.publishEvent(new SimpleTransactionalEvent("receive an request, uri: /ping/{message}"));
        return ping;
    }

    @SneakyThrows
    @PostMapping("/base64/encode/{plaintext}")
    public Rtm base64Encode(@NonNull @PathVariable String plaintext,
                            HttpServletRequest request, HttpServletResponse response) {
        Thread.sleep(1000);
        return Rtm.success(Base64.encodeBase64URLSafe(plaintext.getBytes(StandardCharsets.UTF_8)));
    }

    @PostMapping("/base64/decode/{ciphertext}")
    public Rtm base64Decode(@NonNull @PathVariable String ciphertext,
                            HttpServletRequest request, HttpServletResponse response) {
        return Rtm.success(Base64.decodeBase64(ciphertext.getBytes(StandardCharsets.UTF_8)));
    }
}
