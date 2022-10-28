package com.baioretto.wishbottle.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Validate {
    public boolean isBlank(String str) {
        return str == null || str.isBlank();
    }
}
