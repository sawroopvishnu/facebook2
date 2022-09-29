package com.facebook2.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook2.app.entity.PostLike;
import com.facebook2.app.entity.UserPost;
import com.facebook2.app.entity.UserProfile;
import com.facebook2.app.repository.PostLikeRepo;
import com.facebook2.app.repository.UserPostsRepo;
import com.facebook2.app.repository.UserProfileRepo;
import com.facebook2.app.service.LikeService;
import com.facebook2.app.service.request.LikeRequestDto;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private UserProfileRepo userProfileRepo;

    @Autowired
    private UserPostsRepo userPostsRepo;

    @Autowired
    private PostLikeRepo postLikeRepo;

    @Override
    public void addLike(LikeRequestDto likeRequest) throws Exception {

        PostLike postLike = new PostLike();
        UserProfile user = userProfileRepo.findById(likeRequest.getUserId()).orElseThrow(null);
        UserPost userPost = userPostsRepo.findById(likeRequest.getPostId()).orElseThrow(null);
        if(user == null || userPost == null){
            throw new Exception("user not found");
        }
        postLike.setUser(user);
        postLike.setPost(userPost);
        postLikeRepo.save(postLike);
    }
}
