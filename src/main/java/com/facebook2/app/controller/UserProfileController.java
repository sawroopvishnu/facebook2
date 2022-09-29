package com.facebook2.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.facebook2.app.entity.UserProfile;
import com.facebook2.app.service.UserProfileService;
import com.facebook2.app.service.impl.UserProfileServiceImpl;
import com.facebook2.app.service.request.UserRequestDto;
import com.facebook2.app.service.response.UserResponseDto;

@Controller
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;
    
    @Autowired
    private UserProfileServiceImpl userProfileServiceImpl;


    @PostMapping("/user/add")
    public ResponseEntity<String> createUser(@RequestBody UserRequestDto userRequest){

        userProfileService.addUser(userRequest);

        return ResponseEntity.ok("success");
    }
    
    
    @GetMapping("/user/list")
    public ResponseEntity userlist(){
         
    	List<UserResponseDto> userList = userProfileServiceImpl.getUser();

        return ResponseEntity.ok(userList);
        
    }
    
    @GetMapping("/user/list/{id}")
    public void userlistbyid(@PathVariable ("id") Integer id){
         
     userProfileServiceImpl.getUserbyid(id);

        
    }
    
    
}

