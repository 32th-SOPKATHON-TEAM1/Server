package com.sopt.sopkaton.service;

import com.sopt.sopkaton.controller.req.PostReqDto;
import com.sopt.sopkaton.domain.Post;
import com.sopt.sopkaton.exception.model.NotFoundException;
import com.sopt.sopkaton.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.sopt.sopkaton.exception.Error.NOT_FOUND_USER_EXCEPTION;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post getPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_USER_EXCEPTION, NOT_FOUND_USER_EXCEPTION.getMessage()));
    }

    public Post savePost(PostReqDto request) {
        return null;
    }
}
