package com.stopcozi.service;

import org.springframework.stereotype.Service;

import com.stopcozi.domain.UploadFile;

@Service
public interface UploadFileService {

    void save (UploadFile file);
    UploadFile findById(Long idFile);
    void deleteById(Long idFile);
    void merge(UploadFile file);
}
