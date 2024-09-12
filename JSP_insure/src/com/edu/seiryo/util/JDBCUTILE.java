package com.edu.seiryo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUTILE {
	
	//SQL SERVER JDBC 
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	//SQL SERVER 
	private static final String URL = "jdbc:mysql://139.159.217.171:3306/insuredatabase?characterEncoding=UTF-8";
	
	
	//SQL SERVER
	private static final String ADMIN = "root";
	
	//SQL SERVER 
	private static final String PASSWORD = "123123";
			
	
	private static Connection con = null;
	private static PreparedStatement pst = null;
	private static ResultSet rst = null;
	
	/**
	 * @param sql
	 * @param objects
	 * @throws Exception
	 */
	private static void preparedStatement(String sql,Object...objects) throws Exception{
		Class.forName(DRIVER);
		con = DriverManager.getConnection(URL,ADMIN,PASSWORD);
		pst = con.prepareStatement(sql);
		for(int i = 0; i < objects.length; i++) {
			pst.setObject(i + 1, objects[i]);
		}
	}
	
	/**
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public static boolean upDataBaseTable(String sql,Object...objects) throws Exception{
		preparedStatement(sql,objects);
		boolean bo = pst.executeUpdate() > 0?true:false;
		dbClose(rst, pst, con);
		return bo;
	}
	
	/**
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public static ResultSet selectDataBaseTable(String sql,Object...objects) throws Exception{
		preparedStatement(sql,objects);
		rst = pst.executeQuery();
		return rst;
	}
	
	/**
	 * @param rst
	 * @param pst
	 * @param con
	 * @throws Exception
	 */
	public static void dbClose(ResultSet rst,PreparedStatement pst,Connection con) throws Exception{
		if(rst != null) {
			rst.close();
		}
		if(pst != null) {
			pst.close();
		}
		if(con != null) {
			con.close();
		}
	}
	
	/**
	 * @throws Exception
	 */
	public static void dbClose() throws Exception{
		if(rst != null) {
			rst.close();
		}
		if(pst != null) {
			pst.close();
		}
		if(con != null) {
			con.close();
		}
	}

}
