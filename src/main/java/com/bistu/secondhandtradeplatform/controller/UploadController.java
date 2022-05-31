package com.bistu.secondhandtradeplatform.controller;

import com.bistu.secondhandtradeplatform.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/commodityPic")
    public Map<String,Object> commodityPic(@RequestParam("sku") String sku, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest req) {
        return uploadService.commodityPic(sku, multipartFile, req);
    }
}
