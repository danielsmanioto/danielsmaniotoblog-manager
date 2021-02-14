package com.dsmanioto.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "wpc5_comments")
public class Comment {

    @Id
    @Column(name = "comment_ID")
    private Long id;

    @Column(name = "comment_post_ID")
    private Long commentPostId;

    @Column(name = "comment_author")
    private String author;

    @Column(name = "comment_author_email")
    private String authorEmail;

    @Column(name = "comment_author_url")
    private String authorUrl;

    @Column(name = "comment_author_IP")
    private String authorIp;

    @Column(name = "comment_date")
    private LocalDate date;

    @Column(name = "comment_date_gmt")
    private LocalDate dateGmt;

    @Column(name = "comment_content")
    private String content;

    @Column(name = "comment_karma")
    private String karma;

    @Column(name = "comment_approved")
    private String approved;

    @Column(name = "comment_agent")
    private String agent;

    @Column(name = "comment_type")
    private String commentType;

    @Column(name = "comment_parent")
    private String commentParent;

    @Column(name = "user_id")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentPostId() {
        return commentPostId;
    }

    public void setCommentPostId(Long commentPostId) {
        this.commentPostId = commentPostId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getAuthorIp() {
        return authorIp;
    }

    public void setAuthorIp(String authorIp) {
        this.authorIp = authorIp;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDateGmt() {
        return dateGmt;
    }

    public void setDateGmt(LocalDate dateGmt) {
        this.dateGmt = dateGmt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKarma() {
        return karma;
    }

    public void setKarma(String karma) {
        this.karma = karma;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public String getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(String commentParent) {
        this.commentParent = commentParent;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentPostId=" + commentPostId +
                ", author='" + author + '\'' +
                ", authorEmail='" + authorEmail + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", authorIp='" + authorIp + '\'' +
                ", date=" + date +
                ", dateGmt=" + dateGmt +
                ", content='" + content + '\'' +
                ", karma='" + karma + '\'' +
                ", approved='" + approved + '\'' +
                ", agent='" + agent + '\'' +
                ", commentType='" + commentType + '\'' +
                ", commentParent='" + commentParent + '\'' +
                ", userId=" + userId +
                '}';
    }
}
