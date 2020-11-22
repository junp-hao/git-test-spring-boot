package com.example.kaoyan.controller;

import com.example.kaoyan.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class FileController {

    @Autowired
    FileMapper fileMapper;

    @PostMapping("/upload")
    public String upload(@RequestParam("file_upload") MultipartFile file_upload,@RequestParam("content")String content) {
        // 获得文件名称
        String VidoeName = file_upload.getOriginalFilename();
        System.out.println(VidoeName);
        String date=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
        //保存视频并确定保存路径
        File fileSave = new File("D:\\IDEA\\demo\\kaoyan\\src\\main\\resources\\static\\file_upload\\", VidoeName);
        try {
            file_upload.transferTo(fileSave);
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileMapper.insertFile(VidoeName,content,date);
        return "上传成功！！！";
    }
}
