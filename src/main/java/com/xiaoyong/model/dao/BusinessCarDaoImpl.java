package com.xiaoyong.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/11 16:06
 * Description    :
 */
public class BusinessCarDaoImpl {

    @PersistenceContext
    private EntityManager em;

    public int findBusinessIdByPlateId(String plateId) {
        String sql = "SELECT bc.businessId FROM BusinessCar bc " +
                " WHERE bc.plateId = ?1";

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
    public List<String> findPlateIdListByBusinessId(int businessId) {
        String sql = "SELECT bc.plateId FROM BusinessCar bc " +
                " WHERE bc.businessId = ?1";

        Query query = em.createQuery(sql);
        query.setParameter(1, businessId);

        List<String> plateIdList = null;
        try {
            plateIdList = query.getResultList();
            return plateIdList;
        } catch (NoResultException e) {
            return null;
        }
    }
}
