package com.facebook2.app.service.request;


public class PostRequestDto {

    private int userId;
    private String writeText;
    private String mediaPath;
    
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getWriteText() {
		return writeText;
	}
	public void setWriteText(String writeText) {
		this.writeText = writeText;
	}
	public String getMediaPath() {
		return mediaPath;
	}
	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}
    
    
}
