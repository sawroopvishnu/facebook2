package com.facebook2.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facebook2.app.entity.UserProfile;

public interface UserProfileRepo extends JpaRepository<UserProfile, Integer> {

	//public Optional<UserProfile> findById(Integer id);
	
	
	
}
