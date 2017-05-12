package com.models;


/**
 * Created by jialuzhang on 2017/3/18.
 */

public class MessageImage {
    private int _id;     //主键
    private int messageId;
    private String imageUrl;
    
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
    
}
