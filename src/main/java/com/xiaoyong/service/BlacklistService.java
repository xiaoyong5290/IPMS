package com.xiaoyong.service;

import com.xiaoyong.model.dao.BlacklistDao;
import com.xiaoyong.model.entity.Blacklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : XiaoYong
 * @date : 2018/4/11 14:13
 * Description    :负责调用BlacklistDao中的方法
 */
@SuppressWarnings("JavaDoc")
@Service
public class BlacklistService {

    private static final String SUCCESS = "SUCCESS";
    private static final String FAILED = "FAILED";
    private static final String IS_EXISTS = "EXISTS";
    private static final String NOT_EXISTS = "NOT EXISTS";

    private final BlacklistDao blacklistDao;

    @Autowired
    public BlacklistService(BlacklistDao blacklistDao) {
        this.blacklistDao = blacklistDao;
    }

    /**
     * BlacklistService私有方法，调用Dao层方法从数据查询车牌号plateId对应的黑名单数据
     * 支援deleteSingleFromBlacklist()、isBlack()等方法。
     */
    private Blacklist getBlacklist(String plateId) {
        return blacklistDao.findByPlateId(plateId);
    }

    private Blacklist getBlacklistInstance(String plateId, String note) {
        Blacklist black = new Blacklist();
        black.setPlateId(plateId);
        black.setNote(note);

        return black;
    }

    private Blacklist getBlacklistInstance(Blacklist black, String plateId, String note) {
        black.setPlateId(plateId);
        black.setNote(note);

        return black;
    }

    /**
     * <查询>
     */
    public boolean isBlack(String plateId) {
        Blacklist blacklist = this.getBlacklist(plateId);
//        不在黑名单中
        if (blacklist == null) {
            return false;
        }
//        在黑名单中
        return true;
    }

    public String addSingleToBlacklist(String plateId, String note) {
        Blacklist black = this.getBlacklistInstance(plateId, note);

        return blacklistDao.save(black) != null ? SUCCESS : FAILED;
    }

    /**
     * <添加>
     * 调用Dao层方法将List中包含车牌号插入黑名单表
     */
    public String addMultiToBlacklist(List<String> plateIds, String note) {
        int count = plateIds.size();
        int succeed = 0;

        Blacklist black = new Blacklist();
        Blacklist echo = null;

        for (String plateId : plateIds) {
            black = this.getBlacklistInstance(black, plateId, note);

            echo = blacklistDao.save(black);
            if (echo != null) {
                succeed++;
                System.out.println(SUCCESS);
            }
            if (echo == null) {
                System.out.println(FAILED);
            }
        }
        return succeed == count ? SUCCESS : FAILED;
    }

    /**
     * <删除>
     * 调用Dao层方法删除黑名单
     */
    public boolean deleteSingleFromBlacklist(String plateId) {
        blacklistDao.delete(plateId);

        Blacklist black = this.getBlacklist(plateId);
//        black为空表示没有查询到相应的记录，说明删除成功
//        black不为空表示查询到相应的记录，说明删除失败
        return black == null;
    }


}
