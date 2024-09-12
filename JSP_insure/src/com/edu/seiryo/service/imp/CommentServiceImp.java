package com.edu.seiryo.service.imp;

import java.util.List;

import com.edu.seiryo.dao.CommentDao;
import com.edu.seiryo.dao.imp.CommentDaoImp;
import com.edu.seiryo.entity.Comment;
import com.edu.seiryo.service.CommentService;
/**
 * CommentService实现类
 * @author GuoYuanZhao
 * @date 2024年6月13日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service.imp
 * @file_name CommentServiceImp.java
 * @classname CommentServiceImp
 * @version 1.0
 */
public class CommentServiceImp implements CommentService {
	CommentDao dao = new CommentDaoImp();
	public List<Comment> queryAll(){
		return dao.queryAll();
	}
	public List<Comment> queryCommentById(int commodityId){
		return dao.queryCommentById(commodityId);
	}
	public boolean addComment(int commodityId,String email,String message){
		return dao.addComment(commodityId, email, message);
	}
}
