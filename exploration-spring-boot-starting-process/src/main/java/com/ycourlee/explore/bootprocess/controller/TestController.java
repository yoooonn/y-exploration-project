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

    @PostMapping("/transaction-verify/{rid}")
    public Rtm transactionVerify(@PathVariable Integer rid) {
        return Rtm.success(testService.deleteStatementTransactionVerify(rid));
    }
}
