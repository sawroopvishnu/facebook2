package com.facebook2.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.facebook2.app.service.PostService;
import com.facebook2.app.service.request.PostRequestDto;
import com.facebook2.app.service.response.PostResponseDto;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("post/create")
    ResponseEntity createPost(@RequestBody PostRequestDto postRequest) throws Exception {

        postService.createPost(postRequest);

       return ResponseEntity.ok("sucess");
    }

    @GetMapping("/post/list/{userId}")
    ResponseEntity getPostList(@PathVariable("userId") Integer userid){

        List<PostResponseDto> res = postService.getPostList(userid);

        return ResponseEntity.ok(res);
    }

    
    @GetMapping("/post/list")
    ResponseEntity<List> getPostList(){

        List<PostResponseDto> postList = postService.getAllPostList();

        return ResponseEntity.ok(postList);
    }

    
    @DeleteMapping("/post/delete/{id}")
    ResponseEntity getbypostid(@PathVariable("id") Integer id){

       postService.deleteUserpost(id);

        return ResponseEntity.ok(true);
    }
}
