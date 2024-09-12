package com.edu.seiryo.service;

import java.util.List;

import com.edu.seiryo.entity.Type;
/**
 * Typeҵ���߼�������
 * @author GuoYuanZhao
 * @date 2024��6��13��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service
 * @file_name TypeService.java
 * @classname TypeService
 * @version 1.0
 */
public interface TypeService {
	public List<Type> queryAll();
	public List<Type> queryTypeById(int typeId);
	public boolean addType(String type,int typeOn);
	public boolean updateType(String type,int typeOn,int typeId);
	public boolean deleteType(int typeId);
	public List<Type> queryAllOn();
}
