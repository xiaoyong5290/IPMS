package com.xiaoyong.model.dao;

import com.xiaoyong.model.entity.EntryExitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 17:37
 * Description    :
 */
@SuppressWarnings("JavaDoc")
@Repository
public interface EntryExitRecordDao extends JpaRepository<EntryExitRecord,Integer>,CrudRepository<EntryExitRecord,Integer> {

    /**
     * 查询所有还没有出场的进出场记录
     * @see EntryExitRecord
     * @return 返回未出场记录列表
     */
    List<EntryExitRecord> findAllByExitTimeNull();

    /**
     * <此方法由EntryExitRecordDaoImpl提供自定义实现>
     * @return 返回未出场的月租户车辆数
     */
    int countTenantCar();

    /**
     * @param record
     * @see EntryExitRecord
     * @return
     */
    @Override
    @SuppressWarnings({"unchecked"})
    EntryExitRecord save(EntryExitRecord record);

    /**
     * @param plateId 通过plateId查找当前汽车（还没出停车场）的进出场记录
     * @see EntryExitRecord
     * @return
     */
    EntryExitRecord findByPlateIdAndExitTimeNull(String plateId);

    /**
     * @param plateId 通过plateId查找当前汽车的进出场记录
     * @see EntryExitRecord
     * @return
     */
    EntryExitRecord findByPlateId(String plateId);
}
