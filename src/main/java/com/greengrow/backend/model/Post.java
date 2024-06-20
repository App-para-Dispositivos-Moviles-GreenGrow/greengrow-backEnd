package com.greengrow.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Represents a post entity in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    /**
     * The unique identifier for the post.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The title of the post.
     */
    @Column(name="title", length =50, nullable=false)
    private String title;

    /**
     * The author of the post.
     */
    @Column(name = "author", length =50, nullable=false)
    private String author;

    @Column(name = "image", length =200, nullable=false)
    private String image;
    @Column(name = "description", length =550, nullable=false)
    private String description;
    @Column(name = "views", length =6, nullable=false)
    private int views;

    @Column(name = "likes", length =6, nullable=false)
    private int likes;

    @Column(name = "category", length =50, nullable=false)
    private String category;
    @Column(name = "date", length =10, nullable=false)
    private String date;

    @Column(name = "userId", length =10, nullable=false)
    private Long userId;





}