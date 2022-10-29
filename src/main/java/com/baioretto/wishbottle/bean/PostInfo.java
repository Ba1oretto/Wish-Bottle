package com.baioretto.wishbottle.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class PostInfo implements Serializable {
    private String username;
    private String message;
    private String avatar;
}
