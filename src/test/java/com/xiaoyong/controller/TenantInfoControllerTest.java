package com.xiaoyong.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 11:51
 * Description    :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:spring-mvc.xml"})
public class TenantInfoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    TenantInfoController tenantInfoController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(tenantInfoController).build();
    }

    @Test
    public void tenantList() {

    }
}