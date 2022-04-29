package com.ycourlee.explore.notes.bootweb.controller;

import com.alibaba.fastjson.JSON;
import com.ycourlee.explore.notes.bootweb.BootProcessApplicationTests;
import com.ycourlee.explore.notes.bootweb.model.Wrapper;
import com.ycourlee.explore.notes.bootweb.model.request.HeadlessRequest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yongjiang
 * @date 2021.12.27
 */
public class GenericControllerTest extends BootProcessApplicationTests {

    @Test
    public void wrappedRequestBody() throws Exception {
        HeadlessRequest request = new HeadlessRequest();
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/generic/wrapped-request-body")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(Wrapper.wrapped(request)))
                ).andExpect(status().isOk())
                .andDo(print());
    }
}
