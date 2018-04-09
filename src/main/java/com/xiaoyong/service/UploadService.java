package com.xiaoyong.service;

import com.xiaoyong.model.dao.UploadDao;
import com.xiaoyong.model.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

/**
 * @author : XiaoYong
 * @date : 2018/3/30 13:40
 * Description    :
 */

@Service
public class UploadService{

    @Autowired
    UploadDao uploadDao;

    public String saveImage(Image image) {
        if (uploadDao.save(image) != null) {
            return "success !";
        }
        return "error !";
    }

}
