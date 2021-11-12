package com.ycourlee.explore.bootprocess.controller;

import com.ycourlee.root.core.domain.context.Rtm;
import org.apache.catalina.util.RequestUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author yongjiang
 */
@RestController
public class DispatcherServletProcessingInvokingLinkController {

    @Resource
    private HttpServletRequest request;

    @GetMapping("/simple-get")
    public Rtm getString() {
        return Rtm.success().pin("uri", RequestUtil.getRequestURL(request));
    }

    @PostMapping("/simple-post")
    public Rtm simplePost() {
        return Rtm.success().pin("uri", RequestUtil.getRequestURL(request));
    }

    @GetMapping("/get-with-path-variable/{uid}")
    public Rtm getWithPathVariableUid(@PathVariable String uid) {
        return Rtm.success().pin("uri", RequestUtil.getRequestURL(request));
    }

    @PostMapping("/post-with-path-variable/{uid}")
    public Rtm postWithPathVariableUid(@PathVariable String uid) {
        return Rtm.success().pin("uri", RequestUtil.getRequestURL(request));
    }
}
