package com.greengrow.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.spi.LocaleServiceProvider;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", length = 200, nullable = false)
    private Long userId;
    @Column(name = "post_id", nullable = false)
    private Long postId;
}
