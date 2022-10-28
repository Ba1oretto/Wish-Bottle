package com.baioretto.wishbottle.controller;

import com.baioretto.wishbottle.bean.R;
import com.baioretto.wishbottle.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class FileUploadController {
    private final StorageService storageService;

    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value = "/upload")
    public R handleFileUpload(MultipartFile file) {
        return storageService.store(file);
    }
}
