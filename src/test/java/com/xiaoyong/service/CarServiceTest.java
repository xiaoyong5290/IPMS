package com.xiaoyong.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author : XiaoYong
 * @date : 2018/4/11 16:10
 * Description    :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml","classpath:spring-mvc.xml"})
public class CarServiceTest {

    @Autowired
    CarService carService;

    @Test
    public void getOwnerId() {
        System.out.println(carService.getOwnerId("川A·12345"));
    }
}