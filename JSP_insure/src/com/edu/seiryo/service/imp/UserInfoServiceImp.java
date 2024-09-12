package com.edu.seiryo.service.imp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.edu.seiryo.dao.UserInfoDao;
import com.edu.seiryo.dao.imp.UserInfoDaoImp;
import com.edu.seiryo.entity.UserInfo;
import com.edu.seiryo.service.UserInfoService;
/**
 * UserInfoService的实现类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service.imp
 * @file_name UserInfoServiceImp.java
 * @classname UserInfoServiceImp
 * @version 1.0
 */
public class UserInfoServiceImp implements UserInfoService {
	private UserInfoDao dao = new UserInfoDaoImp();

	/**
	 * 判断电话号码是否被注册
	 * 
	 * @param phone
	 * @return
	 */
	public boolean ifPhoneExist(String phone) {
		UserInfo userInfo = dao.queryByPhone(phone);
		if (userInfo != null) {
			return true;
		}
		return false;
	}
	public boolean userInfoRegister(int userId, String phone, String money, String name, String birthday, String sex,
			int status) {
		UserInfo userInfo = new UserInfo(userId, phone, money, name, birthday, sex, status);
		return dao.insertUserInfo(userInfo);
	}

	/**
	 * 根据用户id获取用户详情
	 * @param userId
	 * @return
	 */
	public UserInfo getUserInfoByUserId(int userId) {
		return dao.queryByUserId(userId);
	}
	public UserInfo getUserInfoByName(String name) {
		return dao.queryByName(name);
	}
	
	/**
	 * 判断名字是否注册过
	 * @param name
	 * @return
	 */
	public boolean ifNameExist(String name) {
		UserInfo userInfo = dao.queryByName(name);
		if(userInfo == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * 根据姓名取得年龄
	 * @param name
	 * @return
	 */
	public int getAgeByName(String name) {
		UserInfo userInfo = dao.queryByName(name);
		String birthday = userInfo.getBirthday();
		int birthYear = Integer.parseInt(birthday.substring(0, 4));
		int currentYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
		return currentYear - birthYear;
	}

	/**
	 * 根据id修改余额
	 * @param userId
	 * @param price
	 * @return
	 */
	public boolean changeMoneyByUserId(int userId, double price) {
		UserInfo userInfo = dao.queryByUserId(userId);
		double currentMoney = Double.parseDouble(userInfo.getMoney());
		String resultMoney = (currentMoney + price) + "";
		return dao.updateMoneyByUserId(userId, resultMoney);
	}
	
	/**
	 * 根据id修改号码
	 * @param userId
	 * @param phone
	 * @return
	 */
	public boolean changePhoneByUserId(int userId, String phone) {
		return dao.updatePhoneByUserId(userId, phone);
	}
	public List<UserInfo> queryAll(){
		return dao.queryAll();
	}
	public List<UserInfo> queryById(int id){
		return dao.queryById(id);
	}
	public boolean update(String phone,String money,String name,String birthday,String sex,int status,int id){
		return dao.update(phone, money, name, birthday, sex, status, id);
	}
	public boolean delete(int id){
		return dao.delete(id);
	}
}
