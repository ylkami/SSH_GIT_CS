package com.edu.seiryo.dao;

import java.util.List;

import com.edu.seiryo.entity.Comment;
/**
 * Comment���ݴ�����
 * @author GuoYuanZhao
 * @date 2024��6��13��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao
 * @file_name CommentDao.java
 * @classname CommentDao
 * @version 1.0
 */
public interface CommentDao {
	public List<Comment> queryAll();
	public List<Comment> queryCommentById(int commodityId);
	public boolean addComment(int commodityId,String email,String message);
}
