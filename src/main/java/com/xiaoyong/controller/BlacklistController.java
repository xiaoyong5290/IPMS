package com.xiaoyong.controller;

import com.xiaoyong.model.entity.Blacklist;
import com.xiaoyong.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 16:48
 * Description    :
 */
@Controller
@RequestMapping("/blacklist")
public class BlacklistController {

    private final BlacklistService blacklistService;

    @Autowired
    public BlacklistController(BlacklistService blacklistService) {
        this.blacklistService = blacklistService;
    }

    @RequestMapping("/isBlack")
    public String isBlack(String plateId) {
        boolean result = blacklistService.isBlack(plateId);
        if (result) {
            return "车牌：" + plateId + " 是黑名单用户！";
        }
        return "车牌：" + plateId + " 不是黑名单用户！";
    }

    @RequestMapping("/add")
    public void addBlacklist(String plateId) {
//        调用方法查询该车的车主是否有多辆车，如果有，一起加入黑名单


    }



}
