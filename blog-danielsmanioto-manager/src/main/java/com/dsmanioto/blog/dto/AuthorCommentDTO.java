package com.dsmanioto.blog.dto;

public class AuthorCommentDTO {

    private String author;
    private String authorEmail;
    private String authorIp;
    private int qttyCommentsThisAuthorEmail;

    public AuthorCommentDTO(String author, String authorEmail, String authorIp, int qttyCommentsThisAuthorEmail) {
        this.author = author;
        this.authorEmail = authorEmail;
        this.authorIp = authorIp;
        this.qttyCommentsThisAuthorEmail = qttyCommentsThisAuthorEmail;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getAuthorIp() {
        return authorIp;
    }

    public int getQttyCommentsThisAuthorEmail() {
        return qttyCommentsThisAuthorEmail;
    }
}
