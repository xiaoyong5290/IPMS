package com.xiaoyong.controller;

import com.alibaba.fastjson.JSONArray;
import com.xiaoyong.model.entity.TenantInfo;
import com.xiaoyong.service.TenantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 10:49
 * Description    :
 */
@Controller
@RequestMapping("/tenant")
public class TenantInfoController {

    private final TenantInfoService tenantInfoService;

    @Autowired
    public TenantInfoController(TenantInfoService tenantInfoService) {
        this.tenantInfoService = tenantInfoService;
    }

    @RequestMapping("/activeList")
    @ResponseBody
    public String activeTenantList() {
        List<TenantInfo> tenantInfoList = tenantInfoService.getAllActiveTenants();
        return JSONArray.toJSON(tenantInfoList).toString();
    }

    @RequestMapping("/inactiveList")
    @ResponseBody
    public String inactiveTenantList() {
        List<TenantInfo> tenantInfoList = tenantInfoService.getAllInactiveTenants();
        return JSONArray.toJSON(tenantInfoList).toString();
    }
}
