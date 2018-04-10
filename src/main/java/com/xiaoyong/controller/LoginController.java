package com.xiaoyong.controller;

import com.xiaoyong.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 14:32
 * Description    :
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String user,String password) {
        return loginService.login(user,password);
    }
}
