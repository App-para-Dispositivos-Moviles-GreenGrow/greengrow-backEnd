package com.greengrow.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //relaciones
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "course_id", nullable = false)
    private Long courseId;
    @Column(name = "status", length = 10, nullable = false)
    private String status;
}
