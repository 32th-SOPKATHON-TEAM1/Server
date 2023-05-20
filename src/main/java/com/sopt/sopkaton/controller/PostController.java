package com.sopt.sopkaton.controller;

import com.sopt.sopkaton.common.ApiResponse;
import com.sopt.sopkaton.controller.req.DalleReqDto;
import com.sopt.sopkaton.controller.req.PostReqDto;
import com.sopt.sopkaton.controller.res.DalleResDto;
import com.sopt.sopkaton.controller.res.PostResDto;
import com.sopt.sopkaton.domain.Post;
import com.sopt.sopkaton.exception.Success;
import com.sopt.sopkaton.service.ExternalService;
import com.sopt.sopkaton.service.PostService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final ExternalService externalService;

    @GetMapping("/{postId}")
    public ApiResponse<PostResDto> getPost(@PathVariable Long postId) {
        Post post = postService.getPost(postId);
        return ApiResponse.success(Success.FIND_POST_SUCCESS, PostResDto.of(post));
    }

    @GetMapping
    public ApiResponse<DalleResDto> savePost() {
        DalleReqDto dto = new DalleReqDto("Darkness came into the village and everyone was depressed. One citizen went out looking for another village, but feeling depressed, he returned and encouraged the villagers. Eventually, the village regained hope and found happiness. a painting of a cat in an oriental painting style");
        Call<DalleResDto> call = externalService.getPost(dto);
        try {
            Response<DalleResDto> response = call.execute();
            if (response.isSuccessful()) {
                return ApiResponse.success(Success.SAVE_POST_SUCCESS, response.body());
            }
        } catch (IOException e) {
            System.out.println("img error " + e.getMessage());
        }
        return null;

    }

}
