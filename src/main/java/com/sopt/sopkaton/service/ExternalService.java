package com.sopt.sopkaton.service;

import com.sopt.sopkaton.controller.req.DalleReqDto;
import com.sopt.sopkaton.controller.res.DalleResDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ExternalService {
    @POST("images/generations")
    Call<DalleResDto> getPost(@Body DalleReqDto body);
}
