package com.example.demo.controller;

import com.example.demo.model.PullRequest;
import com.example.demo.repository.IPullRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pull-requests")
@RequiredArgsConstructor
public class PullRequestController {

    private final IPullRequestRepository pullRequestRepository;

    @GetMapping
    public List<PullRequest> findAllPullRequests() {
        return pullRequestRepository.findAll();
    }


    @GetMapping("/p1")
    public List<PullRequest> p1() {
        return pullRequestRepository.findDistinctByRepository_Assignment_Classroom_NameAndStatus_OrderByCreatedAtDesc("Computacion en Internet II - Grupo 1","OPEN");
    }

    @GetMapping("/p3")
    public List<PullRequest> p3() {
        return pullRequestRepository.findDistinctByReviewer_Role_AndReviewer_UsernameAndRepository_Assignment_Classroom_Semester("TA", "cjimenez" , "2026-02");
    }

}
