package com.edu.seiryo.service;

import java.util.List;

import com.edu.seiryo.entity.Order;
/**
 * Orderҵ���߼�������
 * @author GuoYuanZhao
 * @date 2024��6��6��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service
 * @file_name OrderService.java
 * @classname OrderService
 * @version 1.0
 */
public interface OrderService {
	public boolean safeOrder(Order order);
	public List<Order> queryAll();
	public List<Order> queryOrderById(String orderId);
	public boolean updateOrder(int userId,int commodityId,String orderId);
	public boolean deleteOrder(String orderId);
}
