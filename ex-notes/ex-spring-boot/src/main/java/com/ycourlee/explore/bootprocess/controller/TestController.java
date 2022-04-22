package com.ycourlee.explore.bootprocess.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ycourlee.explore.bootprocess.context.ApplicationEventPublisherHolder;
import com.ycourlee.explore.bootprocess.inject.InjectValuePortal;
import com.ycourlee.explore.bootprocess.inject.ValueViewer;
import com.ycourlee.explore.bootprocess.model.request.BaseRequest;
import com.ycourlee.explore.bootprocess.service.TestService;
import com.ycourlee.tranquil.web.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yongjiang
 */
@RestController
@RequestMapping("/test")
public class TestController extends ApplicationEventPublisherHolder {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService       testService;
    @Autowired
    private InjectValuePortal injectValuePortal;
    @Autowired
    private ValueViewer valueViewer;

    @PostMapping("/{title}")
    public Response testTitle(@PathVariable String title) {
        if (title.length() == 5) {
            throw new RuntimeException("not good title.");
        }
        return Response.success()
                .pin("getListConfig", injectValuePortal.getListConfig())
                .pin("getCatConfig", injectValuePortal.getCatConfig())
                .pin("getCat", JSON.toJSON(valueViewer.getCat()))
                ;
    }

    @PostMapping("/transaction-verify/{rid}")
    public Response transactionVerify(@PathVariable Integer rid) {
        return Response.success(testService.deleteStatementTransactionVerify(rid));
    }

    @PostMapping("/oss")
    public Response testOss() throws Exception {
        return Response.success();
    }

    @PostMapping("/concurrency")
    public Response concurrency(BaseRequest request) {
        log.info("Request {} entered", request.getRid());
        return Response.success();
    }

    @PostMapping("/eventListener")
    public Response eventListener(@RequestBody JSONObject json) {
        return Response.success();
    }
}
