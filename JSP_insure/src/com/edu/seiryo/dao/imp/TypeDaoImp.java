package com.edu.seiryo.dao.imp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.seiryo.dao.TypeDao;
import com.edu.seiryo.entity.Type;
import com.edu.seiryo.util.JDBCUTILE;
/**
 * TypeDao��ʵ����
 * @author GuoYuanZhao
 * @date 2024��6��13��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao.imp
 * @file_name TypeDaoImp.java
 * @classname TypeDaoImp
 * @version 1.0
 */
public class TypeDaoImp implements TypeDao {
	ResultSet rs = null;
	/**
	 * ��ѯ��������
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
	 * ��ѯ��id����
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
	 * ��������
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
	 * ���¸�����
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
	 * ɾ��������
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
	 * ��ѯ�����ϼ�����
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
