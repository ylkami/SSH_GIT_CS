package com.edu.seiryo.dao;

import java.util.List;

import com.edu.seiryo.entity.Type;
/**
 * Type数据处理类
 * @author GuoYuanZhao
 * @date 2024年6月13日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao
 * @file_name TypeDao.java
 * @classname TypeDao
 * @version 1.0
 */
public interface TypeDao {
	public List<Type> queryAll();
	public List<Type> queryTypeById(int typeId);
	public boolean addType(String type,int typeOn);
	public boolean updateType(String type,int typeOn,int typeId);
	public boolean deleteType(int typeId);
	public List<Type> queryAllOn();
}
