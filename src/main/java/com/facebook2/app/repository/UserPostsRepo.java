package com.facebook2.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facebook2.app.entity.UserPost;

public interface UserPostsRepo extends JpaRepository<UserPost, Integer> {

    @Query("select q from UserPost q where q.user.id =:userId and q.deletedAt is null")
    List<UserPost> findByUserId(@Param("userId") Integer userId);

	}
