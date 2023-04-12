package com.genspark.OM_OrderMicroservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileUploadServiceImp implements FileUploadServiceInt{

    @Override
    public void fileUpload(MultipartFile multipartFile) {
        try {
            System.out.println(" uploaded file with original name "+multipartFile.getOriginalFilename());
            String path="D:\\Order Management(GenSpark Capstone Project)\\Order_Management_Project_Mono_Repo\\Order_Management_BackEnd\\OM_OrderMicroservice\\gifts_uploads\\"
                    +multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(path));
        }
        catch(Exception exception){

        }
    }
}
