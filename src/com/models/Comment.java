package com.models;
import java.util.ArrayList;

/**
 * Created by jialuzhang on 2017/3/15.
 */
public class Comment {
    private int commentId;
    private int userId;
    private int messageId;
    private int favourTimes;
    private long date;
    private String text;

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getCommentId() {
        return commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getFavourTimes() {
        return favourTimes;
    }

    public void setFavourTimes(int favourTimes) {
        this.favourTimes = favourTimes;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
