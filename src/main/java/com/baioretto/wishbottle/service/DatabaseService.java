package com.baioretto.wishbottle.service;

import com.baioretto.wishbottle.bean.PostInfo;
import com.baioretto.wishbottle.bean.R;
import com.baioretto.wishbottle.bean.UserInfo;

public interface DatabaseService {
    R addPost(PostInfo postInfo);

    boolean validate(UserInfo userInfo);
}