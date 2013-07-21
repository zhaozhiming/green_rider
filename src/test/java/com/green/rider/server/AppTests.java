package com.green.rider.server;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void should_create_user_correct() throws Exception {
        for (int i = 0; i < 10;i++){
            mockMvc.perform(post("/api/user/create")
                    .param("username", "user" + i)
                    .param("password", "123")
            ).andReturn();
        }

        for (int i = 0; i < 10;i++){
            mockMvc.perform(post("/api/plan/create")
                    .param("planname", "plan" + i)
                    .param("starter", i + 1 + "")
                    .param("start_time", "1375372510.00")
                    .param("start_place", "123;456")
                    .param("end_place", "456;123")
            ).andReturn();
        }
    }

}
