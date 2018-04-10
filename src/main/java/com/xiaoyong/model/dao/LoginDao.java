package com.xiaoyong.model.dao;

import com.xiaoyong.model.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 14:34
 * Description    :
 */
@Repository
public interface LoginDao extends JpaRepository<UserInfo,String> {

    /**
     * @param user 通过用户名user从数据库查询出密码
     * @return 返回UserInfo对象
     */
    UserInfo findUserInfoByUser(String user);

}
