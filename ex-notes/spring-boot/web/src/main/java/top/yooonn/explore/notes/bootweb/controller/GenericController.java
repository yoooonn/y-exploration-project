package top.yooonn.explore.notes.bootweb.controller;

import top.yooonn.explore.notes.bootweb.chain.followchain.ChainDelegator;
import top.yooonn.explore.notes.bootweb.chain.followchain.RuleData;
import top.yooonn.explore.notes.bootweb.model.Wrapper;
import top.yooonn.explore.notes.bootweb.model.request.FollowRequest;
import top.yooonn.explore.notes.bootweb.model.request.HeadlessRequest;
import com.ycourlee.tranquil.web.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yooonn
 * @date 2021.11.22
 */
@RestController
@RequestMapping("/generic")
public class GenericController {

    @Autowired
    private ChainDelegator chainDelegator;

    @PostMapping("/wrapped-request-body")
    public Response wrappedRequestBody(@RequestBody Wrapper<HeadlessRequest> request) {
        return Response.success();
    }

    @PostMapping("/follow")
    public Response follow(@RequestBody FollowRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        Response response = Response.success();
        chainDelegator.doExecute(response, new RuleData()
                .setRequest(request)
                .setServletRequest(servletRequest)
                .setServletResponse(servletResponse)
        );
        return response;
    }
}
