package com.facebook2.app.service.request;

public class LikeRequestDto {

    private int userId;
    private int postId;
    
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
    
    
}
