package com.edu.seiryo.entity;
/**
 * Userʵ����
 * @author GuoYuanZhao
 * @date 2024��6��5��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.entity
 * @file_name User.java
 * @classname User
 * @version 1.0
 */
public class User {
	/**
	 * �û����
	 */
	private int id;
	/**
	 * ����
	 */
	private String email;
	/**
	 * ����
	 */
	private String password;
	/**
	 * �Ƿ���Ե�¼
	 */
	private int status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * �вι���
	 * @param id
	 * @param email
	 * @param password
	 * @param status
	 */
	public User(int id, String email, String password, int status) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	/**
	 * �вι���
	 * 
	 * @param id
	 * @param email
	 * @param password
	 */
	public User(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	/**
	 * ��id����
	 * 
	 * @param email
	 * @param password
	 */
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	/**
	 * �޲ι���
	 */
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", status=" + status + "]";
	}

}

