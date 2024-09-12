package com.edu.seiryo.service.imp;

import java.util.List;

import com.edu.seiryo.dao.OrderInfoDao;
import com.edu.seiryo.dao.imp.OrderInfoDaoImp;
import com.edu.seiryo.entity.OrderInfo;
import com.edu.seiryo.service.OrderInfoService;
/**
 * OrderInfoService的实现类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service.imp
 * @file_name OrderInfoServiceImp.java
 * @classname OrderInfoServiceImp
 * @version 1.0
 */
public class OrderInfoServiceImp implements OrderInfoService {
	private OrderInfoDao dao = new OrderInfoDaoImp();
	public boolean saveOrderInfo(OrderInfo orderInfo) {
		return dao.insert(orderInfo);
	}
	public List<OrderInfo> queryOrderInfoById(String orderId){
		return dao.queryOrderInfoById(orderId);
	}
	public boolean updateOrderInfo(String liability1,String liability2,String liability3,String liability4,String liability5,String liability6,String liability7,String beneficiaryName,String beneficiaryCity,String beneficiaryPhone,String timeStart,String timeEnd,String timeLength,String price,String orderId){
		return dao.updateOrderInfo(liability1, liability2, liability3, liability4, liability5, liability6, liability7, beneficiaryName, beneficiaryCity, beneficiaryPhone, timeStart, timeEnd, timeLength, price, orderId);
	}
	public boolean deleteOrderInfo(String orderId){
		return dao.deleteOrderInfo(orderId);
	}
}
