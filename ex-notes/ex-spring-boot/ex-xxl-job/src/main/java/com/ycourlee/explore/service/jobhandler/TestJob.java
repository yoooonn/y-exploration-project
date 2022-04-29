package com.ycourlee.explore.service.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.ycourlee.explore.service.impl.TestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 * @date 2021.01.23
 */
@Component
@JobHandler(value = "testJob")
public class TestJob extends IJobHandler {

    private static final Logger          log = LoggerFactory.getLogger(TestJob.class);
    @Autowired
    private              TestServiceImpl testService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        log.info("param = {}", param);
        testService.test(param);

        return ReturnT.SUCCESS;
    }
}
