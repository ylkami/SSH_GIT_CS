package com.edu.seiryo.service;

import java.util.List;

import com.edu.seiryo.entity.User;
import com.edu.seiryo.entity.UserInfo;
/**
 * User业务逻辑控制类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service
 * @file_name UserService.java
 * @classname UserService
 * @version 1.0
 */
public interface UserService {
	public boolean ifEmailExist(String email);
	public boolean ifPasswordCorrect(String email, String password);
	public int userRegister(String email, String password);
	public User getUserByEmail(String email);
	public boolean changePasswordById(String password, int id);
	public List<User> queryAll();
	public List<User> queryById(int id);
	public boolean update(String email,String password,int status,int id);
	public boolean delete(int id);
}
