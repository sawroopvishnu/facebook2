package com.facebook2.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facebook2.app.entity.PostLike;

public interface PostLikeRepo extends JpaRepository<PostLike, Integer> {
}
