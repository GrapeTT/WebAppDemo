package com.tao.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Name：UserControllerTest
 * @Package：com.tao.controller
 * @Descripition：
 * @Author：涛
 * @Date：2018/3/26 19:33
 * @Version：1.0
 */
@ContextConfiguration(
        locations={"classpath:spring/applicationContext-dao.xml",
                "classpath:spring/applicationContext-service.xml",
                "classpath:spring/applicationContext-transaction.xml",
                "classpath:spring/springmvc.xml",
                "classpath:mybatis/SqlMapConfig.xml"
        })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/main/resources")
public class UserControllerTest {

    @Autowired
    private  UserController userController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void login() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/user/login");
        MvcResult result = mockMvc.perform(builder).andDo(print()).andExpect(status().isOk()).andReturn();
        Assert.assertEquals("index", result.getModelAndView().getViewName());
    }

    @Test
    public void register() throws Exception {
    }

}