package com.baioretto.wishbottle.service;

import com.baioretto.wishbottle.bean.ImageInfo;
import com.baioretto.wishbottle.bean.R;
import com.baioretto.wishbottle.enumerate.State;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
@PropertySource("classpath:/storage.properties")
public class StorageServiceImpl implements StorageService {

    @Value("${image.localDirPath:/home/storage/}")
    private String localDirPath;
    @Value("${image.urlPath:https://baioretto.com/}")
    private String urlPath;

    @Override
    public R store(MultipartFile multipartFile) {
        if (multipartFile == null) return R.no(State.FILE_NOT_EXISTS);
        String fileName = multipartFile.getOriginalFilename();
        if (fileName == null || !fileName.matches("^.+\\.(?i)(jpg|png|jpeg|jfif)$")) return R.no(State.ILLEGAL_FILE_NAME);

        String dateDir = new SimpleDateFormat("/yyyy/MM/dd/").format(new Date());
        File dir = new File(localDirPath + dateDir);

        if (!dir.exists() && !dir.mkdirs()) return R.no(State.UNEXPECTED_EXCEPTION);

        fileName = UUID.randomUUID().toString().replace("-", "") + fileName.substring(fileName.lastIndexOf("."));

        File file = new File(dir, fileName);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            return R.no(State.UPLOAD_FAIL);
        }

        return R.ok(new ImageInfo(urlPath + dateDir + fileName, fileName));
    }
}
