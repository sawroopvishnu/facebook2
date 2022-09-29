package com.facebook2.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook2.app.entity.PostComment;
import com.facebook2.app.entity.UserPost;
import com.facebook2.app.entity.UserProfile;
import com.facebook2.app.repository.PostCommentRepo;
import com.facebook2.app.repository.UserPostsRepo;
import com.facebook2.app.repository.UserProfileRepo;
import com.facebook2.app.service.CommentService;
import com.facebook2.app.service.request.PostCommentRequestDto;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    private PostCommentRepo postCommentRepo;

    @Autowired
    private UserProfileRepo userProfileRepo;

    @Autowired
    private UserPostsRepo userPostsRepo;

    @Override
    public void addComment(PostCommentRequestDto request) throws Exception {

        PostComment postComment = new PostComment();
        UserProfile user = userProfileRepo.findById(request.getUserid()).orElseThrow(null);
        UserPost post = userPostsRepo.findById(request.getPostId()).orElseThrow(null);
        if(user == null || post == null){
            throw new Exception("Invalid request.....");
        }
        postComment.setUser(user);
        postComment.setPost(post);
        postComment.setComment(request.getComment());
        postCommentRepo.save(postComment);
    }

    @Override
    public List<PostComment> getCommentList(Integer pId) {

        List<PostComment> res = postCommentRepo.findByPostId(pId);
        return res;
    }
}
