package com.edu.seiryo.dao;

import java.util.List;

import com.edu.seiryo.entity.MyOrder;
/**
 * MyOrder数据处理类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao
 * @file_name MyOrderDao.java
 * @classname MyOrderDao
 * @version 1.0
 */
public interface MyOrderDao {
	public List<MyOrder> queryByUserId(int userId);
}
