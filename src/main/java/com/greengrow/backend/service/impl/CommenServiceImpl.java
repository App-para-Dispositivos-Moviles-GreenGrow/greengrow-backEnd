package com.greengrow.backend.service.impl;

import com.greengrow.backend.exception.ResourceNotFoundException;
import com.greengrow.backend.model.Comment;
import com.greengrow.backend.model.Post;
import com.greengrow.backend.repository.CommentRepository;
import com.greengrow.backend.repository.PostRepository;
import com.greengrow.backend.repository.UserRepository;
import com.greengrow.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommenServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment createComment(Comment comment) {
        if (comment.getUserId() == null || !userRepository.existsById(comment.getUserId())) {
            throw new ResourceNotFoundException("User not found");
        }
        if (comment.getPostId() == null || !postRepository.existsById(comment.getPostId())) {
            throw new ResourceNotFoundException("Post not found");
        }
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
