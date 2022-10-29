package com.ycourlee.explore.springredis.controller;

import com.ycourlee.explore.springredis.service.TokenAcquireService;
import com.ycourlee.tranquil.web.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yooonn
 */
@RestController
public class Controller {

    @Autowired
    private TokenAcquireService tokenAcquireService;

    @GetMapping("/available-token/mode/{modeId}")
    public Response samplePath(@PathVariable Integer modeId) {
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
        return Response.success(token);
    }
}
