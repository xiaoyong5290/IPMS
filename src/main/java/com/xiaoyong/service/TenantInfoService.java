package com.xiaoyong.service;

import com.xiaoyong.model.dao.TenantInfoDao;
import com.xiaoyong.model.entity.TenantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 10:50
 * Description    :
 */
@Service
public class TenantInfoService {

    private final TenantInfoDao tenantInfoDao;


    @Autowired
    public TenantInfoService(TenantInfoDao tenantInfoDao) {
        this.tenantInfoDao = tenantInfoDao;
    }

    public List<TenantInfo> getAllActiveTenants() {
        return tenantInfoDao.findAllByLeasehold(1);
    }

    public List<TenantInfo> getAllInactiveTenants() {
        return tenantInfoDao.findAllByLeasehold(0);
    }
}
