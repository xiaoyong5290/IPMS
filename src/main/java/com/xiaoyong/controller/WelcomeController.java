package com.xiaoyong.controller;

import com.alibaba.fastjson.JSON;
import com.xiaoyong.model.entity.Response;
import com.xiaoyong.model.entity.User;
import com.xiaoyong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author : XiaoYong
 * @date : 2018/3/26 14:34
 * Description    :
 */

@Controller
@RequestMapping
public class WelcomeController {

    private final UserService userService;

    @Autowired
    public WelcomeController(UserService userService) {
        this.userService = userService;
    }

/*
    @RequestMapping("/")
    public String index() {
        return "login";
    }*/

    @RequestMapping("/login")
    @ResponseBody
    public String login(String name,String password) {
        System.out.println(name);
        System.out.println(password);

        Response response = null;
        if ("admin".equals(name) && "0000".equals(password)) {
            response = Response.SUCCESS;
        } else {
            response = Response.ERROR;
        }

        return JSON.toJSONString(response);
    }

    /**
     * 描述：通过userId查询User
     **/
    @RequestMapping("/user")
    @ResponseBody
    public String user(Integer userId) {
//        从数据库查询数据
        User user = userService.queryByUserId(userId);
        return JSON.toJSONString(user);
    }

    @RequestMapping("/userlist")
    @ResponseBody
    public String userAll() {
        List<User> userList = userService.queryAll();
        return JSON.toJSONString(userList);
    }

    @RequestMapping("/userpage")
    @ResponseBody
    public String userAllPaged(HttpServletResponse response) {
        Pageable pageable = new PageRequest(0, 2);
        Page<User> users = userService.queryAll(pageable);

        System.out.println("总页数：   " + (users.getTotalPages() + 1));
        System.out.println("当前页：   " + users.getNumber());
        System.out.println(users.getSize());

        return JSON.toJSONString(users);
    }
}
