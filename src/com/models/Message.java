package com.models;



/**
 * Created by jialuzhang on 2017/3/15.
 */

public class Message {
    private int messageId;  	//�，主�?
    private int userId;  	//外键
    private String text;
    private String publish_time;
    private double x;
    private double y;
    private int transmitTimes;  //转发次数
    private int commentTimes;  //评论次数
    private int favourTimes;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public int getTransmitTimes() {
		return transmitTimes;
	}
	public void setTransmitTimes(int transmitTimes) {
		this.transmitTimes = transmitTimes;
	}
	public int getCommentTimes() {
		return commentTimes;
	}
	public void setCommentTimes(int commentTimes) {
		this.commentTimes = commentTimes;
	}
	public int getFavourTimes() {
		return favourTimes;
	}
	public void setFavourTimes(int favourTimes) {
		this.favourTimes = favourTimes;
	}
	
}
