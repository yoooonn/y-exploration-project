package com.ycourlee.explore.bootprocess.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ycourlee.explore.bootprocess.inject.InjectView;
import com.ycourlee.explore.bootprocess.model.request.BaseRequest;
import com.ycourlee.explore.bootprocess.service.TestService;
import com.ycourlee.root.core.domain.context.Rtm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yongjiang
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;
    @Autowired
    private InjectView injectView;

    @PostMapping("/{title}")
    public Rtm testTitle(@PathVariable String title) {
        if (title.length() == 5) {
            throw new RuntimeException("not good title.");
        }
        return Rtm.success()
                .pin("getInvokeBeanMethod", injectView.getInvokeBeanMethod())
                .pin("getCatConfig", injectView.getCatConfig())
                .pin("getCat", JSON.toJSON(injectView.getCat()))
                ;
    }

    @PostMapping("/transaction-verify/{rid}")
    public Rtm transactionVerify(@PathVariable Integer rid) {
        return Rtm.success(testService.deleteStatementTransactionVerify(rid));
    }

    @PostMapping("/oss")
    public Rtm testOss() throws Exception {
        return Rtm.success();
    }

    @PostMapping("/concurrency")
    public Rtm concurrency(BaseRequest request) {
        log.info("Request {} entered", request.getRid());
        return Rtm.success();
    }

    @PostMapping("/eventListener")
    public Rtm eventListener(@RequestBody JSONObject json) {
        // ApplicationContext.publishEvent(new EnvironmentChangeEvent());
        return Rtm.success();
    }
}
