package com.ycourlee.explore.bootprocess.controller;

import com.ycourlee.explore.bootprocess.chain.followchain.ChainDelegator;
import com.ycourlee.explore.bootprocess.chain.followchain.RuleData;
import com.ycourlee.explore.bootprocess.model.Wrapper;
import com.ycourlee.explore.bootprocess.model.request.FollowRequest;
import com.ycourlee.explore.bootprocess.model.request.HeadlessRequest;
import com.ycourlee.root.core.domain.context.Rtm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yongjiang
 * @date 2021.11.22
 */
@RestController
@RequestMapping("/generic")
public class GenericController {

    @Autowired
    private ChainDelegator chainDelegator;

    @PostMapping("/wrapped-request-body")
    public Rtm wrappedRequestBody(@RequestBody Wrapper<HeadlessRequest> request) {
        return Rtm.success();
    }

    @PostMapping("/follow")
    public Rtm follow(@RequestBody FollowRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        Rtm response = Rtm.success();
        chainDelegator.doExecute(response, new RuleData()
                .setRequest(request)
                .setServletRequest(servletRequest)
                .setServletResponse(servletResponse)
        );
        return response;
    }
}
