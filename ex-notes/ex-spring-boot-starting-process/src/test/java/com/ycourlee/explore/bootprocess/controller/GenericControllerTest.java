package com.ycourlee.explore.bootprocess.controller;

import com.alibaba.fastjson.JSON;
import com.ycourlee.explore.bootprocess.SpringTestEnv;
import com.ycourlee.explore.bootprocess.model.Wrapper;
import com.ycourlee.explore.bootprocess.model.request.HeadlessRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yongjiang
 * @date 2021.12.27
 */
public class GenericControllerTest extends SpringTestEnv {

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new GenericController()).build();
    }

    @Test
    public void getConfig() throws Exception {
        HeadlessRequest request = new HeadlessRequest();
        mvc.perform(MockMvcRequestBuilders
                        .post("/generic/wrapped-request-body")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(Wrapper.wrapped(request)))
                ).andExpect(status().isOk())
                .andDo(print());
    }
}
