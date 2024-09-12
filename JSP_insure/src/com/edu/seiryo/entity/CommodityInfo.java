package com.edu.seiryo.entity;
/**
 * CommodityInfoʵ����
 * @author GuoYuanZhao
 * @date 2024��6��5��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.entity
 * @file_name CommodityInfo.java
 * @classname CommodityInfo
 * @version 1.0
 */
public class CommodityInfo {
	/**
	 * ��Ʒ����id
	 */
	private int id;
	/**
	 * ��Ʒid
	 */
	private int commodityId;
	/**
	 * ��ϸ��Ϣ1
	 */
	private String liabilityInfo1;
	/**
	 * ��ϸ��Ϣ2
	 */
	private String liabilityInfo2;
	/**
	 * ��ϸ��Ϣ3
	 */
	private String liabilityInfo3;
	/**
	 * ��ϸ��Ϣ4
	 */
	private String liabilityInfo4;
	/**
	 * ��ϸ��Ϣ5
	 */
	private String liabilityInfo5;
	/**
	 * ��ϸ��Ϣ6
	 */
	private String liabilityInfo6;
	/**
	 * ��ϸ��Ϣ7
	 */
	private String liabilityInfo7;
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
	public String getLiabilityInfo1() {
		return liabilityInfo1;
	}
	public void setLiabilityInfo1(String liabilityInfo1) {
		this.liabilityInfo1 = liabilityInfo1;
	}
	public String getLiabilityInfo2() {
		return liabilityInfo2;
	}
	public void setLiabilityInfo2(String liabilityInfo2) {
		this.liabilityInfo2 = liabilityInfo2;
	}
	public String getLiabilityInfo3() {
		return liabilityInfo3;
	}
	public void setLiabilityInfo3(String liabilityInfo3) {
		this.liabilityInfo3 = liabilityInfo3;
	}
	public String getLiabilityInfo4() {
		return liabilityInfo4;
	}
	public void setLiabilityInfo4(String liabilityInfo4) {
		this.liabilityInfo4 = liabilityInfo4;
	}
	public String getLiabilityInfo5() {
		return liabilityInfo5;
	}
	public void setLiabilityInfo5(String liabilityInfo5) {
		this.liabilityInfo5 = liabilityInfo5;
	}
	public String getLiabilityInfo6() {
		return liabilityInfo6;
	}
	public void setLiabilityInfo6(String liabilityInfo6) {
		this.liabilityInfo6 = liabilityInfo6;
	}
	public String getLiabilityInfo7() {
		return liabilityInfo7;
	}
	public void setLiabilityInfo7(String liabilityInfo7) {
		this.liabilityInfo7 = liabilityInfo7;
	}
	/**
	 * �вι���
	 * 
	 * @param id
	 * @param commodityId
	 * @param liabilityInfo1
	 * @param liabilityInfo2
	 * @param liabilityInfo3
	 * @param liabilityInfo4
	 * @param liabilityInfo5
	 * @param liabilityInfo6
	 * @param liabilityInfo7
	 */
	public CommodityInfo(int id, int commodityId, String liabilityInfo1, String liabilityInfo2, String liabilityInfo3,
			String liabilityInfo4, String liabilityInfo5, String liabilityInfo6, String liabilityInfo7) {
		super();
		this.id = id;
		this.commodityId = commodityId;
		this.liabilityInfo1 = liabilityInfo1;
		this.liabilityInfo2 = liabilityInfo2;
		this.liabilityInfo3 = liabilityInfo3;
		this.liabilityInfo4 = liabilityInfo4;
		this.liabilityInfo5 = liabilityInfo5;
		this.liabilityInfo6 = liabilityInfo6;
		this.liabilityInfo7 = liabilityInfo7;
	}

	/**
	 * ��id����
	 * 
	 * @param commodityId
	 * @param liabilityInfo1
	 * @param liabilityInfo2
	 * @param liabilityInfo3
	 * @param liabilityInfo4
	 * @param liabilityInfo5
	 * @param liabilityInfo6
	 * @param liabilityInfo7
	 */
	public CommodityInfo(int commodityId, String liabilityInfo1, String liabilityInfo2, String liabilityInfo3,
			String liabilityInfo4, String liabilityInfo5, String liabilityInfo6, String liabilityInfo7) {
		super();
		this.commodityId = commodityId;
		this.liabilityInfo1 = liabilityInfo1;
		this.liabilityInfo2 = liabilityInfo2;
		this.liabilityInfo3 = liabilityInfo3;
		this.liabilityInfo4 = liabilityInfo4;
		this.liabilityInfo5 = liabilityInfo5;
		this.liabilityInfo6 = liabilityInfo6;
		this.liabilityInfo7 = liabilityInfo7;
	}

	/**
	 * �޲ι���
	 */
	public CommodityInfo() {
		super();
	}
	@Override
	public String toString() {
		return "CommodityInfo [id=" + id + ", commodityId=" + commodityId + ", liabilityInfo1=" + liabilityInfo1
				+ ", liabilityInfo2=" + liabilityInfo2 + ", liabilityInfo3=" + liabilityInfo3 + ", liabilityInfo4="
				+ liabilityInfo4 + ", liabilityInfo5=" + liabilityInfo5 + ", liabilityInfo6=" + liabilityInfo6
				+ ", liabilityInfo7=" + liabilityInfo7 + "]";
	}
	
}
