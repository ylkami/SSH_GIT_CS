package com.edu.seiryo.entity;
/**
 * UserInfoʵ����
 * @author GuoYuanZhao
 * @date 2024��6��5��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.entity
 * @file_name UserInfo.java
 * @classname UserInfo
 * @version 1.0
 */
public class UserInfo {
	/**
	 * �û�����id
	 */
	private int id;
	/**
	 * �û�id
	 */
	private int userId;
	/**
	 * �û��绰����
	 */
	private String phone;
	/**
	 * ���
	 */
	private String money;
	/**
	 * ����
	 */
	private String name;
	/**
	 * ����
	 */
	private String birthday;
	/**
	 * �Ա�
	 */
	private String sex;
	/**
	 * ״̬ 1�ɵ�¼ 2���ɵ�¼
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
	 * �вι���
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
	 * ��id����
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
	 * �޲ι���
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