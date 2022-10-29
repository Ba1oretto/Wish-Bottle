package com.baioretto.wishbottle.controller;

import com.baioretto.wishbottle.bean.R;
import com.baioretto.wishbottle.service.BottleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bottle")
public class BottleViewerController {
    private final BottleService bottleService;

    public BottleViewerController(BottleService bottleService) {
        this.bottleService = bottleService;
    }

    @GetMapping("/get")
    public R getRandomBottle(String token) {
        return (35683568 + "").equals(token) ? bottleService.getRandomlyBottle$private() : bottleService.getRandomlyBottle();
    }
}