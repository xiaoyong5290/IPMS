package com.xiaoyong.model.dao;

import com.xiaoyong.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 14:34
 * Description    :
 */
@Repository
public interface LoginDao extends JpaRepository<Admin,String> {

    /**
     * @param user 通过用户名user从数据库查询出密码
     * @return 返回UserInfo对象
     */
    Admin findUserInfoByUsername(String user);

}
