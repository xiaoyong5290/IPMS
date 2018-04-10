package com.xiaoyong.service;

import com.xiaoyong.model.dao.TenantDao;
import com.xiaoyong.model.entity.TenantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 10:50
 * Description    :
 */
@Service
public class TenantService {

    private final TenantDao tenantDao;


    @Autowired
    public TenantService(TenantDao tenantDao) {
        this.tenantDao = tenantDao;
    }

    public List<TenantInfo> getAllActiveTenants() {
        return tenantDao.findAllByLeasehold(1);
    }

    public List<TenantInfo> getAllInactiveTenants() {
        return tenantDao.findAllByLeasehold(0);
    }
}
