package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repositories")
public class Repository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_template",nullable = false)
    private boolean isTemplate;

    @Column(name = "is_private",nullable = false)
    private boolean isPrivate;

    @Column(name = "created_at",nullable = false)
    private Timestamp createdAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id", nullable = false)
    private Assignment assignment;


    @OneToMany(mappedBy = "repository", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Commit> commits;

    @OneToMany(mappedBy = "repository", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PullRequest> pullRequests;

    @OneToMany(mappedBy = "repository", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Repository> repositories;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_repo_id")
    private Repository repository;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

































}
