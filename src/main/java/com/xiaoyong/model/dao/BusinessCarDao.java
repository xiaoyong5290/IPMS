package com.xiaoyong.model.dao;

import com.xiaoyong.model.entity.Blacklist;
import com.xiaoyong.model.entity.BusinessCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 18:34
 * Description    :
 */
@SuppressWarnings("JavaDoc")
@Repository
public interface BusinessCarDao extends JpaRepository<BusinessCar, String>,
        CrudRepository<BusinessCar, String> {

    /**
     * @param businessId
     * @return 查询指定商家拥有的汽车数量
     */
    long countByBusinessId(int businessId);

    int findBusinessIdByPlateId(String plateId);

    @SuppressWarnings("SpringDataRepositoryMethodReturnTypeInspection")
    List<String> findPlateIdListByBusinessId(int businessId);

}
