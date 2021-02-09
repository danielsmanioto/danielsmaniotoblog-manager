package com.dsmanioto.blog.dto;

public class AuthorCommentDTOBuilder {
    private String author;
    private String authorEmail;
    private String authorIp;
    private int qttyCommentsThisAuthorEmail;

    public AuthorCommentDTOBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public AuthorCommentDTOBuilder setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
        return this;
    }

    public AuthorCommentDTOBuilder setAuthorIp(String authorIp) {
        this.authorIp = authorIp;
        return this;
    }

    public AuthorCommentDTOBuilder setQttyCommentsThisAuthorEmail(int qttyCommentsThisAuthorEmail) {
        this.qttyCommentsThisAuthorEmail = qttyCommentsThisAuthorEmail;
        return this;
    }

    public AuthorCommentDTO build() {
        return new AuthorCommentDTO(author, authorEmail, authorIp, qttyCommentsThisAuthorEmail);
    }
}