package com.xiaoyong.controller;

import com.xiaoyong.model.entity.Admin;
import com.xiaoyong.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 14:32
 * Description    :
 */
@SuppressWarnings("JavaDoc")
@Controller
@RequestMapping("/admin")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 登录使用POST方法
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Admin admin) {
        return loginService.login(admin.getUsername(),admin.getPassword());
    }
}
