package com.baioretto.wishbottle.service;

import com.baioretto.wishbottle.bean.R;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    R store(MultipartFile file);
}
