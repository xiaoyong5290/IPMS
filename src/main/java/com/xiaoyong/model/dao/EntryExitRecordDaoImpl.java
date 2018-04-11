package com.xiaoyong.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * @author : XiaoYong
 * @date : 2018/4/11 10:17
 * Description    :    “实现”EntryExitRecordDao接口
 *  无需implements相应的接口
 *  由entityManagerFactory调用，无需显式调用
 *  entityManagerFactory 是在application.xml中进行配置的
 */
@SuppressWarnings("unused")
public class EntryExitRecordDaoImpl {

    @PersistenceContext
    private EntityManager em;

    /**
     * 自定义实现EntryExitRecordDao接口中的countTenantCar()，实现多表查询
     * @return 返回在停车场内停了车的月租户的数量
     */
    public int countTenantCar() {
        System.out.println("hh");
        String sql =
                "SELECT COUNT(*) FROM EntryExitRecord r,TenantInfo t,TenantCar c " +
                        " WHERE r.plateId = c.plateId " +
                        " AND c.tenantId = t.tenantId " +
                        " AND t.leasehold <> 0 " +
                        " AND r.exitTime IS NULL ";
       /* 如果重复从一个query中getResult，那么会出现异常：
            java.lang.IllegalStateException: Session/EntityManager is closed
            因为getResult后query便会关闭，这点与Jdbc的ResultSet是相同的。
            */
        Query query = em.createQuery(sql);
        Object o = query.getSingleResult();
//        使用Math.toIntExact(long v)将long型转换为int型
        return Math.toIntExact((Long) o);
    }
}
