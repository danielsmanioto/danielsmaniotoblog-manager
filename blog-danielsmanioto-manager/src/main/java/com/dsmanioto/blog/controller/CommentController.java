package com.dsmanioto.blog.controller;

import com.dsmanioto.blog.repository.CommentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.time.LocalDate;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentRepository repository;

    public CommentController(CommentRepository repository, EntityManager entityManager) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<?> getComments() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/actives")
    public ResponseEntity<?> getCommentsActives() {
        return ResponseEntity.ok(repository.findByApproved("1"));
    }

    @GetMapping("/inactives")
    public ResponseEntity<?> getCommentsInactives() {
        return ResponseEntity.ok(repository.findInactives());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(repository.findById(id));
    }

    @GetMapping("/last")
    public ResponseEntity<?> getLastsComments() {
        return ResponseEntity.ok(repository.findAll(Sort.by(Sort.Direction.DESC, "id")));
    }

    @GetMapping("/today")
    public ResponseEntity<?> getCommentsToday() {
        return ResponseEntity.ok(repository.findByDate(LocalDate.now()));
    }

}
