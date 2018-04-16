package com.xiaoyong.controller;

import com.xiaoyong.service.BlacklistService;
import com.xiaoyong.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 16:48
 * Description    :
 */
@Controller
@RequestMapping("/blacklist")
public class BlacklistController {

    private static final String SUCCESS = "SUCCESS";
    private static final String FAILED = "FAILED";
    private static final String IS_EXISTS = "EXISTS";
    private static final String NOT_EXISTS = "NOT EXISTS";

    private final BlacklistService blacklistService;
    private final CarService carService;

    @Autowired
    public BlacklistController(BlacklistService blacklistService, CarService carService) {
        this.blacklistService = blacklistService;
        this.carService = carService;
    }

    @RequestMapping("/isBlack")
    @ResponseBody
    public String isBlack(String plateId) {
        boolean result = blacklistService.isBlack(plateId);
        if (result) {
            return "车牌：" + plateId + " 是黑名单用户！";
        }
        return "车牌：" + plateId + " 不是黑名单用户！";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addBlacklist(String plateId, String note) {
        if (blacklistService.isBlack(plateId)) {
            return "该车牌已在黑名单中，不要重复添加！";
        }

        String msg = null;
//        调用方法查询该车的车主的所有车辆（仅商家和月租户），如果有，一起加入黑名单
        List<String> plateIdList = carService.getPlateIdListByPlateId(plateId);
        if (plateIdList.size() == 1) {
            msg = blacklistService.addSingleToBlacklist(plateId,note);
        }
        if (plateIdList.size() > 1) {
            msg = blacklistService.addMultiToBlacklist(plateIdList,note);
        }
        if (SUCCESS.equals(msg)) {
            return "添加黑名单成功！";
        }
        return "添加黑名单失败！";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String plateId) {
        if (!blacklistService.isBlack(plateId)) {
            return "车牌：" + plateId + " 不在黑名单中！无需删除！";
        }

        boolean deleted = blacklistService.deleteSingleFromBlacklist(plateId);
        if (deleted) {
            return "删除成功！";
        }
        return "删除失败！";
    }
}
