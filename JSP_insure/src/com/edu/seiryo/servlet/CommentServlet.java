package com.edu.seiryo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.seiryo.entity.Comment;
import com.edu.seiryo.entity.Type;
import com.edu.seiryo.entity.User;
import com.edu.seiryo.service.CommentService;
import com.edu.seiryo.service.imp.CommentServiceImp;

/**
 * Servlet implementation class CommentServlet
 */
/**
 * Comment平台
 * @author GuoYuanZhao
 * @date 2024年6月13日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.servlet
 * @file_name CommentServlet.java
 * @classname CommentServlet
 * @version 1.0
 */
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CommentService commentService = new CommentServiceImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String opt = request.getParameter("opt");
		if("queryAll".equals(opt)){
			queryAll(request,response);
		}
	}
	/**
	 * 展示所有评论
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Comment> list = commentService.queryAll();
		if(list!=null){
			request.setAttribute("allComment", list);
		}
	}
}
