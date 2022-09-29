package com.facebook2.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook2.app.entity.UserPost;
import com.facebook2.app.entity.UserProfile;
import com.facebook2.app.repository.UserPostsRepo;
import com.facebook2.app.repository.UserProfileRepo;
import com.facebook2.app.service.PostService;
import com.facebook2.app.service.request.PostRequestDto;
import com.facebook2.app.service.response.PostResponseDto;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private UserProfileRepo userProfileRepo;

    @Autowired
    private UserPostsRepo userPostsRepo;

    @Override
    public void createPost(PostRequestDto postRequest) throws Exception {

        UserPost userPost = new UserPost();
        UserProfile user = userProfileRepo.findById(postRequest.getUserId()).orElseThrow(null);
        if(user == null){
            throw new Exception("user not found");
        }
        userPost.setUser(user);
        userPost.setWriteText(postRequest.getWriteText());
        userPost.setMediaPath(postRequest.getMediaPath());
        userPost.setCreatedAt(new Date());
        userPostsRepo.save(userPost);
    }

    
    
    @Override
    public List<PostResponseDto> getPostList(Integer userid) {

    	List<PostResponseDto> Response= new ArrayList<>();
        List<UserPost> res = userPostsRepo.findByUserId(userid);
        for(UserPost post : res) {
        	PostResponseDto temp = new PostResponseDto();
        	 temp.setUserId(post.getUser().getId());
        	 temp.setPostid(post.getId());
        	 temp.setUsername(post.getUser().getName());
        	 temp.setMsg(post.getWriteText());
        	 Response.add(temp);
        }
        return Response;
    }

    
    
	@Override
	public List<PostResponseDto> getAllPostList() {
		List<PostResponseDto> Response= new ArrayList<>();
        List<UserPost> res = userPostsRepo.findAll();
        for(UserPost post : res) {
        	PostResponseDto temp = new PostResponseDto();
        	 temp.setUserId(post.getUser().getId());
        	 temp.setPostid(post.getId());
        	 temp.setUsername(post.getUser().getName());
        	 temp.setMsg(post.getWriteText());
        	 Response.add(temp);
        }
        return Response;
	}
	

	@Override
	public void deleteUserpost(Integer id) {
        UserPost res = userPostsRepo.findById(id).orElse(null);
        res.setDeletedAt(new Date());
        userPostsRepo.save(res);
        
    }
	
	
}
