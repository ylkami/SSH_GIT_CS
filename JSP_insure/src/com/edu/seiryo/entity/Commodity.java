package com.edu.seiryo.entity;

/**
 * Commodity实体类
 * @author GuoYuanZhao
 * @date 2024年6月5日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.entity
 * @file_name Commodity.java
 * @classname Commodity
 * @version 1.0
 */
public class Commodity {
	/**
	 * 商品序号
	 */
	private int id;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 商品价格
	 */
	private String price;
	/**
	 * 商品介绍
	 */
	private String introduce;
	/**
	 * 商品照片
	 */
	private String img;
	/**
	 * 适用年龄
	 */
	private int ageStart;
	/**
	 * 适用年龄
	 */
	private int ageEnd;
	/**
	 * 有效时长
	 */
	private String timeLength;
	/**
	 * 适用性别
	 */
	private String applicableGender;
	/**
	 * 适用范围
	 */
	private String applicableLocation;
	/**
	 * 签署形式
	 */
	private String signingForm;
	/**
	 * 保险责任
	 */
	private String liabilityZjs;
	/**
	 * 详细信息1
	 */
	private String detail1;
	/**
	 * 详细信息2
	 */
	private String detail2;
	/**
	 * 详细信息3
	 */
	private String detail3;
	/**
	 * 商品类型
	 */
	private String type;
	/**
	 * 商品类型详情
	 */
	private String typeDetail;
	/**
	 * 是否上架
	 */
	private int on;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getAgeStart() {
		return ageStart;
	}
	public void setAgeStart(int ageStart) {
		this.ageStart = ageStart;
	}
	public int getAgeEnd() {
		return ageEnd;
	}
	public void setAgeEnd(int ageEnd) {
		this.ageEnd = ageEnd;
	}
	public String getTimeLength() {
		return timeLength;
	}
	public void setTimeLength(String timeLength) {
		this.timeLength = timeLength;
	}
	public String getApplicableGender() {
		return applicableGender;
	}
	public void setApplicableGender(String applicableGender) {
		this.applicableGender = applicableGender;
	}
	public String getApplicableLocation() {
		return applicableLocation;
	}
	public void setApplicableLocation(String applicableLocation) {
		this.applicableLocation = applicableLocation;
	}
	public String getSigningForm() {
		return signingForm;
	}
	public void setSigningForm(String signingForm) {
		this.signingForm = signingForm;
	}
	public String getLiabilityZjs() {
		return liabilityZjs;
	}
	public void setLiabilityZjs(String liabilityZjs) {
		this.liabilityZjs = liabilityZjs;
	}
	public String getDetail1() {
		return detail1;
	}
	public void setDetail1(String detail1) {
		this.detail1 = detail1;
	}
	public String getDetail2() {
		return detail2;
	}
	public void setDetail2(String detail2) {
		this.detail2 = detail2;
	}
	public String getDetail3() {
		return detail3;
	}
	public void setDetail3(String detail3) {
		this.detail3 = detail3;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeDetail() {
		return typeDetail;
	}
	public void setTypeDetail(String typeDetail) {
		this.typeDetail = typeDetail;
	}
	
	public int getOn() {
		return on;
	}
	public void setOn(int on) {
		this.on = on;
	}
	/**
	 * 
	 * 有参构造
	 * @param id
	 * @param name
	 * @param price
	 * @param introduce
	 * @param img
	 * @param ageStart
	 * @param ageEnd
	 * @param timeLength
	 * @param applicableGender
	 * @param applicableLocation
	 * @param signingForm
	 * @param liabilityZjs
	 * @param detail1
	 * @param detail2
	 * @param detail3
	 * @param type
	 * @param typeDetail
	 * @param on
	 */
	public Commodity(int id, String name, String price, String introduce, String img, int ageStart, int ageEnd,
			String timeLength, String applicableGender, String applicableLocation, String signingForm,
			String liabilityZjs, String detail1, String detail2, String detail3, String type, String typeDetail,
			int on) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.introduce = introduce;
		this.img = img;
		this.ageStart = ageStart;
		this.ageEnd = ageEnd;
		this.timeLength = timeLength;
		this.applicableGender = applicableGender;
		this.applicableLocation = applicableLocation;
		this.signingForm = signingForm;
		this.liabilityZjs = liabilityZjs;
		this.detail1 = detail1;
		this.detail2 = detail2;
		this.detail3 = detail3;
		this.type = type;
		this.typeDetail = typeDetail;
		this.on = on;
	}	
	/**
	 * 
	 * 有参构造
	 * @param id
	 * @param name
	 * @param price
	 * @param introduce
	 * @param img
	 * @param ageStart
	 * @param ageEnd
	 * @param timeLength
	 * @param applicableGender
	 * @param applicableLocation
	 * @param signingForm
	 * @param liabilityZjs
	 * @param detail1
	 * @param detail2
	 * @param detail3
	 * @param type
	 */
	public Commodity(int id, String name, String price, String introduce, String img, int ageStart, int ageEnd,
			String timeLength, String applicableGender, String applicableLocation, String signingForm,
			String liabilityZjs, String detail1, String detail2, String detail3, String type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.introduce = introduce;
		this.img = img;
		this.ageStart = ageStart;
		this.ageEnd = ageEnd;
		this.timeLength = timeLength;
		this.applicableGender = applicableGender;
		this.applicableLocation = applicableLocation;
		this.signingForm = signingForm;
		this.liabilityZjs = liabilityZjs;
		this.detail1 = detail1;
		this.detail2 = detail2;
		this.detail3 = detail3;
		this.type = type;
	}

	/**
	 * 无id构造
	 * 
	 * @param name
	 * @param price
	 * @param introduce
	 * @param img
	 * @param ageStart
	 * @param ageEnd
	 * @param timeLength
	 * @param applicableGender
	 * @param applicableLocation
	 * @param signingForm
	 * @param liabilityZjs
	 * @param detail1
	 * @param detail2
	 * @param detail3
	 * @param type
	 */
	public Commodity(String name, String price, String introduce, String img, int ageStart, int ageEnd,
			String timeLength, String applicableGender, String applicableLocation, String signingForm,
			String liabilityZjs, String detail1, String detail2, String detail3, String type) {
		super();
		this.name = name;
		this.price = price;
		this.introduce = introduce;
		this.img = img;
		this.ageStart = ageStart;
		this.ageEnd = ageEnd;
		this.timeLength = timeLength;
		this.applicableGender = applicableGender;
		this.applicableLocation = applicableLocation;
		this.signingForm = signingForm;
		this.liabilityZjs = liabilityZjs;
		this.detail1 = detail1;
		this.detail2 = detail2;
		this.detail3 = detail3;
		this.type = type;
	}

	/**
	 * 无参构造
	 */
	public Commodity() {
		super();
	}
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", price=" + price + ", introduce=" + introduce + ", img="
				+ img + ", ageStart=" + ageStart + ", ageEnd=" + ageEnd + ", timeLength=" + timeLength
				+ ", applicableGender=" + applicableGender + ", applicableLocation=" + applicableLocation
				+ ", signingForm=" + signingForm + ", liabilityZjs=" + liabilityZjs + ", detail1=" + detail1
				+ ", detail2=" + detail2 + ", detail3=" + detail3 + ", type=" + type + ", typeDetail=" + typeDetail
				+ ", on=" + on + "]";
	}

}
