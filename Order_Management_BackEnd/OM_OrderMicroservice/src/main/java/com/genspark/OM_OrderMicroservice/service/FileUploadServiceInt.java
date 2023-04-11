package com.genspark.OM_OrderMicroservice.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadServiceInt {
    public void fileUpload(MultipartFile multipartFile);
}
