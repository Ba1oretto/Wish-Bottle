package com.baioretto.wishbottle.mapper;

import com.baioretto.wishbottle.bean.PostInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    boolean upload(PostInfo postInfo);
}
