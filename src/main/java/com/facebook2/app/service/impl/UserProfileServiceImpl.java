package com.facebook2.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook2.app.entity.UserProfile;
import com.facebook2.app.repository.UserProfileRepo;
import com.facebook2.app.service.UserProfileService;
import com.facebook2.app.service.request.UserRequestDto;
import com.facebook2.app.service.response.UserResponseDto;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepo userProfileRepo;
   

    @Override
    public void addUser(UserRequestDto userRequest) {

        UserProfile user = new UserProfile();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setMobileNo(userRequest.getMobileNo());
        user.setPassword(userRequest.getPassword());
        user.setDob(Utils.stringTodate(userRequest.getDob()));
        user.setCreatedAt(new Date());
        userProfileRepo.save(user);
    }

    
    
    
	public List<UserResponseDto> getUser() {
		List<UserResponseDto> userRes = new ArrayList<>();
		List<UserProfile> uprofile =userProfileRepo.findAll();
		for(UserProfile profile : uprofile) {
		UserResponseDto getuser = new UserResponseDto();
		getuser.setId(profile.getId());
		getuser.setName(profile.getName());
		getuser.setEmail(profile.getEmail());
		getuser.setMobileNo(profile.getMobileNo());
		userRes.add(getuser);
		}
		return userRes;
	}




	@Override
	public void getUserbyid(Integer id) {
		userProfileRepo.findById(id);
	}




//	public List<UserResponseDto> getUserbyid(Integer id) {
//		List<UserResponseDto> userRes = new ArrayList<>();
//		Object uprofile =userProfileRepo.findById(id);
//		for(UserProfile profile : uprofile) {
//		UserResponseDto getuser = new UserResponseDto();
//		getuser.setId(profile.getId());
//		getuser.setName(profile.getName());
//		getuser.setEmail(profile.getEmail());
//		getuser.setMobileNo(profile.getMobileNo());
//		userRes.add(getuser);
//		}
//		return userRes;
//	}

    
}
