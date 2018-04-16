package com.xiaoyong.model.dao;

import com.xiaoyong.model.entity.BusinessCar;
import com.xiaoyong.model.entity.TenantCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 18:38
 * Description    :
 */
@SuppressWarnings("JavaDoc")
@Repository
public interface TenantCarDao extends JpaRepository<TenantCar, String>,
        CrudRepository<TenantCar, String> {

    /**
     * @param tenantId
     * @return 查询该月租户拥有的车辆数量
     */
    long countByTenantId(int tenantId);

    List<TenantCar> findByTenantId(int tenantId);

    int findTenantIdByPlateId(String plateId);

    List<String> findPlateIdListByTenantId(int tenantId);

}
