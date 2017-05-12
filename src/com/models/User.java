package com.models;


/**
 * Created by jialuzhang on 2017/3/17.
 */

/**
 * @author jialuzhang
 *
 */
public class User {
    private int userId;           //用户id自增，生成用户信息时返回id，方便使�?
    private  String userName;
    private String password;
    //private  Bitmap userPhoto;
    private String userPhoto;
    private String email_adress;
    private String sex;        //性别�?1代表男，0代表未知�?-1代表�?
    private int age;
    private int userPhone;
    private long register_time;
    private int privilege;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail_adress() {
		return email_adress;
	}
	public void setEmail_adress(String email_adress) {
		this.email_adress = email_adress;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}
	public long getRegister_time() {
		return register_time;
	}
	public void setRegister_time(long register_time) {
		this.register_time = register_time;
	}
	public int getPrivilege() {
		return privilege;
	}
	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
    
}
