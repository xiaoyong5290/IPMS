package com.xiaoyong.controller;

import com.alibaba.fastjson.JSONArray;
import com.xiaoyong.model.entity.EntryExitRecord;
import com.xiaoyong.service.EntryExitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 16:50
 * Description    :
 */
@Controller
@RequestMapping("/eae")
public class EntryExitController {

    private final EntryExitRecordService entryExitRecordService;

    @Autowired
    public EntryExitController(EntryExitRecordService entryExitRecordService) {
        this.entryExitRecordService = entryExitRecordService;
    }

    @RequestMapping("/create")
    @ResponseBody
    public String createEAERecord(String plateId, int enterPortId) {
        Date enterTime = new Date();
        Timestamp time = new Timestamp(enterTime.getTime());
        byte[] enterImg = new byte[]{2, 3, 3, 3, 3};

        EntryExitRecord record = new EntryExitRecord();
        record.setPlateId(plateId);
        record.setEnterPortId(enterPortId);
        record.setEnterTime(time);
        record.setEnterImg(enterImg);

        return entryExitRecordService.createRecord(record);
    }

    @RequestMapping("/complete")
    @ResponseBody
    public String completeEAERecord(String plateId, int exitPortId) {
        Date enterTime = new Date();
        Timestamp time = new Timestamp(enterTime.getTime());
        byte[] exitImg = new byte[]{6, 6, 6, 6, 6};

        EntryExitRecord record = new EntryExitRecord();
        record.setPlateId(plateId);
        record.setExitPortId(exitPortId);
        record.setExitTime(time);
        record.setExitImg(exitImg);

        return entryExitRecordService.completeRecord(record);
    }

    /**
     * 查询出还没有完成进出场记录，即停车场内还未出场的汽车的进出场记录
     */
    @RequestMapping("/uncompleted")
    @ResponseBody
    public String getUncompletedRecords() {
        List<EntryExitRecord> recordsList = entryExitRecordService.getUncompletedRecords();
        return JSONArray.toJSON(recordsList).toString();
    }

    /**
     * 查询剩余泊位数量
     */
    @RequestMapping("/berthCount")
    @ResponseBody
    public int getRemainedBerthCount() {
        return entryExitRecordService.getRemainedBerthCount();
    }


}
