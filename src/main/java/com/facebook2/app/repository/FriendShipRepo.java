package com.facebook2.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facebook2.app.entity.FriendShip;

public interface FriendShipRepo extends JpaRepository<FriendShip, Integer> {

    @Query("select q from FriendShip q where q.friendRequest.id = :userId")
    List<FriendShip> findByFriendRequest(@Param("userId") Integer userId);
    
    @Query("select q from FriendShip q where q.friendAccept.id = :userId")
    List<FriendShip> findByFriendAccept(@Param("userId") Integer userId);
}
