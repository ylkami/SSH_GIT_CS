package com.edu.seiryo.service;

import java.util.List;

import com.edu.seiryo.entity.MyOrder;
/**
 * MyOrder业务逻辑控制类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service
 * @file_name MyOrderService.java
 * @classname MyOrderService
 * @version 1.0
 */
public interface MyOrderService {
	public List<MyOrder> getByUserIdSort(int userId);
}
