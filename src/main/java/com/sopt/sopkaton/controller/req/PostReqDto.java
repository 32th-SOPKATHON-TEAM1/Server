package com.sopt.sopkaton.controller.req;

import lombok.Getter;

import java.util.List;

@Getter
public class PostReqDto {
    private String title;
    private String name;
    private List<EmotionReqDto> emotions;

}
