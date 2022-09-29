package com.facebook2.app.service.request;


public class FriendRequestDto {

    private int friendRequest;
    private int friendAccept;
    
	public int getFriendRequest() {
		return friendRequest;
	}
	public void setFriendRequest(int friendRequest) {
		this.friendRequest = friendRequest;
	}
	public int getFriendAccept() {
		return friendAccept;
	}
	public void setFriendAccept(int friendAccept) {
		this.friendAccept = friendAccept;
	}
    
}
