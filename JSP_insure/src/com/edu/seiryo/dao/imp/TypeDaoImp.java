package com.edu.seiryo.dao.imp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.seiryo.dao.TypeDao;
import com.edu.seiryo.entity.Type;
import com.edu.seiryo.util.JDBCUTILE;
/**
 * TypeDao的实现类
 * @author GuoYuanZhao
 * @date 2024年6月13日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao.imp
 * @file_name TypeDaoImp.java
 * @classname TypeDaoImp
 * @version 1.0
 */
public class TypeDaoImp implements TypeDao {
	ResultSet rs = null;
	/**
	 * 查询所有类型
	 */
	public List<Type> queryAll() {
		String sql = "select type_id,type,type_on from type";
		List<Type> list = new ArrayList<Type>();
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql);
			while(rs.next()) {
				Type type = new Type();
				type.setTypeId(rs.getInt("type_id"));
				type.setType(rs.getString("type"));
				type.setTypeOn(rs.getInt("type_on"));
				list.add(type);
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
	 * 查询该id类型
	 */
	public List<Type> queryTypeById(int typeId) {
		String sql = "select type_id,type,type_on from type where type_id=?";
		List<Type> list = new ArrayList<Type>();
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql,typeId);
			while(rs.next()) {
				Type type = new Type();
				type.setTypeId(rs.getInt("type_id"));
				type.setType(rs.getString("type"));
				type.setTypeOn(rs.getInt("type_on"));
				list.add(type);
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
	 * 新增类型
	 */
	public boolean addType(String type,int typeOn){
		boolean bo = false;
		String sql = "insert into type(type,type_on) values(?,?)";
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, type,typeOn);
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
	 * 更新该类型
	 */
	public boolean updateType(String type,int typeOn,int typeId){
		boolean bo = false;
		String sql = "update type set type=?,type_on=? where type_id=?";
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, type,typeOn,typeId);
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
	 * 删除该类型
	 */
	public boolean deleteType(int typeId){
		boolean bo = false;
		String sql = "delete from type where type_id=?";
		try {
			bo = JDBCUTILE.upDataBaseTable(sql,typeId);
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
	 * 查询所有上架类型
	 */
	public List<Type> queryAllOn() {
		String sql = "select type_id,type,type_on from type where type_on=1";
		List<Type> list = new ArrayList<Type>();
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql);
			while(rs.next()) {
				Type type = new Type();
				type.setTypeId(rs.getInt("type_id"));
				type.setType(rs.getString("type"));
				type.setTypeOn(rs.getInt("type_on"));
				list.add(type);
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
