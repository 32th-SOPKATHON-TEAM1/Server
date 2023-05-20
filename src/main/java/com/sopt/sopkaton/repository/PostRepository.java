package com.sopt.sopkaton.repository;

import com.sopt.sopkaton.domain.Post;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface PostRepository extends Repository<Post, Long> {
    Optional<Post> findById(Long postId);

    void save(Post post);
}
