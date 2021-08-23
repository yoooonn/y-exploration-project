package com.ycourlee.explore.bootprocess.controller;

import com.ycourlee.explore.bootprocess.service.TestService;
import com.ycourlee.root.core.domain.context.Rtm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongjiang
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/test/{title}")
    public Rtm testTitle(@PathVariable String title)  {
        if (title.length() == 5) {
            throw new RuntimeException("not good title.");
        }
        return Rtm.success();
    }

    @PostMapping("/transaction-verify/{rid}")
    public Rtm transactionVerify(@PathVariable Integer rid) {
        return Rtm.success(testService.deleteStatementTransactionVerify(rid));
    }

    @PostMapping("/test-oss")
    public Rtm testOss() throws Exception {
        return Rtm.success();
    }
}
