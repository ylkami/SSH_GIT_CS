package com.edu.seiryo.entity;
/**
 * OrderInfoʵ����
 * @author GuoYuanZhao
 * @date 2024��6��5��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.entity
 * @file_name OrderInfo.java
 * @classname OrderInfo
 * @version 1.0
 */
public class OrderInfo {
	/**
	 * �����������
	 */
	private int id;
	/**
	 * �������
	 */
	private String orderId;
	/**
	 * ��Ʒ����1
	 */
	private String liability1;
	/**
	 * ��Ʒ����2
	 */
	private String liability2;
	/**
	 * ��Ʒ����3
	 */
	private String liability3;
	/**
	 * ��Ʒ����4
	 */
	private String liability4;
	/**
	 * ��Ʒ����5
	 */
	private String liability5;
	/**
	 * ��Ʒ����6
	 */
	private String liability6;
	/**
	 * ��Ʒ����7
	 */
	private String liability7;
	/**
	 * ����������
	 */
	private String beneficiaryName;
	/**
	 * �����˵�ַ
	 */
	private String beneficiaryCity;
	/**
	 * �������ֻ���
	 */
	private String beneficiaryPhone;
	/**
	 * ���Ͽ�ʼʱ��
	 */
	private String timeStart;
	/**
	 * ���Ͻ���ʱ��
	 */
	private String timeEnd;
	/**
	 * ����ʱ��
	 */
	private String timeLength;
	/**
	 * �����ܽ��
	 */
	private String price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getLiability1() {
		return liability1;
	}
	public void setLiability1(String liability1) {
		this.liability1 = liability1;
	}
	public String getLiability2() {
		return liability2;
	}
	public void setLiability2(String liability2) {
		this.liability2 = liability2;
	}
	public String getLiability3() {
		return liability3;
	}
	public void setLiability3(String liability3) {
		this.liability3 = liability3;
	}
	public String getLiability4() {
		return liability4;
	}
	public void setLiability4(String liability4) {
		this.liability4 = liability4;
	}
	public String getLiability5() {
		return liability5;
	}
	public void setLiability5(String liability5) {
		this.liability5 = liability5;
	}
	public String getLiability6() {
		return liability6;
	}
	public void setLiability6(String liability6) {
		this.liability6 = liability6;
	}
	public String getLiability7() {
		return liability7;
	}
	public void setLiability7(String liability7) {
		this.liability7 = liability7;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getBeneficiaryCity() {
		return beneficiaryCity;
	}
	public void setBeneficiaryCity(String beneficiaryCity) {
		this.beneficiaryCity = beneficiaryCity;
	}
	public String getBeneficiaryPhone() {
		return beneficiaryPhone;
	}
	public void setBeneficiaryPhone(String beneficiaryPhone) {
		this.beneficiaryPhone = beneficiaryPhone;
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
	public void setTimeLengthl(String timeLength) {
		this.timeLength = timeLength;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * �вι���
	 * 
	 * @param id
	 * @param orderId
	 * @param liability1
	 * @param liability2
	 * @param liability3
	 * @param liability4
	 * @param liability5
	 * @param liability6
	 * @param liability7
	 * @param beneficiaryName
	 * @param beneficiaryCity
	 * @param beneficiaryPhone
	 * @param timeStart
	 * @param timeEnd
	 * @param timeLengthl
	 * @param price
	 */
	public OrderInfo(int id, String orderId, String liability1, String liability2, String liability3, String liability4,
			String liability5, String liability6, String liability7, String beneficiaryName, String beneficiaryCity,
			String beneficiaryPhone, String timeStart, String timeEnd, String timeLength, String price) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.liability1 = liability1;
		this.liability2 = liability2;
		this.liability3 = liability3;
		this.liability4 = liability4;
		this.liability5 = liability5;
		this.liability6 = liability6;
		this.liability7 = liability7;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryCity = beneficiaryCity;
		this.beneficiaryPhone = beneficiaryPhone;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.timeLength = timeLength;
		this.price = price;
	}

	/**
	 * ��id����
	 * 
	 * @param orderId
	 * @param liability1
	 * @param liability2
	 * @param liability3
	 * @param liability4
	 * @param liability5
	 * @param liability6
	 * @param liability7
	 * @param beneficiaryName
	 * @param beneficiaryCity
	 * @param beneficiaryPhone
	 * @param timeStart
	 * @param timeEnd
	 * @param timeLengthl
	 * @param price
	 */
	public OrderInfo(String orderId, String liability1, String liability2, String liability3, String liability4,
			String liability5, String liability6, String liability7, String beneficiaryName, String beneficiaryCity,
			String beneficiaryPhone, String timeStart, String timeEnd, String timeLength, String price) {
		super();
		this.orderId = orderId;
		this.liability1 = liability1;
		this.liability2 = liability2;
		this.liability3 = liability3;
		this.liability4 = liability4;
		this.liability5 = liability5;
		this.liability6 = liability6;
		this.liability7 = liability7;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryCity = beneficiaryCity;
		this.beneficiaryPhone = beneficiaryPhone;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.timeLength = timeLength;
		this.price = price;
	}

	/**
	 * �޲ι���
	 */
	public OrderInfo() {
		super();
	}

	@Override
	public String toString() {
		return "OrderInfo [id=" + id + ", orderId=" + orderId + ", liability1=" + liability1 + ", liability2="
				+ liability2 + ", liability3=" + liability3 + ", liability4=" + liability4 + ", liability5="
				+ liability5 + ", liability6=" + liability6 + ", liability7=" + liability7 + ", beneficiaryName="
				+ beneficiaryName + ", beneficiaryCity=" + beneficiaryCity + ", beneficiaryPhone=" + beneficiaryPhone
				+ ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", timeLength=" + timeLength + ", price="
				+ price + "]";
	}

}