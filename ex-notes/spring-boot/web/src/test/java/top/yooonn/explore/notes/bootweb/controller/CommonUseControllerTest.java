package top.yooonn.explore.notes.bootweb.controller;

import top.yooonn.explore.notes.bootweb.BootProcessApplicationTests;
import top.yooonn.explore.notes.bootweb.model.request.HeadlessRequest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yooonn
 * @date 2021.12.27
 */
public class CommonUseControllerTest extends BootProcessApplicationTests {

    @Test
    public void ping() throws Exception {
        HeadlessRequest request = new HeadlessRequest();
        mockMvc.perform(MockMvcRequestBuilders
                                .post("/common/ping/{message}", "hello")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                        // .content(JSON.toJSONString(Wrapper.wrapped(request)))
                )
                .andExpect(status().isOk())
                .andDo(print());
    }
}
