package com.edu.seiryo.service.imp;

import java.util.List;

import com.edu.seiryo.dao.OrderDao;
import com.edu.seiryo.dao.imp.OrderDaoImp;
import com.edu.seiryo.entity.Order;
import com.edu.seiryo.service.OrderService;
/**
 * OrderService的实现类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service.imp
 * @file_name OrderServiceImp.java
 * @classname OrderServiceImp
 * @version 1.0
 */
public class OrderServiceImp implements OrderService {
	private OrderDao dao = new OrderDaoImp();
	public boolean safeOrder(Order order) {
		return dao.insertOrder(order);
	}
	public List<Order> queryAll(){
		return dao.queryAll();
	}
	public List<Order> queryOrderById(String orderId){
		return dao.queryOrderById(orderId);
	}
	public boolean updateOrder(int userId,int commodityId,String orderId){
		return dao.updateOrder(userId, commodityId, orderId);
	}
	public boolean deleteOrder(String orderId){
		return dao.deleteOrder(orderId);
	}
}
