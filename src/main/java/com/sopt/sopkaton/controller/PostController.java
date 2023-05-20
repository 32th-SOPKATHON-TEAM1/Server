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

    @PostMapping
    public ApiResponse<PostResDto> savePost(@RequestBody PostReqDto request) {
        DalleReqDto dto = new DalleReqDto("");
        Call<DalleResDto> call = externalService.getPost(dto);
        PostResDto result = null;
        try {
            Response<DalleResDto> response = call.execute();
            if (response.isSuccessful()) {
                result = postService.savePost(response.body().getData().get(0).getUrl(),request.getName(), request.getTitle());
            }
        } catch (IOException e) {
            System.out.println("img error " + e.getMessage());
        }
        return ApiResponse.success(Success.SAVE_POST_SUCCESS, result);

    }

}
