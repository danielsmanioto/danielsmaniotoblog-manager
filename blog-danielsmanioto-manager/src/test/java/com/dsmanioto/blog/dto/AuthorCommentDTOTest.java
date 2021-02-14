package com.dsmanioto.blog.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AuthorCommentDTOTest {

    @Test
    void validateBuilderAndFilelds() {
        AuthorCommentDTO dto = new AuthorCommentDTOBuilder()
                .setAuthor("daniel")
                .setAuthorEmail("daniel.bla@aslkjdlkasd.com")
                .setQttyCommentsThisAuthorEmail(10)
                .setAuthorIp("12345.456.456").build();

        assertThat(dto).isNotNull();
        assertThat(dto.getQttyCommentsThisAuthorEmail()).isEqualTo(10);
        assertThat(dto.getAuthor()).isEqualTo("daniel");
        assertThat(dto.getAuthorEmail()).isEqualTo("daniel.bla@aslkjdlkasd.com");
        assertThat(dto.getAuthorIp()).isEqualTo("12345.456.456");
    }

}
