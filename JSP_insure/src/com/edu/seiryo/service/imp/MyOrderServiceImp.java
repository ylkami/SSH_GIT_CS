package com.edu.seiryo.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.edu.seiryo.dao.MyOrderDao;
import com.edu.seiryo.dao.UserInfoDao;
import com.edu.seiryo.dao.imp.MyOrderDaoImp;
import com.edu.seiryo.dao.imp.UserInfoDaoImp;
import com.edu.seiryo.entity.MyOrder;
import com.edu.seiryo.service.MyOrderService;
/**
 * MyorderService的实现类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service.imp
 * @file_name MyOrderServiceImp.java
 * @classname MyOrderServiceImp
 * @version 1.0
 */
public class MyOrderServiceImp implements MyOrderService {
	private MyOrderDao dao = new MyOrderDaoImp();
	private UserInfoDao userInfoDao = new UserInfoDaoImp();
	/**
	 * 根据id获取订单
	 * @param userId
	 * @return
	 */
	public List<MyOrder> getByUserIdSort(int userId) {
		List<MyOrder> list = dao.queryByUserId(userId);
		List<MyOrder> resultList = new ArrayList<MyOrder>();
		for (MyOrder myOrder : list) {
			if(myOrder.getBeneficiaryName().equals(myOrder.getUserName())) {
				resultList.add(0, myOrder);
			} else {
				resultList.add(myOrder);
			}
		}
		return resultList;
	}
}
