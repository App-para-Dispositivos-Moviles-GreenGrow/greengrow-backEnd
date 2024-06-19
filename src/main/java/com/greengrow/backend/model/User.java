package com.greengrow.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name="role", length =50, nullable=false)
        private String role;
        @Column(name="name", length =50, nullable=false)
        private String name;
        @Column(name="lastName", length =50, nullable=false)
        private String lastName;
        @Column(name="email", length =50, nullable=false)
        private String email;
        @Column(name="password", length =50, nullable=false)
        private String password;
        @Column(name="country", length =50, nullable=false)
        private String country;
        @Column(name="city", length =50, nullable=false)
        private String city;


        //relaciones
        @OneToMany(mappedBy = "user")
        private List<Post> posts;

        @OneToMany(mappedBy = "user")
        private List<Course> courses;

        @OneToMany(mappedBy = "user")
        private List<Comment> comments;

        @OneToMany(mappedBy = "user")
        private List<Purchase> purchases;
}
