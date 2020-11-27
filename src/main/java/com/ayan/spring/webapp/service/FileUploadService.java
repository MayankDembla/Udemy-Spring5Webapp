package com.ayan.spring.webapp.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {

   public void fileupload(MultipartFile file) throws IOException {

      file.transferTo(new File("./uploaded" + file.getOriginalFilename()));
   }


}
