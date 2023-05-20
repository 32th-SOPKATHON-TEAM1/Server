package com.sopt.sopkaton.controller.res;

import com.sopt.sopkaton.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostResDto {
    private Long id;
    private String imgUrl;
    private String name;
    private String title;

    public static PostResDto of(Post post) {
        return new PostResDto(post.getId(), post.getImageUrl(), post.getName(), post.getTitle());
    }
}
