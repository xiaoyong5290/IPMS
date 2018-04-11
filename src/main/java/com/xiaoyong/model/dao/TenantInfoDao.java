package com.xiaoyong.model.dao;

import com.xiaoyong.model.entity.TenantInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 10:55
 * Description    :
 */
@SuppressWarnings("JavaDoc")
@Repository
public interface TenantInfoDao extends JpaRepository<TenantInfo,Integer>,PagingAndSortingRepository<TenantInfo,Integer> {

    /**
     * @param leasehold 月租户状态位，为1则查找有效月租户，为0则查找过期月租户
     * @return 返回月租户列表
     */
    List<TenantInfo> findAllByLeasehold(int leasehold);
}
