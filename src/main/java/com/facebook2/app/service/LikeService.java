package com.facebook2.app.service;

import com.facebook2.app.service.request.LikeRequestDto;

public interface LikeService {
    void addLike(LikeRequestDto likeRequest) throws Exception;
}
