package com.dsmanioto.blog.controller;

import com.dsmanioto.blog.dto.AuthorCommentDTO;
import com.dsmanioto.blog.dto.AuthorCommentDTOBuilder;
import com.dsmanioto.blog.model.Comment;
import com.dsmanioto.blog.model.CommentAuthorEmail;
import com.dsmanioto.blog.repository.CommentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comments-reports")
public class CommentReportController {

    private final CommentRepository repository;

    public CommentReportController(CommentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/author-send-comment-today")
    public ResponseEntity<?> getCommentTodayOfAuthor() {
        var comments = (List<Comment>) repository.findAll();
        var commentsAuthorQttyyEmail = repository.findQttyEmailAuthor();

        var authorsComments = comments.stream().map(comment -> {
            return new AuthorCommentDTOBuilder()
                    .setAuthor(comment.getAuthor())
                    .setAuthorEmail(comment.getAuthorEmail())
                    .setAuthorIp(comment.getAuthorIp())
                    .setQttyCommentsThisAuthorEmail(getQttyAuthorEmail(commentsAuthorQttyyEmail, comment.getAuthorEmail()))
                    .build();
        }).sorted(Comparator.comparingInt(AuthorCommentDTO::getQttyCommentsThisAuthorEmail))
                .collect(Collectors.toList());

        return ResponseEntity.ok(authorsComments);
    }

    private int getQttyAuthorEmail(List<CommentAuthorEmail> commentsAuthorQttyyEmail, String authorEmail) {
        List<CommentAuthorEmail> commentAuthorEmails = commentsAuthorQttyyEmail
                .stream()
                .filter(c -> c.getEmail().equals(authorEmail))
                .collect(Collectors.toList());
        return Integer.valueOf(String.valueOf(commentAuthorEmails.get(0).getQtty()));
    }

}
