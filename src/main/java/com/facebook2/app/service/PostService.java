package com.facebook2.app.service;

import java.util.List;

import com.facebook2.app.service.request.PostRequestDto;
import com.facebook2.app.service.response.PostResponseDto;

public interface PostService {
	
    void createPost(PostRequestDto postRequest) throws Exception;

    List<PostResponseDto> getPostList(Integer userid);

	List<PostResponseDto> getAllPostList();

	void deleteUserpost(Integer id);
		
	}
