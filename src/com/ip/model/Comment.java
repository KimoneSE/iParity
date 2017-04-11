package com.ip.model;

import java.util.Date;

/**
 * Created by windkl on 2017/4/11.
 */
public class Comment {
    User author;
    String content;
    Date datetime;

    public Comment() {
    }

    public Comment(User author, String content, Date datetime) {
        this.author = author;
        this.content = content;
        this.datetime = datetime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
