package com.xiaoyong.model.dao;

import com.xiaoyong.model.entity.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 18:29
 * Description    :
 */
public interface BlacklistDao extends JpaRepository<Blacklist,String>,CrudRepository<Blacklist,String> {
    @SuppressWarnings("unchecked")
    Blacklist save(Blacklist blacklist);

    List<Blacklist> findAll();

}
