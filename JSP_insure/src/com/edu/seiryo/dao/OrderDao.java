package com.edu.seiryo.dao;

import java.util.List;

import com.edu.seiryo.entity.Order;
/**
 * Order���ݴ�����
 * @author GuoYuanZhao
 * @date 2024��6��6��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao
 * @file_name OrderDao.java
 * @classname OrderDao
 * @version 1.0
 */
public interface OrderDao {
	public boolean insertOrder(Order order);
	public List<Order> queryAll();
	public List<Order> queryOrderById(String orderId);
	public boolean updateOrder(int userId,int commodityId,String orderId);
	public boolean deleteOrder(String orderId);
}
