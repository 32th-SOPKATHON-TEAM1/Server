package com.sopt.sopkaton.controller.res;

import com.sopt.sopkaton.domain.Post;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostResDto {
    private Long id;
    private String imgUrl;

    public static PostResDto of(Post post) {
        return new PostResDto(post.getId(), post.getImageUrl());
    }
}
