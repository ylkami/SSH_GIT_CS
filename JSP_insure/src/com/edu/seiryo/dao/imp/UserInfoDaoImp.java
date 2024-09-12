package com.edu.seiryo.dao.imp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.seiryo.dao.UserInfoDao;
import com.edu.seiryo.entity.User;
import com.edu.seiryo.entity.UserInfo;
import com.edu.seiryo.util.JDBCUTILE;
/**
 * UserInfoDao��ʵ����
 * @author GuoYuanZhao
 * @date 2024��6��6��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao.imp
 * @file_name UserInfoDaoImp.java
 * @classname UserInfoDaoImp
 * @version 1.0
 */
public class UserInfoDaoImp implements UserInfoDao {
	private ResultSet rs;
	/**
	 * ͨ�������ѯ�û�
	 * @param phone
	 * @return
	 */
	@Override
	public UserInfo queryByPhone(String phone) {
		String sql = "select user_info_id,user_id,user_phone,user_money,user_name,user_birthday,user_sex,user_status from my_user_info where user_phone = ?";
		UserInfo userInfo = null;
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql, phone);
			if(rs.next()) {
				userInfo = new UserInfo();
				userInfo.setId(rs.getInt("user_info_id"));
				userInfo.setUserId(rs.getInt("user_id"));
				userInfo.setMoney(rs.getString("user_money"));
				userInfo.setName(rs.getString("user_name"));
				userInfo.setBirthday(rs.getString("user_birthday"));
				userInfo.setSex(rs.getString("user_sex"));
				userInfo.setStatus(rs.getInt("user_status"));
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
		return userInfo;
	}
	
	/**
	 * �½��û���ϸ��Ϣ
	 * @param userInfo
	 * @return
	 */
	public boolean insertUserInfo(UserInfo userInfo) {
		String sql = "insert my_user_info(user_id, user_phone, user_money, user_name, user_birthday, user_sex, user_status) values(?,?,?,?,?,?,?)";
		int userId = userInfo.getUserId();
		String phone = userInfo.getPhone();
		String money = userInfo.getMoney();
		String name = userInfo.getName();
		String birthday = userInfo.getBirthday();
		String sex = userInfo.getSex();
		int status = userInfo.getStatus();
		boolean bo = false;
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, userId, phone, money, name, birthday, sex, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}
	
	/**
	 * ����userId��ѯ�û�
	 * @param userId
	 * @return
	 */
	@Override
	public UserInfo queryByUserId(int userId) {
		String sql = "select user_info_id,user_id,user_phone,user_money,user_name,user_birthday,user_sex,user_status from my_user_info where user_id = ?";
		UserInfo userInfo = null;
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql, userId);
			if(rs.next()) {
				userInfo = new UserInfo();
				userInfo.setId(rs.getInt("user_info_id"));
				userInfo.setPhone(rs.getString("user_phone"));
				userInfo.setMoney(rs.getString("user_money"));
				userInfo.setName(rs.getString("user_name"));
				userInfo.setBirthday(rs.getString("user_birthday"));
				userInfo.setSex(rs.getString("user_sex"));
				userInfo.setStatus(rs.getInt("user_status"));
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
		return userInfo;
	}
	
	/**
	 * ͨ��������ѯ�û�
	 * @param name
	 * @return
	 */
	@Override
	public UserInfo queryByName(String name) {
		String sql = "select user_info_id,user_id,user_phone,user_money,user_name,user_birthday,user_sex,user_status from my_user_info where user_name= ?";
		UserInfo userInfo = null;
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql, name);
			if(rs.next()) {
				userInfo = new UserInfo();
				userInfo.setId(rs.getInt("user_info_id"));
				userInfo.setUserId(rs.getInt("user_id"));
				userInfo.setPhone(rs.getString("user_phone"));
				userInfo.setMoney(rs.getString("user_money"));
				userInfo.setName(rs.getString("user_name"));
				userInfo.setBirthday(rs.getString("user_birthday"));
				userInfo.setSex(rs.getString("user_sex"));
				userInfo.setStatus(rs.getInt("user_status"));
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
		return userInfo;
	}
	
	/**
	 * �����û�id�޸����
	 * @param userId
	 * @return
	 */
	public boolean updateMoneyByUserId(int userId, String money) {
		String sql = "update my_user_info set user_money = ? where user_id = ?";
		boolean bo = false;
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, money, userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}
	
	/**
	 * �����û�id�޸ĵ绰
	 * @param userId
	 * @param phone
	 * @return
	 */
	public boolean updatePhoneByUserId(int userId, String phone) {
		String sql = "update my_user_info set user_phone = ? where user_id = ?";
		boolean bo = false;
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, phone, userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}
	/**
	 * ��ѯ�����û���ϸ��Ϣ
	 */
	public List<UserInfo> queryAll(){
		String sql = "select user_info_id,user_id,user_phone,user_money,user_name,user_birthday,user_sex,user_status from my_user_info";
		List<UserInfo> list = new ArrayList<UserInfo>();
		try{
			rs = JDBCUTILE.selectDataBaseTable(sql);
			while(rs.next()){
				UserInfo userInfo = new UserInfo();
				userInfo.setId(rs.getInt("user_info_id"));
				userInfo.setUserId(rs.getInt("user_id"));
				userInfo.setPhone(rs.getString("user_phone"));
				userInfo.setMoney(rs.getString("user_money"));
				userInfo.setName(rs.getString("user_name"));
				userInfo.setBirthday(rs.getString("user_birthday"));
				userInfo.setSex(rs.getString("user_sex"));
				userInfo.setStatus(rs.getInt("user_status"));
				list.add(userInfo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * ��ѯ��id�û���ϸ��Ϣ
	 */
	public List<UserInfo> queryById(int id){
		String sql = "select user_info_id,user_id,user_phone,user_money,user_name,user_birthday,user_sex,user_status from my_user_info where user_id=?";
		List<UserInfo> list = new ArrayList<UserInfo>();
		try{
			rs = JDBCUTILE.selectDataBaseTable(sql,id);
			while(rs.next()){
				UserInfo userInfo = new UserInfo();
				userInfo.setId(rs.getInt("user_info_id"));
				userInfo.setUserId(rs.getInt("user_id"));
				userInfo.setPhone(rs.getString("user_phone"));
				userInfo.setMoney(rs.getString("user_money"));
				userInfo.setName(rs.getString("user_name"));
				userInfo.setBirthday(rs.getString("user_birthday"));
				userInfo.setSex(rs.getString("user_sex"));
				userInfo.setStatus(rs.getInt("user_status"));
				list.add(userInfo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * ���¸��û���ϸ��Ϣ
	 */
	public boolean update(String phone,String money,String name,String birthday,String sex,int status,int id){
		String sql = "update my_user_info set user_phone=?,user_money=?,user_name=?,user_birthday=?,user_sex=?,user_status=? where user_id=?";
		boolean bo = false;
		try{
			bo = JDBCUTILE.upDataBaseTable(sql, phone,money,name,birthday,sex,status,id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}
	/**
	 * ɾ�����û���ϸ��Ϣ
	 */
	public boolean delete(int id){
		String sql = "delete from my_user_info where user_id=?";
		boolean bo = false;
		try{
			bo = JDBCUTILE.upDataBaseTable(sql,id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}
}
