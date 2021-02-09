package com.dsmanioto.blog.repository;

import com.dsmanioto.blog.model.Comment;
import com.dsmanioto.blog.model.CommentAuthorEmail;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface CommentRepository  extends CrudRepository<Comment, Long> {

    List<Comment> findByApproved(String approved);

    List<Comment> findAll(Sort sort);

    @Query(value = "SELECT e.* FROM wpc5_comments e WHERE DATE(comment_date) = :date", nativeQuery = true)
    List<Comment> findByDate(LocalDate date);

    @Query(value = "SELECT e.* FROM wpc5_comments e WHERE comment_approved != 1", nativeQuery = true)
    List<Comment> findInactives();

    @Query(value = "select " +
            " new com.dsmanioto.blog.model.CommentAuthorEmail(authorEmail, count(c)) " +
            " from Comment c group by c.authorEmail ")
    List<CommentAuthorEmail> findQttyEmailAuthor();

}
