package com.sopt.sopkaton.controller;

import com.sopt.sopkaton.common.ApiResponse;
import com.sopt.sopkaton.controller.req.PostReqDto;
import com.sopt.sopkaton.controller.res.PostResDto;
import com.sopt.sopkaton.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/{postId}")
    public ApiResponse<PostResDto> getPost(@PathVariable Long postId){
        return null;
    }

    @PostMapping
    public ApiResponse<PostResDto> savePost(@RequestBody PostReqDto request){
        return null;
    }

}
