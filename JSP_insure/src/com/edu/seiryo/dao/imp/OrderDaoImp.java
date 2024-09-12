package com.edu.seiryo.dao.imp;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.seiryo.dao.OrderDao;
import com.edu.seiryo.entity.Order;
import com.edu.seiryo.entity.Type;
import com.edu.seiryo.util.JDBCUTILE;
/**
 * OrderDao的实现类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao.imp
 * @file_name OrderDaoImp.java
 * @classname OrderDaoImp
 * @version 1.0
 */
public class OrderDaoImp implements OrderDao {
	/**
	 * 创建一条新订单
	 * @param order
	 * @return
	 */
	public boolean insertOrder(Order order) {
		String sql = "insert my_order(order_id, user_id, commodity_id) values(?, ?, ?)";
		boolean bo = false;
		String id = order.getId();
		int userId = order.getUserId();
		int commodityId = order.getCommodityId();
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, id, userId, commodityId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}
	ResultSet rs = null;
	/**
	 * 查询所有订单
	 */
	public List<Order> queryAll() {
		String sql = "select order_id,user_id,commodity_id from my_order";
		List<Order> list = new ArrayList<Order>();
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql);
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getString("order_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setCommodityId(rs.getInt("commodity_id"));
				list.add(order);
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
	 * 查询该id订单
	 */
	public List<Order> queryOrderById(String orderId) {
		String sql = "select order_id,user_id,commodity_id from my_order where order_id=?";
		List<Order> list = new ArrayList<Order>();
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql,orderId);
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getString("order_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setCommodityId(rs.getInt("commodity_id"));
				list.add(order);
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
	public boolean updateOrder(int userId,int commodityId,String orderId){
		boolean bo = false;
		String sql = "update my_order set user_id=?,commodity_id=? where order_id=?";
		try {
			bo = JDBCUTILE.upDataBaseTable(sql,userId,commodityId,orderId);
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
	public boolean deleteOrder(String orderId){
		boolean bo = false;
		String sql = "delete from my_order where order_id=?";
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
	}

}
