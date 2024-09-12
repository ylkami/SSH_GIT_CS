package com.edu.seiryo.entity;
/**
 * Commentʵ����
 * @author GuoYuanZhao
 * @date 2024��6��13��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.entity
 * @file_name Comment.java
 * @classname Comment
 * @version 1.0
 */
public class Comment {
	/**
	 * �������
	 */
	private int id;
	/**
	 * ��Ʒ���
	 */
	private int commodityId;
	/**
	 * �û�����
	 */
	private String email;
	/**
	 * ��������
	 */
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 
	 * �вι���
	 * @param id
	 * @param commodityId
	 * @param email
	 * @param message
	 */
	public Comment(int id, int commodityId, String email, String message) {
		super();
		this.id = id;
		this.commodityId = commodityId;
		this.email = email;
		this.message = message;
	}
	/**
	 * 
	 * �޲ι���
	 */
	public Comment() {
		super();
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", commodityId=" + commodityId + ", email=" + email + ", message=" + message + "]";
	}
	
	
	
}
