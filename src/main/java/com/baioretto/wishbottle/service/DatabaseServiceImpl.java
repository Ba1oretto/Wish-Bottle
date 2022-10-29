package com.baioretto.wishbottle.service;

import com.baioretto.wishbottle.Container;
import com.baioretto.wishbottle.bean.PostInfo;
import com.baioretto.wishbottle.bean.PriorityBottle;
import com.baioretto.wishbottle.bean.R;
import com.baioretto.wishbottle.bean.UserInfo;
import com.baioretto.wishbottle.mapper.BottleMapper;
import com.baioretto.wishbottle.mapper.UserMapper;
import com.baioretto.wishbottle.util.Validate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseServiceImpl implements DatabaseService {
    private final BottleMapper bottleMapper;
    private final UserMapper userMapper;


    public DatabaseServiceImpl(BottleMapper bottleMapper, UserMapper userMapper) {
        this.bottleMapper = bottleMapper;
        this.userMapper = userMapper;
    }

    @Override
    public R addPost(PostInfo postInfo) {
        if (Validate.isBlank(postInfo.getUsername()) || postInfo.getUsername().length() > 32 || Validate.isBlank(postInfo.getMessage()))
            return R.no("invalid data");

        if (!bottleMapper.uploadInfo(postInfo) || !Container.BOTTLE_LIST.add(PriorityBottle.create(postInfo)))
            return R.no("fail to insert data");

        return R.ok();
    }

    @Override
    public boolean validate(UserInfo userInfo) {
        return userMapper.validate(userInfo) != null;
    }
}
