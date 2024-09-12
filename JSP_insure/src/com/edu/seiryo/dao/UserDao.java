package com.edu.seiryo.dao;

import java.util.List;

import com.edu.seiryo.entity.User;
import com.edu.seiryo.entity.UserInfo;
/**
 * User数据处理类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao
 * @file_name UserDao.java
 * @classname UserDao
 * @version 1.0
 */
public interface UserDao {
	public User queryByEmail(String email);
	public boolean insertUser(User user);
	public boolean updatePasswordById(int id, String password);
	public List<User> queryAll();
	public List<User> queryById(int id);
	public boolean update(String email,String password,int status,int id);
	public boolean delete(int id);
}
