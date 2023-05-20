package com.sopt.sopkaton.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String imageUrl;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String title;

    @Builder
    public Post(String imageUrl, String name, String title) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.title = title;
    }


}
