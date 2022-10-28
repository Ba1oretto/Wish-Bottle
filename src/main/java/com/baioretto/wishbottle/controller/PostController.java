package com.baioretto.wishbottle.controller;

import com.baioretto.wishbottle.bean.PostInfo;
import com.baioretto.wishbottle.bean.R;
import com.baioretto.wishbottle.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bottle")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public R getPost() {
        return null;
    }

    @PostMapping("/upload")
    public R uploadPost(PostInfo postInfo) {
        return postService.upload(postInfo) ? R.ok() : R.no();
    }

    @DeleteMapping("/delete")
    public Boolean deletePost() {
        throw new RuntimeException("NOT IMPLEMENTED YET!");
    }
}
