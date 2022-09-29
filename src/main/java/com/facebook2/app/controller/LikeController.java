package com.facebook2.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.facebook2.app.service.LikeService;
import com.facebook2.app.service.request.LikeRequestDto;

@Controller
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/like/add")
    ResponseEntity<String> addLike(@RequestBody LikeRequestDto likeRequest) throws Exception {

        likeService.addLike(likeRequest);

        return ResponseEntity.ok("success");
    }
}
