package com.edu.seiryo.entity;
/**
 * Comment实体类
 * @author GuoYuanZhao
 * @date 2024年6月13日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.entity
 * @file_name Comment.java
 * @classname Comment
 * @version 1.0
 */
public class Comment {
	/**
	 * 评论序号
	 */
	private int id;
	/**
	 * 商品序号
	 */
	private int commodityId;
	/**
	 * 用户邮箱
	 */
	private String email;
	/**
	 * 评论内容
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
	 * 有参构造
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
	 * 无参构造
	 */
	public Comment() {
		super();
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", commodityId=" + commodityId + ", email=" + email + ", message=" + message + "]";
	}
	
	
	
}
