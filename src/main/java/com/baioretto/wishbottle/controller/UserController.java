package com.baioretto.wishbottle.controller;

import com.baioretto.wishbottle.bean.R;
import com.baioretto.wishbottle.bean.UserInfo;
import com.baioretto.wishbottle.service.DatabaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final DatabaseService databaseService;

    public UserController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/login")
    public R getBrokenToken(UserInfo userInfo) {
        return databaseService.validate(userInfo) ? R.ok(35683568) : R.no();
    }
}
