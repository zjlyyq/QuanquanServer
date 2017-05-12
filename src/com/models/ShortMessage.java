package com.models;

public class ShortMessage {
	private int id;
	private String date;
	private int user1;    //id较小的用户的id
	private int user2;
	private String text;
	private String imageUrl;
	private int typeImessage;    //消息类型(0:文本消息,1:图片消息，等级一次递增，也就是说当消息类型是1时，同样检测是否包含文字)
	private int direction;   //方向，1是user1->user2 -1是user2->user1
	//create table imessage (id integer auto increame,date varchar(25),user1 integer,user2,integer,text varchar(300),imageUrl varchar(50),typeMessage integer,direction,integer)
}
