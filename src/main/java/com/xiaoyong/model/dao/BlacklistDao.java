package com.xiaoyong.model.dao;

import com.xiaoyong.model.entity.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/10 18:29
 * Description    :
 */
@Repository
@SuppressWarnings("JavaDoc")
public interface BlacklistDao extends JpaRepository<Blacklist,String>,
        CrudRepository<Blacklist,String> {

    /**
     * @param blacklist
     * @return 添加黑名单
     */
    @Override
    @SuppressWarnings("unchecked")
    Blacklist save(Blacklist blacklist);

    /**
     * @return 查询所有在黑名单中的车辆
     */
    @Override
    List<Blacklist> findAll();

    /**
     * @param plateId 通过车牌号删除黑名单记录
     */
    @Override
    void delete(String plateId);

    /**
     * @param plateId 查找指定车牌的黑名单记录
     * @return 返回对象表明查询成功，返回null表明没有指定plateId的记录
     */
    Blacklist findByPlateId(String plateId);
}
