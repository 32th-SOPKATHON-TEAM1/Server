package com.sopt.sopkaton.controller.res;

import java.util.List;
import lombok.Getter;

@Getter
public class DalleResDto {
    private String created;
    private List<DalleUrlResDto> data;
}
