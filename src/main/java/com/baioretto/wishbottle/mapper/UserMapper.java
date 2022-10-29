package com.baioretto.wishbottle.mapper;

import com.baioretto.wishbottle.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserInfo validate(UserInfo userInfo);
}
