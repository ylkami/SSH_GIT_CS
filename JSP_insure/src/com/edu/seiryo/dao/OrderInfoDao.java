package com.edu.seiryo.dao;

import java.util.List;

import com.edu.seiryo.entity.OrderInfo;
/**
 * OrderInfo���ݴ�����
 * @author GuoYuanZhao
 * @date 2024��6��6��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao
 * @file_name OrderInfoDao.java
 * @classname OrderInfoDao
 * @version 1.0
 */
public interface OrderInfoDao {
	public boolean insert(OrderInfo orderInfo);
	public List<OrderInfo> queryOrderInfoById(String orderId);
	public boolean updateOrderInfo(String liability1,String liability2,String liability3,String liability4,String liability5,String liability6,String liability7,String beneficiaryName,String beneficiaryCity,String beneficiaryPhone,String timeStart,String timeEnd,String timeLength,String price,String orderId);
	public boolean deleteOrderInfo(String orderId);
}
