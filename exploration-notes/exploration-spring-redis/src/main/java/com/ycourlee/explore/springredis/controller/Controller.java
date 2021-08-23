package com.ycourlee.explore.springredis.controller;

import com.ycourlee.explore.springredis.service.TokenAcquireService;
import com.ycourlee.root.core.domain.context.Rtm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongjiang
 */
@RestController
public class Controller {

    @Autowired
    private TokenAcquireService tokenAcquireService;

    @GetMapping("/available-token/mode/{modeId}")
    public Rtm samplePath(@PathVariable Integer modeId) {
        String token = null;

        switch (modeId) {
            case 1:
                token = tokenAcquireService.availableTokenByDistributeLock();
                break;
            case 2:
                token = tokenAcquireService.availableTokenByDistributeLock2();
                break;
            default:
        }
        return Rtm.success(token);
    }
}
