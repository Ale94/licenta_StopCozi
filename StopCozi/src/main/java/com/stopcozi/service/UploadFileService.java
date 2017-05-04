package com.stopcozi.service;

import org.springframework.stereotype.Service;

import com.stopcozi.domain.UploadFile;

@Service
public interface UploadFileService {

    void save (UploadFile file);
}
