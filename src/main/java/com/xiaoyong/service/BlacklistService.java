package com.xiaoyong.service;

import com.xiaoyong.model.dao.BlacklistDao;
import com.xiaoyong.model.entity.Blacklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : XiaoYong
 * @date : 2018/4/11 14:13
 * Description    :
 */
@Service
public class BlacklistService {

    private static final String SUCCESS = "SUCCESS !";
    private static final String FAILED = "FAILED !";

    private final BlacklistDao blacklistDao;

    @Autowired
    public BlacklistService(BlacklistDao blacklistDao) {
        this.blacklistDao = blacklistDao;
    }

    public boolean isBlack(String plateId) {
        Blacklist blacklist = blacklistDao.findByPlateId(plateId);

//        不在黑名单中
        if (blacklist == null) {
            return false;
        }
//        在黑名单中
        return true;
    }

    public String addSingleToBlacklist(String plateId, String note) {
        Blacklist black = new Blacklist();
        black.setPlateId(plateId);
        black.setNote(note);

        return blacklistDao.save(black) != null ? SUCCESS : FAILED;
    }

    /*public String addMultiToBlacklist(String[] plateIds) {

    }*/

    public String deleteSingleFromBlacklist(String plateId) {
        if (!this.isBlack(plateId)) {
            return "车牌为： "+plateId+" 的车辆不在黑名单中！";
        }

        Blacklist black = blacklistDao.deleteByPlateId(plateId);

        return black == null ? SUCCESS:FAILED;
    }

    private Blacklist getSingleBlacklist(String plateId) {
        return blacklistDao.findByPlateId(plateId);
    }

}
