package com.xiaoyong.service;

import com.xiaoyong.model.dao.LoginDao;
import com.xiaoyong.model.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 14:33
 * Description    :
 */
@Service
public class LoginService {

    private final LoginDao loginDao;

    @Autowired
    public LoginService(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public String login(String user, String password) {
        UserInfo userInfo = loginDao.findUserInfoByUser(user);
        if (userInfo == null) {
            return "FAILED !";
        }
        if (password.equals(userInfo.getPassword())) {
            return "欢迎你， " + user + " ！";
        }
        return "FAILED !";
    }
}
