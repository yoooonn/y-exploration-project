package com.ycourlee.explore.bootprocess.controller;

import com.ycourlee.tranquil.web.dto.Response;
import org.apache.catalina.util.RequestUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Response getString() {
        return Response.success().pin("uri", RequestUtil.getRequestURL(request));
    }

    @PostMapping("/simple-post")
    public Response simplePost() {
        return Response.success().pin("uri", RequestUtil.getRequestURL(request));
    }

    @GetMapping("/get-with-path-variable/{uid}")
    public Response getWithPathVariableUid(@PathVariable String uid) {
        return Response.success().pin("uri", RequestUtil.getRequestURL(request));
    }

    @PostMapping("/post-with-path-variable/{uid}")
    public Response postWithPathVariableUid(@PathVariable String uid) {
        return Response.success().pin("uri", RequestUtil.getRequestURL(request));
    }
}
