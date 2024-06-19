package com.greengrow.backend.service.impl;

import com.greengrow.backend.exception.ResourceNotFoundException;
import com.greengrow.backend.model.Comment;
import com.greengrow.backend.repository.CommentRepository;
import com.greengrow.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommenServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public List<Comment> getCommentsByUserId(Long userId) {
        return commentRepository.findByUserId(userId);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + id));
    }

    @Override
    public void deleteCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + id));
        commentRepository.delete(comment);
    }
}
