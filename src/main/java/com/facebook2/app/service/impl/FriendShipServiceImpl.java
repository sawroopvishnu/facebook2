package com.facebook2.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook2.app.entity.FriendShip;
import com.facebook2.app.entity.UserProfile;
import com.facebook2.app.repository.FriendShipRepo;
import com.facebook2.app.repository.UserProfileRepo;
import com.facebook2.app.service.FriendShipService;
import com.facebook2.app.service.request.FriendRequestDto;
import com.facebook2.app.service.response.FriendResponseDto;

@Service
public class FriendShipServiceImpl implements FriendShipService {

    @Autowired
    private FriendShipRepo friendShipRepo;

    @Autowired
    private UserProfileRepo userProfileRepo;
    @Override
    public void addFriend(FriendRequestDto friendRequest)throws Exception {

        FriendShip friendShip = new FriendShip();
       UserProfile requestUser = userProfileRepo.findById(friendRequest.getFriendRequest()).orElseThrow(null);
       UserProfile acceptUser = userProfileRepo.findById(friendRequest.getFriendAccept()).orElseThrow(null);
       
       if(requestUser == null || acceptUser == null){
           throw new Exception("user not found");
       }
       friendShip.setFriendRequest(requestUser);
       friendShip.setFriendAccept(acceptUser);
       friendShipRepo.save(friendShip);
    }

    @Override
    public List<UserProfile> getFriendList(Integer userId) throws Exception {
        if(userId == null || userId <=0){
            throw new Exception("Invalid user");
        }
        List<FriendShip> request = friendShipRepo.findByFriendRequest(userId);
        List<FriendShip> accept = friendShipRepo.findByFriendAccept(userId);
        
        List<UserProfile> result = new ArrayList<>();
        for(FriendShip friendShip : request){
            result.add(friendShip.getFriendAccept());
        }
        for(FriendShip friendShip : accept){
            result.add(friendShip.getFriendRequest());
        }
        return result;
    }

    
    
	@Override
	public List<FriendResponseDto> getAllFriendList() {
	 List<FriendResponseDto> friendlist=new ArrayList<>();
	 List<FriendShip> flist = friendShipRepo.findAll();
	 for(FriendShip friends : flist) {
		 FriendResponseDto temp = new FriendResponseDto();
     	 temp.setFriendRequest(friends.getFriendRequest());
     	 temp.setFriendAccept(friends.getFriendAccept());
     	 friendlist.add(temp);
     	 
     }
	 return friendlist;

	
	}
}
