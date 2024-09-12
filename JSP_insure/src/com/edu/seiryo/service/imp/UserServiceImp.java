package com.edu.seiryo.service.imp;

import java.util.List;

import com.edu.seiryo.dao.UserDao;
import com.edu.seiryo.dao.imp.UserDaoImp;
import com.edu.seiryo.entity.User;
import com.edu.seiryo.entity.UserInfo;
import com.edu.seiryo.service.UserService;
/**
 * UserServicede��ʵ����
 * @author GuoYuanZhao
 * @date 2024��6��6��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service.imp
 * @file_name UserServiceImp.java
 * @classname UserServiceImp
 * @version 1.0
 */
public class UserServiceImp implements UserService {
	private UserDao dao = new UserDaoImp();

	/**
	 * �ж�ָ�������û��Ƿ����
	 * @return
	 */
	public boolean ifEmailExist(String email) {
		User user = dao.queryByEmail(email);
		if(user == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * �ж������Ƿ���ȷ
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean ifPasswordCorrect(String email, String password) {
		User user = dao.queryByEmail(email);
		if(user == null) {
			return false;
		}
		String psw = user.getPassword();
		if(!psw.equals(password)) {
			return false;
		}
		return true;
	}
	
	/**
	 * �½��û�����������id
	 * @param email
	 * @param password
	 * @return
	 */
	public int userRegister(String email, String password) {
		dao.insertUser(new User(email, password));
		User user = dao.queryByEmail(email);
		if(user==null){
			return -1;
		}
		return user.getId();
	}
	
	/**
	 * ����email��ȡһ��user����
	 * @param email
	 * @return
	 */
	@Override
	public User getUserByEmail(String email) {
		return dao.queryByEmail(email);
	}
	
	/**
	 * ����id�޸�����
	 * @param password
	 * @param id
	 * @return
	 */
	@Override
	public boolean changePasswordById(String password, int id) {
		return dao.updatePasswordById(id, password);
	}
	public List<User> queryAll(){
		return dao.queryAll();
	}
	public List<User> queryById(int id){
		return dao.queryById(id);
	}
	public boolean update(String email,String password,int status,int id){
		return dao.update(email, password,status, id);
	}
	public boolean delete(int id){
		return dao.delete(id);
	}
}
