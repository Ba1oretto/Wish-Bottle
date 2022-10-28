package com.baioretto.wishbottle.service;

import com.baioretto.wishbottle.bean.PostInfo;
import com.baioretto.wishbottle.mapper.PostMapper;
import com.baioretto.wishbottle.util.Validate;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private final PostMapper postMapper;

    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public boolean upload(PostInfo postInfo) {
        if (Validate.isBlank(postInfo.getUsername())
                || Validate.isBlank(postInfo.getMessage())
                || Validate.isBlank(postInfo.getAvatar())
                || postInfo.getAvatar().trim().matches("^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$")
        ) return false;

        return postMapper.upload(postInfo);
    }


}
