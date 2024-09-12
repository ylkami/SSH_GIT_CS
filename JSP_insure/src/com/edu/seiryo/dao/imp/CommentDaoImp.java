package com.edu.seiryo.dao.imp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.seiryo.dao.CommentDao;
import com.edu.seiryo.entity.Comment;
import com.edu.seiryo.util.JDBCUTILE;
/**
 * CommentDao的实现类
 * @author GuoYuanZhao
 * @date 2024年6月13日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao.imp
 * @file_name CommentDaoImp.java
 * @classname CommentDaoImp
 * @version 1.0
 */
public class CommentDaoImp implements CommentDao {
	ResultSet rs = null;
	/**
	 * 查询全部评论
	 */
	public List<Comment> queryAll() {
		String sql = "select comment_id,commodity_id,user_email,message from comment";
		List<Comment> list = new ArrayList<Comment>();
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql);
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getInt("comment_id"));
				comment.setCommodityId(rs.getInt("commodity_id"));
				comment.setEmail(rs.getString("user_email"));
				comment.setMessage(rs.getString("message"));
				list.add(comment);
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
	 * 查询当前商品评论
	 */
	public List<Comment> queryCommentById(int commodityId) {
		String sql = "select comment_id,commodity_id,user_email,message from comment where commodity_id=?";
		List<Comment> list = new ArrayList<Comment>();
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql,commodityId);
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getInt("comment_id"));
				comment.setCommodityId(rs.getInt("commodity_id"));
				comment.setEmail(rs.getString("user_email"));
				comment.setMessage(rs.getString("message"));
				list.add(comment);
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
	 * 新增评论
	 */
	public boolean addComment(int commodityId,String email,String message){
		boolean bo = false;
		String sql = "insert into comment(commodity_id,user_email,message) values(?,?,?)";
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, commodityId,email,message);
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
}