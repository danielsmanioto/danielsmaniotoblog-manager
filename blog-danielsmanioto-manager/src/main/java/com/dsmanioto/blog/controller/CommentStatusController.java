package com.dsmanioto.blog.controller;

import com.dsmanioto.blog.model.CommentStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comment-status")
public class CommentStatusController {

    private final EntityManager entityManager;

    public CommentStatusController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        StringBuilder sql = new StringBuilder("select comment_approved status from wpc5_comments group by comment_approved ");
        Query query = entityManager.createNativeQuery(sql.toString());

        List<CommentStatus> collect = (List<CommentStatus>) query.getResultList().stream()
                .map(r -> new CommentStatus((String) r)).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }

}
