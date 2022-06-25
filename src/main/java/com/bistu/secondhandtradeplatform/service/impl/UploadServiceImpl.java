package com.bistu.secondhandtradeplatform.service.impl;

import com.bistu.secondhandtradeplatform.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UploadServiceImpl implements UploadService {

    @Value("${file.upload.path}")
    private String fileUploadPath;

    @Value("${slide.upload.path}")
    private String slideUploadPath;

    @Override
    public Map<String,Object> commodityPic(String sku, MultipartFile multipartFile, HttpServletRequest req) {
        Map<String,Object> result = new HashMap<>();
        //获取文件的名字
        String originName = multipartFile.getOriginalFilename();
        System.out.println("originName:"+originName);
        //判断文件类型
        assert originName != null;
        if(!originName.endsWith(".jpg")) {
            result.put("status","error");
            result.put("msg", "文件类型不对");
            return result;
        }
        File folder = new File(fileUploadPath);
        String newName = sku + ".jpg";
        //给上传文件取新的名字，避免重名
        try {
            //生成文件，folder为文件目录，newName为文件名
            multipartFile.transferTo(new File(folder, newName));
            //生成返回给前端的url
            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() +"/pic/"+ newName;
            System.out.println("url:"+url);
            //返回URL
            result.put("status", "success");
            result.put("url", url);
        }catch (IOException e) {
            result.put("status", "error");
            result.put("msg",e.getMessage());
        }
        return result;
    }

    @Override
    public Map<String,Object> slidePic(String index, MultipartFile multipartFile, HttpServletRequest req) {
        Map<String,Object> result = new HashMap<>();
        //获取文件的名字
        String originName = multipartFile.getOriginalFilename();
        System.out.println("originName:"+originName);
        //判断文件类型
        assert originName != null;
        if(!originName.endsWith(".jpg")) {
            result.put("status","error");
            result.put("msg", "文件类型不对");
            return result;
        }
        File folder = new File(slideUploadPath);
        String newName = index + ".jpg";
        //给上传文件取新的名字，避免重名
        try {
            //生成文件，folder为文件目录，newName为文件名
            multipartFile.transferTo(new File(folder, newName));
            //生成返回给前端的url
            String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() +"/slide/"+ newName;
            System.out.println("url:"+url);
            //返回URL
            result.put("status", "success");
            result.put("url", url);
        }catch (IOException e) {
            result.put("status", "error");
            result.put("msg",e.getMessage());
        }
        return result;
    }
}
