package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String fullName;

    @Column(name = "full_name", nullable = false)
    private String role;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Classroom> ownedRepositories;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PullRequest> taughtRepositories;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PullRequest> authoredPullRequests;

    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PullRequest> reviewedPullRequests;

    @OneToMany(mappedBy = "commits", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Commit> commits;
}
