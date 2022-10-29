package com.baioretto.wishbottle.mapper;

import com.baioretto.wishbottle.bean.PostInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface BottleMapper {
    boolean uploadInfo(PostInfo postInfo);

    ArrayList<PostInfo> getAll();

    int count();
}
