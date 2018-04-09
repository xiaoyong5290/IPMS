package com.xiaoyong.service;

import com.xiaoyong.model.dao.UserDao;
import com.xiaoyong.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/3/27 15:19
 * Description    :
 */
@Service
public class UserService {

    private final UserDao userDAO;

    @Autowired
    public UserService(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    public User queryByUserId(Integer userId) {
        return userDAO.findUserByUserid(userId);
    }

    public List<User> queryAll() {
        return userDAO.findAll();
    }

    public Page<User> queryAll(Pageable pageable) {
        return userDAO.findAll(pageable);
    }

    public User saveUser(User user) {
        System.out.println("service");
        return userDAO.save(user);
    }
}
