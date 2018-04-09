package com.xiaoyong.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author : XiaoYong
 * @date : 2018/4/9 13:35
 * Description    :
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:spring-mvc.xml"})
public class WelcomeControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WelcomeController welcomeController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(welcomeController).build();
    }

    @Test
    public void login() throws Exception {
        MultiValueMap<String,String>  nameAndPwd = new LinkedMultiValueMap<String, String>();
        nameAndPwd.add("name","admin");
        nameAndPwd.add("password","0000");

        ResultActions actions = this.mockMvc.perform
                (MockMvcRequestBuilders.post("/login")
                        .params(nameAndPwd));
        MvcResult mvcResult = actions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println(result);
    }
}