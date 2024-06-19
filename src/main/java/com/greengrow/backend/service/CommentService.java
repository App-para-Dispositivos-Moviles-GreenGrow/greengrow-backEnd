package com.greengrow.backend.service;

import com.greengrow.backend.model.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);

    List<Comment> getAllComments();

    List<Comment> getCommentsByPostId(Long postId);

    List<Comment> getCommentsByUserId(Long userId);

    Comment getCommentById(Long id);

    void deleteCommentById(Long id);
}
