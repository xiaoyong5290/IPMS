package com.xiaoyong.model.dao;

import com.xiaoyong.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
    *    @author  : XiaoYong
    *    @date    : 2018/3/24 14:25
    *    Description    :
    */

@Repository
public interface UserDao extends JpaRepository<User,Integer>,
         PagingAndSortingRepository<User,Integer>{
    /**
     *   描述：通过userId查询user
     *
    **/
    User findUserByUserid(Integer userId);

    @Override
    Page<User> findAll(Pageable pageable);

    @SuppressWarnings("unchecked")
    User save(User user);
}
