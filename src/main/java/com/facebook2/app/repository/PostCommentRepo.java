package com.facebook2.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facebook2.app.entity.PostComment;

public interface PostCommentRepo extends JpaRepository<PostComment, Integer> {

    @Query("select q from PostComment q where q.post.id =:pId")
    List<PostComment> findByPostId(@Param("pId") Integer pId);
}
