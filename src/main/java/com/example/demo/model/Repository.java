package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Setter
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














}
