package com.edu.seiryo.entity;
/**
 * Typeʵ����
 * @author GuoYuanZhao
 * @date 2024��6��13��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.entity
 * @file_name Type.java
 * @classname Type
 * @version 1.0
 */
public class Type {
	/**
	 * �������
	 */
	private int typeId;
	/**
	 * ��������
	 */
	private String type;
	/**
	 * �Ƿ��ϼ�
	 */
	private int typeOn;
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getTypeOn() {
		return typeOn;
	}
	public void setTypeOn(int typeOn) {
		this.typeOn = typeOn;
	}
	public Type(int typeId, String type, int typeOn) {
		super();
		this.typeId = typeId;
		this.type = type;
		this.typeOn = typeOn;
	}
	public Type(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}
	public Type() {
		super();
	}
	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", type=" + type + ", typeOn=" + typeOn + "]";
	}
	
}
