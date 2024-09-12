package com.edu.seiryo.dao.imp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.seiryo.dao.OrderInfoDao;
import com.edu.seiryo.entity.OrderInfo;
import com.edu.seiryo.entity.Type;
import com.edu.seiryo.util.JDBCUTILE;
/**
 * OrderInfoDao的实现类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao.imp
 * @file_name OrderInfoDaoImp.java
 * @classname OrderInfoDaoImp
 * @version 1.0
 */
public class OrderInfoDaoImp implements OrderInfoDao {
	/**
	 * 插入订单详情信息
	 * @param orderInfo
	 * @return
	 */
	public boolean insert(OrderInfo orderInfo) {
		String sql = "insert my_order_info(order_id, order_commodity_liability1, order_commodity_liability2, order_commodity_liability3, order_commodity_liability4, "
				+ "order_commodity_liability5, order_commodity_liability6, order_commodity_liability7, order_beneficiary_name, order_beneficiary_city, order_beneficiary_phone, "
				+ "order_commodity_time_start, order_commodity_time_end, order_commodity_time_length, order_sum_price) values"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		boolean bo = false;
		String orderId = orderInfo.getOrderId();
		String liability1 = orderInfo.getLiability1();
		String liability2 = orderInfo.getLiability2();
		String liability3 = orderInfo.getLiability3();
		String liability4 = orderInfo.getLiability4();
		String liability5 = orderInfo.getLiability5();
		String liability6 = orderInfo.getLiability6();
		String liability7 = orderInfo.getLiability7();
		String beneficiaryName = orderInfo.getBeneficiaryName();
		String beneficiaryCity = orderInfo.getBeneficiaryCity();
		String beneficiaryPhone = orderInfo.getBeneficiaryPhone();
		String timeStart = orderInfo.getTimeStart();
		String timeEnd = orderInfo.getTimeEnd();
		String timeLength = orderInfo.getTimeLength();
		String price = orderInfo.getPrice();
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, orderId, liability1, liability2, liability3, liability4, liability5, liability6, liability7, beneficiaryName, beneficiaryCity, beneficiaryPhone, timeStart, timeEnd, timeLength, price);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}
	ResultSet rs = null;
	/**
	 * 查询该id订单详情
	 */
	public List<OrderInfo> queryOrderInfoById(String orderId) {
		String sql = "select order_info_id,order_id,order_commodity_liability1,order_commodity_liability2,order_commodity_liability3,order_commodity_liability4,order_commodity_liability5,order_commodity_liability6,order_commodity_liability7,order_beneficiary_name,order_beneficiary_city,order_beneficiary_phone,order_commodity_time_start,order_commodity_time_end,order_commodity_time_length,order_sum_price from my_order_info where order_id=?";
		List<OrderInfo> list = new ArrayList<OrderInfo>();
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql,orderId);
			while(rs.next()) {
				OrderInfo orderInfo = new OrderInfo();
				orderInfo.setId(rs.getInt("order_info_id"));
				orderInfo.setOrderId(rs.getString("order_id"));
				orderInfo.setLiability1(rs.getString("order_commodity_liability1"));
				orderInfo.setLiability2(rs.getString("order_commodity_liability2"));
				orderInfo.setLiability3(rs.getString("order_commodity_liability3"));
				orderInfo.setLiability4(rs.getString("order_commodity_liability4"));
				orderInfo.setLiability5(rs.getString("order_commodity_liability5"));
				orderInfo.setLiability6(rs.getString("order_commodity_liability6"));
				orderInfo.setLiability7(rs.getString("order_commodity_liability7"));
				orderInfo.setBeneficiaryName(rs.getString("order_beneficiary_name"));
				orderInfo.setBeneficiaryCity(rs.getString("order_beneficiary_city"));
				orderInfo.setBeneficiaryPhone(rs.getString("order_beneficiary_phone"));
				orderInfo.setTimeStart(rs.getString("order_commodity_time_start"));
				orderInfo.setTimeEnd(rs.getString("order_commodity_time_end"));
				orderInfo.setTimeLengthl(rs.getString("order_commodity_time_length"));
				orderInfo.setPrice(rs.getString("order_sum_price"));
				list.add(orderInfo);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JDBCUTILE.dbClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * 更新该订单信息
	 */
	public boolean updateOrderInfo(String liability1,String liability2,String liability3,String liability4,String liability5,String liability6,String liability7,String beneficiaryName,String beneficiaryCity,String beneficiaryPhone,String timeStart,String timeEnd,String timeLength,String price,String orderId){
		boolean bo = false;
		String sql = "update my_order_info set order_commodity_liability1=?,order_commodity_liability2=?,order_commodity_liability3=?,order_commodity_liability4=?,order_commodity_liability5=?,order_commodity_liability6=?,order_commodity_liability7=?,order_beneficiary_name=?,order_beneficiary_city=?,order_beneficiary_phone=?,order_commodity_time_start=?,order_commodity_time_end=?,order_commodity_time_length=?,order_sum_price=? from my_order_info where order_id=?";
		try {
			bo = JDBCUTILE.upDataBaseTable(sql,liability1,liability2,liability3,liability4,liability5,liability6,liability7,beneficiaryName,beneficiaryCity,beneficiaryPhone,timeStart,timeEnd,timeLength,price,orderId );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JDBCUTILE.dbClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bo;
	}
	/**
	 * 删除该订单
	 */
	public boolean deleteOrderInfo(String orderId){
		boolean bo = false;
		String sql = "delete from my_order_info where order_id=?";
		try {
			bo = JDBCUTILE.upDataBaseTable(sql,orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JDBCUTILE.dbClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bo;
	};
}
