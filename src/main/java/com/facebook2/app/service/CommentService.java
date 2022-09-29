package com.facebook2.app.service;



import java.util.List;

import com.facebook2.app.entity.PostComment;
import com.facebook2.app.service.request.PostCommentRequestDto;

public interface CommentService {
    void addComment(PostCommentRequestDto request) throws Exception;

    List<PostComment> getCommentList(Integer cId);
}
