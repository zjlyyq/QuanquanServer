package com.models;

/**
 * Created by jialuzhang on 2017/3/18.
 */

public class RelationShip {
    private int relationId;   //关系id，主键自�?
    private int user1Id;
    private int user2Id;
    private boolean isTrue;
    private long beginTime;
	public int getRelationId() {
		return relationId;
	}
	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}
	public int getUser1Id() {
		return user1Id;
	}
	public void setUser1Id(int user1Id) {
		this.user1Id = user1Id;
	}
	public int getUser2Id() {
		return user2Id;
	}
	public void setUser2Id(int user2Id) {
		this.user2Id = user2Id;
	}
	public boolean isTrue() {
		return isTrue;
	}
	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}
	public long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}
    
}
