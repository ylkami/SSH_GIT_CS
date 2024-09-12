package com.edu.seiryo.service;

import java.util.List;

import com.edu.seiryo.entity.OrderInfo;
/**
 * OrderInfo业务逻辑控制类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service
 * @file_name OrderInfoService.java
 * @classname OrderInfoService
 * @version 1.0
 */
public interface OrderInfoService {
	public boolean saveOrderInfo(OrderInfo orderInfo);
	public List<OrderInfo> queryOrderInfoById(String orderId);
	public boolean updateOrderInfo(String liability1,String liability2,String liability3,String liability4,String liability5,String liability6,String liability7,String beneficiaryName,String beneficiaryCity,String beneficiaryPhone,String timeStart,String timeEnd,String timeLength,String price,String orderId);
	public boolean deleteOrderInfo(String orderId);
}
