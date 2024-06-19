package com.greengrow.backend.service;

import com.greengrow.backend.model.Post;

import java.util.List;

/**
 * Service interface for managing Post entities in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
public interface PostService {

    /**
     * Creates a new post.
     *
     * @param post The post to be created.
     * @return The created post.
     */
    Post createPost(Post post);

    List<Post> getAllPosts();

    List<Post> getPostsByUserId(Long userId);

    Post getPostById(Long id);

    void deletePostById(Long id);

    Post updatePost(Long id, Post postDetails);
}
