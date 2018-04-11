package com.xiaoyong.service;

import com.xiaoyong.model.dao.EntryExitRecordDao;
import com.xiaoyong.model.dao.TenantInfoDao;
import com.xiaoyong.model.entity.EntryExitRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 17:35
 * Description    :
 */
@Service
public class EntryExitRecordService {


    private final EntryExitRecordDao entryExitRecordDao;
    private final TenantInfoDao tenantInfoDao;

    @Autowired
    public EntryExitRecordService(EntryExitRecordDao entryExitRecordDao, TenantInfoDao tenantInfoDao) {
        this.entryExitRecordDao = entryExitRecordDao;
        this.tenantInfoDao = tenantInfoDao;
    }

    public String createRecord(EntryExitRecord newRecord) {
        EntryExitRecord record = entryExitRecordDao.save(newRecord);
        if (record != null) {
            return "生成进出场记录成功！  车牌号：" + record.getPlateId()
                    + "入口编号：" + record.getEnterPortId() + "  "
                    + "入场时间：" + record.getEnterTime();
        }
        return "生成进出场记录失败！";
    }

    public List<EntryExitRecord> getUncompletedRecords() {
        return entryExitRecordDao.findAllByExitTimeNull();
    }

    public int getRemainedBerthCount() {
//        此处还要减去月租户数量，但暂时保持这样
//        List<EntryExitRecord> carList = entryExitRecordDao.findAllByExitTimeNull();

        return (int)entryExitRecordDao.countTenantCar();
    }

    public String completeRecord(EntryExitRecord entryExitRecord) {
        System.out.println("aaa");
        EntryExitRecord record = entryExitRecordDao.findByPlateIdAndExitTimeNull(entryExitRecord.getPlateId());
        System.out.println("bbb");
        record.setExitPortId(entryExitRecord.getExitPortId());
        record.setExitTime(entryExitRecord.getExitTime());
        record.setExitImg(entryExitRecord.getExitImg());


        record = entryExitRecordDao.save(record);
        return "车牌号为：" + record.getPlateId() + "的进出场纪录："
                + "入口编号：" + record.getEnterPortId()
                + "入场时间：" + record.getEnterTime()
                + "出口编号：" + record.getExitPortId()
                + "出场时间：" + record.getExitTime();
    }
}
