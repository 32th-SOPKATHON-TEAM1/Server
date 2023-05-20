package com.sopt.sopkaton.controller.req;

import java.util.List;
import lombok.Getter;

@Getter
public class PostReqDto {
    private String title;
    private String name;
    private List<Integer> emotions;
}
