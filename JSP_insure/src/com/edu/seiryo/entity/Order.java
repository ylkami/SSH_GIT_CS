package com.edu.seiryo.entity;
/**
 * Orderʵ����
 * @author GuoYuanZhao
 * @date 2024��6��5��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.entity
 * @file_name Order.java
 * @classname Order
 * @version 1.0
 */
public class Order {
	/**
	 * ����id
	 */
	private String id;
	/**
	 * �û�id
	 */
	private int userId;
	/**
	 * ��Ʒid
	 */
	private int commodityId;
	public Order() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public Order(String id, int userId, int commodityId) {
		super();
		this.id = id;
		this.userId = userId;
		this.commodityId = commodityId;
	}
	/**
	 * ��id����
	 * 
	 * @param userId
	 * @param commodityId
	 */
	public Order(int userId, int commodityId) {
		super();
		this.userId = userId;
		this.commodityId = commodityId;
	}
	/**
	 * �޲ι���
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", commodityId=" + commodityId + "]";
	}
}
