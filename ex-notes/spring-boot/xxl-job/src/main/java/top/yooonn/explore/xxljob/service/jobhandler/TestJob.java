package top.yooonn.explore.xxljob.service.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import top.yooonn.explore.xxljob.service.impl.TestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yooonn
 * @date 2021.01.23
 */
@Component
public class TestJob {

    private static final Logger          log = LoggerFactory.getLogger(TestJob.class);
    @Autowired
    private              TestServiceImpl testService;

    @XxlJob("testJob")
    public ReturnT<String> execute(String param) throws Exception {
        log.info("param = {}", param);
        testService.test(param);

        return ReturnT.SUCCESS;
    }
}
