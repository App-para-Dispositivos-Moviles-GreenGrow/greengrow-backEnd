package com.greengrow.backend.controller;


import com.greengrow.backend.model.Post;
import com.greengrow.backend.repository.PostRepository;
import com.greengrow.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Controller class for handling RESTful requests for posts.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        validatePost(post);
        //existsByNameAndPrice(post);
        return new ResponseEntity<Post>(postService.createPost(post), HttpStatus.CREATED);
    }


    private void validatePost(Post post){
        if(post.getTitle() == null || post.getTitle().isEmpty()){
            throw new RuntimeException("El título del post es obligatorio");
        }

        if(post.getTitle().length() > 50){
            throw new RuntimeException("El título del post no puede tener más de 50 caracteres");
        }

        if(post.getAuthor() == null || post.getAuthor().isEmpty()){
            throw new RuntimeException("El autor del post es obligatorio");
        }

        if(post.getAuthor().length() > 50){
            throw new RuntimeException("El autor del post no puede tener más de 50 caracteres");
        }

        if(post.getDate() ==null) {
            throw new RuntimeException("La fecha del post es obligatoria");
        }

        if(post.getImage() ==null|| post.getImage().isEmpty()){
            throw new RuntimeException("La imagen del post es obligatoria");
        }

        if(post.getImage().length() > 200){
            throw new RuntimeException("La imagen del post no puede tener más de 200 caracteres");
        }

        if(post.getDescription() ==null|| post.getDescription().isEmpty()){
            throw new RuntimeException("La descripción del post es obligatoria");
        }

        if(post.getDescription().length() > 550) {
            throw new RuntimeException("La descripción del post no puede tener más de 550 caracteres");
        }

        if(post.getViews() < 0 || post.getViews() > 999999) {
            throw new RuntimeException("El número de vistas debe estar entre 0 y 999999");
        }

        if(post.getLikes() < 0 || post.getLikes() > 999999) {
            throw new RuntimeException("El número de likes debe estar entre 0 y 999999");
        }

    }


    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(postService.getPostsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        return new ResponseEntity<>(postService.updatePost(id, post), HttpStatus.OK);
    }

}