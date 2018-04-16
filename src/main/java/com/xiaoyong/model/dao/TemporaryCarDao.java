package com.xiaoyong.model.dao;

import com.xiaoyong.model.entity.TemporaryCar;
import com.xiaoyong.model.entity.TenantCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 18:37
 * Description    :
 */
@SuppressWarnings("JavaDoc")
@Repository
public interface TemporaryCarDao  extends JpaRepository<TemporaryCar, String>,
        CrudRepository<TemporaryCar, String> {

}
