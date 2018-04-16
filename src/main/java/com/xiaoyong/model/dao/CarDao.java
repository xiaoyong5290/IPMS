package com.xiaoyong.model.dao;

import com.xiaoyong.model.entity.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : XiaoYong
 * @date : 2018/4/11 15:25
 * Description    :
 */
@Repository
public interface CarDao extends JpaRepository<Blacklist,String>,
        CrudRepository<Blacklist,String> {

    long countByPlateId(String plateId);

}
