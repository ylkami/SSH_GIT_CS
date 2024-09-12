package com.edu.seiryo.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.edu.seiryo.dao.UserDao;
import com.edu.seiryo.entity.Commodity;
import com.edu.seiryo.entity.User;
import com.edu.seiryo.entity.UserInfo;
import com.edu.seiryo.util.JDBCUTILE;
/**
 * UserDao的实现类
 * @author GuoYuanZhao
 * @date 2024年6月5日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao.imp
 * @file_name UserDaoImp.java
 * @classname UserDaoImp
 * @version 1.0
 */
public class UserDaoImp implements UserDao {
	private ResultSet rs;

	/**
	 * 登录验证
	 * @param email
	 * @return
	 */
	@Override
	public User queryByEmail(String email) {
		String sql = "select user_id,user_password from my_user where user_email = ? and user_status=1 ";
		User user = null;
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql, email);
			if(rs.next()) {
				int id = rs.getInt("user_id");
				String password = rs.getString("user_password");
				user = new User(id, email, password);
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
		return user;
	}
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public boolean insertUser(User user) {
		String sql = "insert my_user(user_email, user_password,user_status) values(?, ?)";
		String email = user.getEmail();
		String password = user.getPassword();
		boolean bo = false;
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, email, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}
	
	/**
	 * 根据id修改密码
	 * @param id
	 * @param password
	 * @return
	 */
	public boolean updatePasswordById(int id, String password) {
		String sql = "update my_user set user_password = ? where user_id = ?";
		boolean bo = false;
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, password, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}
	/**
	 * 查询所有用户
	 */
	public List<User> queryAll(){
		String sql = "select user_id,user_email,user_password,user_status from my_user";
		List<User> list = new ArrayList<User>();
		try{
			rs = JDBCUTILE.selectDataBaseTable(sql);
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setEmail(rs.getString("user_email"));
				user.setPassword(rs.getString("user_password"));
				user.setStatus(rs.getInt("user_status"));
				list.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查询该id用户
	 */
	public List<User> queryById(int id){
		String sql = "select user_id,user_email,user_password,user_status from my_user where user_id=?";
		List<User> list = new ArrayList<User>();
		try{
			rs = JDBCUTILE.selectDataBaseTable(sql,id);
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setEmail(rs.getString("user_email"));
				user.setPassword(rs.getString("user_password"));
				user.setStatus(rs.getInt("user_status"));
				list.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 更新该用户
	 */
	public boolean update(String email,String password,int status,int id){
		String sql = "update my_user set user_email=?,user_password=?,user_status=? where user_id=?";
		boolean bo = false;
		try{
			bo = JDBCUTILE.upDataBaseTable(sql, email,password,status,id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}
	/**
	 * 删除该用户
	 */
	public boolean delete(int id){
		String sql = "delete from my_user where user_id=?";
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
