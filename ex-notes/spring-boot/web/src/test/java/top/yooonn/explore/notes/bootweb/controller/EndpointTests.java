package top.yooonn.explore.notes.bootweb.controller;

import top.yooonn.explore.notes.bootweb.BootProcessApplication;
import top.yooonn.explore.notes.bootweb.BootProcessApplicationTests;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yooonn
 * @date 2022.06.06
 */
public class EndpointTests extends BootProcessApplicationTests {

    @Test
    public void conditions() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                                .get("/actuator/conditions")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(print())
        ;
        BootProcessApplication.InfoExposer.beanExist(applicationContext, "actorMapper", "movieMapper");
    }
}
