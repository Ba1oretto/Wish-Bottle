package com.baioretto.wishbottle.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private String account;
    private String password;
}
