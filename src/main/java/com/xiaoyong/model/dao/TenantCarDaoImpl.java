package com.xiaoyong.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/11 15:51
 * Description    :
 */
public class TenantCarDaoImpl {

    @PersistenceContext
    private EntityManager em;

    public int findTenantIdByPlateId(String plateId) {
        String sql = "SELECT tc.tenantId FROM TenantCar tc " +
                " WHERE tc.plateId = ?1";

        Query query = em.createQuery(sql);
        query.setParameter(1,plateId);

        int result;
        try {
            result = (int) query.getSingleResult();
            return result;
        } catch (NoResultException e) {
            return -1;
        }
    }

    @SuppressWarnings("unchecked")
    public List<String> findPlateIdListByTenantId(int tenantId) {
        String sql = "SELECT tc.plateId FROM TenantCar tc " +
                " WHERE tc.tenantId = ?1";

        Query query = em.createQuery(sql);
        query.setParameter(1,tenantId);

        List<String> plateIdList = null;
        try {
            plateIdList = query.getResultList();
            return plateIdList;
        } catch (NoResultException e) {
            return null;
        }
    }
}
