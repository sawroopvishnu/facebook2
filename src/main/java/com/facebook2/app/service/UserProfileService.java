package com.facebook2.app.service;

import java.util.List;

import com.facebook2.app.service.request.UserRequestDto;

public interface UserProfileService {
	
    void addUser(UserRequestDto userRequest);

	void getUserbyid(Integer id);

    
}
