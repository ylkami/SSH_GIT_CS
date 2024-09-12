package com.edu.seiryo.dao;

import java.util.List;

import com.edu.seiryo.entity.UserInfo;
/**
 * UserInfo���ݴ�����
 * @author GuoYuanZhao
 * @date 2024��6��6��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao
 * @file_name UserInfoDao.java
 * @classname UserInfoDao
 * @version 1.0
 */
public interface UserInfoDao {
	public UserInfo queryByPhone(String phone);
	public boolean insertUserInfo(UserInfo userInfo);
	public UserInfo queryByUserId(int userId);
	public UserInfo queryByName(String name);
	public boolean updateMoneyByUserId(int userId, String money);
	public boolean updatePhoneByUserId(int userId, String phone);
	public List<UserInfo> queryAll();
	public List<UserInfo> queryById(int id);
	public boolean update(String phone,String money,String name,String birthday,String sex,int status,int id);
	public boolean delete(int id);
}
