package com.edu.seiryo.entity;
/**
 * UserInfo实体类
 * @author GuoYuanZhao
 * @date 2024年6月5日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.entity
 * @file_name UserInfo.java
 * @classname UserInfo
 * @version 1.0
 */
public class UserInfo {
	/**
	 * 用户详情id
	 */
	private int id;
	/**
	 * 用户id
	 */
	private int userId;
	/**
	 * 用户电话号码
	 */
	private String phone;
	/**
	 * 余额
	 */
	private String money;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 生日
	 */
	private String birthday;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 状态 1可登录 2不可登录
	 */
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * 有参构造
	 * 
	 * @param id
	 * @param userId
	 * @param phone
	 * @param money
	 * @param name
	 * @param birthday
	 * @param sex
	 * @param status
	 */
	public UserInfo(int id, int userId, String phone, String money, String name, String birthday, String sex,
			int status) {
		super();
		this.id = id;
		this.userId = userId;
		this.phone = phone;
		this.money = money;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.status = status;
	}

	/**
	 * 无id构造
	 * 
	 * @param userId
	 * @param phone
	 * @param money
	 * @param name
	 * @param birthday
	 * @param sex
	 * @param status
	 */
	public UserInfo(int userId, String phone, String money, String name, String birthday, String sex, int status) {
		super();
		this.userId = userId;
		this.phone = phone;
		this.money = money;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.status = status;
	}

	/**
	 * 无参构造
	 */
	public UserInfo() {
		super();
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userId=" + userId + ", phone=" + phone + ", money=" + money + ", name=" + name
				+ ", birthday=" + birthday + ", sex=" + sex + ", status=" + status + "]";
	}

}