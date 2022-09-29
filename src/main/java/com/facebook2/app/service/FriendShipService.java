package com.facebook2.app.service;

import java.util.List;

import com.facebook2.app.entity.UserProfile;
import com.facebook2.app.service.request.FriendRequestDto;
import com.facebook2.app.service.response.FriendResponseDto;

public interface FriendShipService {
    void addFriend(FriendRequestDto friendRequest) throws Exception ;

    List<UserProfile> getFriendList(Integer userId) throws Exception ;

	List<FriendResponseDto> getAllFriendList();
}
