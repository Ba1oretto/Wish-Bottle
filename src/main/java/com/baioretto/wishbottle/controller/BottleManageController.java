package com.baioretto.wishbottle.controller;

import com.baioretto.wishbottle.bean.PostInfo;
import com.baioretto.wishbottle.bean.R;
import com.baioretto.wishbottle.service.BottleService;
import com.baioretto.wishbottle.service.DatabaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bottle")
public class BottleManageController {
    private final DatabaseService databaseService;
    private final BottleService bottleService;

    public BottleManageController(DatabaseService databaseService, BottleService bottleService) {
        this.databaseService = databaseService;
        this.bottleService = bottleService;
    }

    @PostMapping("/upload")
    public R uploadPost(PostInfo postInfo) {
        return databaseService.addPost(postInfo);
    }

    @PutMapping("/internal/reload")
    public R reloadPost() {
        return bottleService.reload();
    }

    @DeleteMapping("/delete")
    public Boolean deletePost() {
        throw new RuntimeException("NOT IMPLEMENTED YET!");
    }
}
