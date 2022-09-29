package com.facebook2.app.service.response;


import com.facebook2.app.entity.UserProfile;

public class FriendResponseDto {


    private UserProfile friendRequest;
    
    private UserProfile friendAccept;

	public UserProfile getFriendRequest() {
		return friendRequest;
	}

	public void setFriendRequest(UserProfile friendRequest) {
		this.friendRequest = friendRequest;
	}

	public UserProfile getFriendAccept() {
		return friendAccept;
	}

	public void setFriendAccept(UserProfile friendAccept) {
		this.friendAccept = friendAccept;
	}
    
}
