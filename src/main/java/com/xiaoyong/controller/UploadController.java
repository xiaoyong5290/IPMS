package com.xiaoyong.controller;

import com.xiaoyong.model.entity.Image;
import com.xiaoyong.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author : XiaoYong
 * @date : 2018/3/30 8:24
 * Description    :
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    private final UploadService uploadService;

    @Autowired
    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @RequestMapping()
    public String upload() {
        System.out.println("upload()");
        return "upload";
    }

    /**
     * 描述：单文件上传
     **/
    @RequestMapping("/saveFile")
    @ResponseBody
    public String saveFile(MultipartFile upFile) throws IOException {

        System.out.println("sad");
        byte[] bytes = null;

        Image image = new Image();
        if (!upFile.isEmpty()) {
            bytes = upFile.getBytes();
            image.setImageName(upFile.getOriginalFilename());
            image.setData(bytes);

            return uploadService.saveImage(image);

           /* String filePath = "D:\\temp\\";

            File tempDir = new File(filePath);
            if (!tempDir.exists()) {
                tempDir.mkdirs();
            }
            saveFile = new File(filePath + upFile.getOriginalFilename());
            try {
                upFile.transferTo(saveFile);
            } catch (IOException e) {
                e.printStackTrace();
                return "error !";
            }
            return "success !";*/
        }
        return "error !";
    }


    /**
     *   描述：多文件上传
    **/
    @RequestMapping("/saveFiles")
    @ResponseBody
    //此处用@RequestParam（"xx"）来指定参数名，不加会报错
    public String saveFiles(@RequestParam("upFiles") MultipartFile[] upFiles){
        String filePath = "D:\\temp\\";

        File tempDir = new File(filePath);
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }

        if (upFiles != null && upFiles.length > 0) {
            File saveFile = null;
                //遍历并保存文件
                for (MultipartFile file : upFiles) {
                    try {
                        saveFile = new File(filePath + file.getOriginalFilename());
                        if (!saveFile.exists()) {
                            file.transferTo(saveFile);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        return "error !";
                    }
                }
        }
        return "success";
    }

}
