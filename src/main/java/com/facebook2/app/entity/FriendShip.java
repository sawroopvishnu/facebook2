package com.facebook2.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class FriendShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "profile_request")
    private UserProfile friendRequest;

    @ManyToOne
    @JoinColumn(name = "profile_accept")
    private UserProfile friendAccept;

    private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
    
    
}
