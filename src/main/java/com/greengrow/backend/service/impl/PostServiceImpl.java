package com.greengrow.backend.service.impl;

import com.greengrow.backend.exception.ResourceNotFoundException;
import com.greengrow.backend.model.Post;
import com.greengrow.backend.repository.PostRepository;
import com.greengrow.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;



    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }


    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }


    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + id));
    }


    @Override
    public void deletePostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + id));
        postRepository.delete(post);
    }

    @Override
    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + id));

        post.setTitle(postDetails.getTitle());
        post.setAuthor(postDetails.getAuthor());
        post.setImage(postDetails.getImage());
        post.setDescription(postDetails.getDescription());
        post.setViews(postDetails.getViews());
        post.setLikes(postDetails.getLikes());
        post.setCategory(postDetails.getCategory());
        post.setDate(postDetails.getDate());
        post.setUserId(postDetails.getUserId());

        return postRepository.save(post);
    }
}
