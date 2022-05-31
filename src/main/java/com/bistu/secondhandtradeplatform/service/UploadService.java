package com.bistu.secondhandtradeplatform.service;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Repository
public interface UploadService {
    Map<String,Object> commodityPic(String sku, MultipartFile multipartFile, HttpServletRequest req);
}
