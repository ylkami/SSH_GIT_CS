package com.edu.seiryo.service;

import java.util.List;

import com.edu.seiryo.entity.UserInfo;
/**
 * UserInfo业务逻辑控制类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service
 * @file_name UserInfoService.java
 * @classname UserInfoService
 * @version 1.0
 */
public interface UserInfoService {
	public boolean ifPhoneExist(String phone);
	public boolean userInfoRegister(int userId, String phone, String money, String name, String birthday, String sex,int status);
	public UserInfo getUserInfoByUserId(int userId);
	public UserInfo getUserInfoByName(String name);
	public boolean ifNameExist(String name);
	public int getAgeByName(String name);
	public boolean changeMoneyByUserId(int userId, double price);
	public boolean changePhoneByUserId(int userId, String phone);
	public List<UserInfo> queryAll();
	public List<UserInfo> queryById(int id);
	public boolean update(String phone,String money,String name,String birthday,String sex,int status,int id);
	public boolean delete(int id);
}
