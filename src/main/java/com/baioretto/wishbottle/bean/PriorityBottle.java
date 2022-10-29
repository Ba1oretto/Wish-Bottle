package com.baioretto.wishbottle.bean;

import lombok.Data;

@Data
public class PriorityBottle {
    PostInfo bottle;
    long lastVisit = 0;

    public static PriorityBottle create(PostInfo bottle) {
        return new PriorityBottle(bottle);
    }

    private PriorityBottle(PostInfo bottle) {
        this.bottle = bottle;
    }
}
