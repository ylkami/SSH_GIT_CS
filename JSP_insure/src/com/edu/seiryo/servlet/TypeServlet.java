package com.edu.seiryo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.seiryo.entity.Type;
import com.edu.seiryo.service.TypeService;
import com.edu.seiryo.service.imp.TypeServiceImp;


/**
 * Servlet implementation class TypeServlet
 */
/**
 * Type处理平台
 * @author GuoYuanZhao
 * @date 2024年6月13日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.servlet
 * @file_name TypeServlet.java
 * @classname TypeServlet
 * @version 1.0
 */
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TypeService typeService = new TypeServiceImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeServlet() {
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
		if("queryById".equals(opt)){
			queryTypeById(request,response);
		}
		if("delete".equals(opt)){
			delete(request,response);
			request.getRequestDispatcher("background_type.jsp").forward(request, response);
		}
		if("update".equals(opt)){
			queryById(request,response);
			request.getRequestDispatcher("background_type_update.jsp").forward(request, response);
		}
		if("updating".equals(opt)){
			update(request,response);
			request.getRequestDispatcher("background_type.jsp").forward(request, response);
		}
		if("add".equals(opt)){
			response.sendRedirect("background_type_add.jsp");
		}
		if("adding".equals(opt)){
			add(request,response);
			response.sendRedirect("background_type.jsp");
		}
	}
	/**
	 * 查询所有类型
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Type> list = typeService.queryAll();
		if(list!=null){
			request.setAttribute("allType", list);
		}
	}
	/**
	 * 查询所有上架类型(改)
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryAllOn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Type> list = typeService.queryAllOn();
		if(list!=null){
			String type1 = list.get(0).getType();
			String type2 = list.get(1).getType();
			String type3 = list.get(2).getType();
			String type4 = list.get(3).getType();
			String type5 = list.get(4).getType();
			request.setAttribute("type1", type1);
			request.setAttribute("type2", type2);
			request.setAttribute("type3", type3);
			request.setAttribute("type4", type4);
			request.setAttribute("type5", type5);
		}
	}
	/**
	 * 删除该类型
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typeId = Integer.parseInt(request.getParameter("id"));
		boolean bo = typeService.deleteType(typeId);
		queryAll(request,response);
	}
	/**
	 * 查询该类型
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typeId = Integer.parseInt(request.getParameter("id"));
		List<Type> list = typeService.queryTypeById(typeId);
		if(list!=null){
			request.setAttribute("TypeById", list);
		}
		
	}
	/**
	 * 更新该类型
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int typeId = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		int typeOn = Integer.parseInt(request.getParameter("typeOn"));
		boolean bo = typeService.updateType(type, typeOn, typeId);
		queryAll(request,response);
	}
	/**
	 * 搜索该类型
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryTypeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query");
		List<Type> list;
		if(query.equals("")){
			list = typeService.queryAll();
			if(list!=null){
				request.setAttribute("allType", list);
			}
		}else{
			int typeId = Integer.parseInt(query);
			list = typeService.queryTypeById(typeId);
			if(list!=null){
				request.setAttribute("allType", list);
			}
		}
		if(list!=null){
			request.setAttribute("allType", list);
		}
		request.getRequestDispatcher("background_type_query.jsp").forward(request, response);
	}
	/**
	 * 新增类型
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String type = request.getParameter("type");
		int typeOn = Integer.parseInt(request.getParameter("typeOn"));
		boolean bo = typeService.addType(type, typeOn);
		queryAll(request,response);
	}
}
