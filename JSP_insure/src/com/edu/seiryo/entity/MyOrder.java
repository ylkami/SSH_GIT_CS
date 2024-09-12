package com.edu.seiryo.entity;
/**
 * MyOrder��ʵ����
 * @author GuoYuanZhao
 * @date 2024��6��5��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.entity
 * @file_name MyOrder.java
 * @classname MyOrder
 * @version 1.0
 */
public class MyOrder {
	/**
	 * �������
	 */
	private String orderId;
	/**
	 * ��Ʒ��
	 */
	private String commodityName;
	/**
	 * ��Ʒ�۸�
	 */
	private String commodityPrice;
	/**
	 * ���չ�����
	 */
	private String userName;
	/**
	 * ����������
	 */
	private String beneficiaryName;
	/**
	 * ������ʼʱ��
	 */
	private String timeStart;
	/**
	 * ��������ʱ��
	 */
	private String timeEnd;
	/**
	 * ����ʱЧ
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
	 * �вι���
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
	 * �޲ι���
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
