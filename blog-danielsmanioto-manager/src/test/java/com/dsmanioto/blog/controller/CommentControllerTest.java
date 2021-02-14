package com.dsmanioto.blog.controller;

import com.dsmanioto.blog.model.Comment;
import com.dsmanioto.blog.repository.CommentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
class CommentControllerTest {

    @InjectMocks
    private CommentController commentController;

    @Mock
    private CommentRepository repository;

    @BeforeEach
    public void setup() {
        BDDMockito.given(repository.findAll())
                .willReturn(getAllComments());
    }

    @Test
    void success_getComments() throws JsonProcessingException {


        ResponseEntity<?> comments = commentController.getComments();
        Assertions.assertThat(comments).isNotNull();
        Assertions.assertThat(comments.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(comments.getBody()).isNotNull();

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(comments.getBody().toString());
        List<Comment> commentList = mapper.readValue(comments.getBody().toString(),  new TypeReference<List<Comment>>(){});
        Assertions.assertThat(commentList).isNotNull();
        Assertions.assertThat(commentList.get(0).getAuthor()).isEqualTo("daniel smanioto");
        Assertions.assertThat(commentList.get(0).getAuthorEmail()).isEqualTo("asdkljaklsjdlasd@sajdkasdcom");

        Assertions.assertThat(commentList.get(1).getAuthor()).isEqualTo("daniela smanioto");
        Assertions.assertThat(commentList.get(1).getAuthorEmail()).isEqualTo("asdklaaklsjdlasd@sajdkasdcom");
    }

    private List<Comment> getAllComments() {
        Comment comment1 = new Comment();
        comment1.setAuthorEmail("daniel smanioto");
        comment1.setAuthorEmail("asdkljaklsjdlasd@sajdkasdcom");

        Comment comment2 = new Comment();
        comment2.setAuthorEmail("daniela smanioto");
        comment2.setAuthorEmail("asdklaaklsjdlasd@sajdkasdcom");

        return Arrays.asList(comment1, comment2);
    }

}
