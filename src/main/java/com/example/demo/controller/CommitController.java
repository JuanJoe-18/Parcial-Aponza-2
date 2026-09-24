package com.example.demo.controller;

import com.example.demo.model.Commit;
import com.example.demo.repository.ICommitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commits")
@RequiredArgsConstructor
public class CommitController {

    private final ICommitRepository commitRepository;

    @GetMapping
    public List<Commit> findAllCommits() {
        return commitRepository.findAll();
    }

    @GetMapping("/p4")
    public List<Commit> p4() {
        return commitRepository.findByRepository_Repository_NameAndMessageContainingIgnoreCaseAndLinesAddedGreaterThan(
                "template-jpa-exam", "fix", 50);
    }
}
