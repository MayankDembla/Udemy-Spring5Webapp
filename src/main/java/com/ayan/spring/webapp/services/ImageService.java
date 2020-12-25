package com.ayan.spring.webapp.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    void saveImageFile(Long valueOf, MultipartFile file) throws IOException;

}
