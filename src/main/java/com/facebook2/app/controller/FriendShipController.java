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
import com.facebook2.app.service.FriendShipService;
import com.facebook2.app.service.request.FriendRequestDto;
import com.facebook2.app.service.response.FriendResponseDto;


@Controller
public class FriendShipController {

    @Autowired
    private FriendShipService friendShipService;

    @PostMapping("/friend/add")
    ResponseEntity<String> addFriend(@RequestBody FriendRequestDto friendRequest) throws Exception  {

        friendShipService.addFriend(friendRequest);

       return ResponseEntity.ok("success");
    }

    
    @GetMapping("/friend/list/{id}")
    ResponseEntity getFriendList(@PathVariable("id") Integer userId) throws Exception {

        List<UserProfile> res = friendShipService.getFriendList(userId);
        return ResponseEntity.ok(res);
    }
    
    
    
    @GetMapping("/friendlist")
    ResponseEntity<List> getAllfriend() {
    	List<FriendResponseDto> flist = friendShipService.getAllFriendList();
    	return ResponseEntity.ok(flist);
    }
    
}
