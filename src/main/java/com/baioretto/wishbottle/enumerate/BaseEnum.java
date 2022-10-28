package com.baioretto.wishbottle.enumerate;

public interface BaseEnum {
    default Integer getCode() {
        return null;
    }

    String getMessage();
}
