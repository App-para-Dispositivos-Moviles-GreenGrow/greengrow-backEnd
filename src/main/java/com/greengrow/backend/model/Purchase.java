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
    @ManyToOne
    @JoinColumn(name = "Usuario_id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "Course_id", nullable = false)
    private Course courseId;

    @Column(name = "status", length = 10, nullable = false)
    private String status;
}
