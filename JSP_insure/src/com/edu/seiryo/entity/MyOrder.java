package com.edu.seiryo.entity;
/**
 * MyOrder的实体类
 * @author GuoYuanZhao
 * @date 2024年6月5日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.entity
 * @file_name MyOrder.java
 * @classname MyOrder
 * @version 1.0
 */
public class MyOrder {
	/**
	 * 订单序号
	 */
	private String orderId;
	/**
	 * 商品名
	 */
	private String commodityName;
	/**
	 * 商品价格
	 */
	private String commodityPrice;
	/**
	 * 保险购买者
	 */
	private String userName;
	/**
	 * 受益人姓名
	 */
	private String beneficiaryName;
	/**
	 * 保单开始时间
	 */
	private String timeStart;
	/**
	 * 保单结束时间
	 */
	private String timeEnd;
	/**
	 * 保单时效
	 */
	private String timeLength;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getCommodityPrice() {
		return commodityPrice;
	}
	public void setCommodityPrice(String commodityPrice) {
		this.commodityPrice = commodityPrice;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getTimeLength() {
		return timeLength;
	}
	public void setTimeLength(String timeLength) {
		this.timeLength = timeLength;
	}

	/**
	 * 有参构造
	 * 
	 * @param orderId
	 * @param commodityName
	 * @param commodityPrice
	 * @param userName
	 * @param beneficiaryName
	 * @param timeStart
	 * @param timeEnd
	 * @param timeLength
	 */
	public MyOrder(String orderId, String commodityName, String commodityPrice, String userName, String beneficiaryName,
			String timeStart, String timeEnd, String timeLength) {
		super();
		this.orderId = orderId;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.userName = userName;
		this.beneficiaryName = beneficiaryName;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.timeLength = timeLength;
	}

	/**
	 * 无参构造
	 */
	public MyOrder() {
		super();
	}
	@Override
	public String toString() {
		return "MyOrder [orderId=" + orderId + ", commodityName=" + commodityName + ", commodityPrice=" + commodityPrice
				+ ", userName=" + userName + ", beneficiaryName=" + beneficiaryName + ", timeStart=" + timeStart
				+ ", timeEnd=" + timeEnd + ", timeLength=" + timeLength + "]";
	}
}
