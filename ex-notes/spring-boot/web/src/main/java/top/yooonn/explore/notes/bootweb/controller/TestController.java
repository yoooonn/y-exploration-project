package top.yooonn.explore.notes.bootweb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import top.yooonn.explore.notes.bootweb.context.ApplicationEventPublisherHolder;
import top.yooonn.explore.notes.bootweb.inject.InjectValuePortal;
import top.yooonn.explore.notes.bootweb.inject.ValueViewer;
import top.yooonn.explore.notes.bootweb.model.request.BaseRequest;
import top.yooonn.explore.notes.bootweb.service.TestService;
import com.ycourlee.tranquil.web.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yooonn
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
    private ValueViewer       valueViewer;

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
