package com.baioretto.wishbottle.service;

import com.baioretto.wishbottle.bean.R;

public interface BottleService {
    R getRandomlyBottle();

    R getRandomlyBottle$private();

    R reload();
}
