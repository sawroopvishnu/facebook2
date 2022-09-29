package com.facebook2.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.facebook2.app.entity.PostComment;
import com.facebook2.app.service.CommentService;
import com.facebook2.app.service.request.PostCommentRequestDto;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    
    // post comment
    @PostMapping("/comment/add")
    ResponseEntity<String> addComment(@RequestBody PostCommentRequestDto request) throws Exception {

        commentService.addComment(request);

        return ResponseEntity.ok("success");
    }

    @GetMapping("/comment/list/{pId}")
    ResponseEntity getCommentList(@PathVariable("pId") Integer pId){

        List<PostComment> res = commentService.getCommentList(pId);

        return ResponseEntity.ok(res);
    }
}
