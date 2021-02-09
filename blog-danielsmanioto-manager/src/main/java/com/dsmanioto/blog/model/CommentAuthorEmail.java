package com.dsmanioto.blog.model;

import java.util.Objects;

public class CommentAuthorEmail {

    private String email;
    private Long qtty;

    public CommentAuthorEmail() {

    }

    public CommentAuthorEmail(String email, Long qtty) {
        this.email = email;
        this.qtty = qtty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getQtty() {
        return qtty;
    }

    public void setQtty(Long qtty) {
        this.qtty = qtty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentAuthorEmail that = (CommentAuthorEmail) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "CommentAuthorEmail{" +
                "email='" + email + '\'' +
                ", qtty=" + qtty +
                '}';
    }
}
