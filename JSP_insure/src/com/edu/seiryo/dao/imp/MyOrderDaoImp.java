package com.edu.seiryo.dao.imp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.seiryo.dao.MyOrderDao;
import com.edu.seiryo.entity.MyOrder;
import com.edu.seiryo.util.JDBCUTILE;
/**
 * MyOrderDao的实现类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao.imp
 * @file_name MyOrderDaoImp.java
 * @classname MyOrderDaoImp
 * @version 1.0
 */
public class MyOrderDaoImp implements MyOrderDao {
	private ResultSet rs;
	
	/**
	 * 查找指定投保人（id）的所有保险
	 * @param userId
	 * @return
	 */
	public List<MyOrder> queryByUserId(int userId) {
		String sql = "select my_order.order_id, commodity_name, commodity_price, my_user_info.user_name, my_order_info.order_beneficiary_name, "
					+ "order_commodity_time_start, order_commodity_time_end, order_commodity_time_length from my_order, commodity, my_user_info, my_order_info "
					+ "where my_order.commodity_id = commodity.commodity_id and my_order.user_id = my_user_info.user_id and my_order.order_id = my_order_info.order_id "
					+ "and my_user_info.user_id = ?";
		List<MyOrder> list = new ArrayList<MyOrder>();
		
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql, userId);
			while(rs.next()) {
				MyOrder myOrder = new MyOrder();
				myOrder.setOrderId(rs.getString("order_id"));
				myOrder.setCommodityName(rs.getString("commodity_name"));
				myOrder.setCommodityPrice(rs.getString("commodity_price"));
				myOrder.setUserName(rs.getString("user_name"));
				myOrder.setBeneficiaryName(rs.getString("order_beneficiary_name"));
				myOrder.setTimeStart(rs.getString("order_commodity_time_start"));
				myOrder.setTimeEnd(rs.getString("order_commodity_time_end"));
				myOrder.setTimeLength(rs.getString("order_commodity_time_length"));
				list.add(myOrder);
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
}
