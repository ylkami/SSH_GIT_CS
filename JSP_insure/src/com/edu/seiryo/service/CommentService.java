package com.edu.seiryo.service;

import java.util.List;

import com.edu.seiryo.entity.Comment;
/**
 * Commentҵ���߼�������
 * @author GuoYuanZhao
 * @date 2024��6��13��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service
 * @file_name CommentService.java
 * @classname CommentService
 * @version 1.0
 */
public interface CommentService {
	public List<Comment> queryAll();
	public List<Comment> queryCommentById(int commodityId);
	public boolean addComment(int commodityId,String email,String message);
}
