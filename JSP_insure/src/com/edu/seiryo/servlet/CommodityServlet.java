package com.edu.seiryo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.seiryo.entity.Comment;
import com.edu.seiryo.entity.Commodity;
import com.edu.seiryo.entity.CommodityInfo;
import com.edu.seiryo.entity.User;
import com.edu.seiryo.entity.UserInfo;
import com.edu.seiryo.service.CommentService;
import com.edu.seiryo.service.CommodityInfoService;
import com.edu.seiryo.service.CommodityService;
import com.edu.seiryo.service.imp.CommentServiceImp;
import com.edu.seiryo.service.imp.CommodityInfoServiceImp;
import com.edu.seiryo.service.imp.CommodityServiceImp;

/**
 * 商品平台
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.servlet
 * @file_name CommodityServlet.java
 * @classname CommodityServlet
 * @version 1.0
 */
public class CommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommodityService commodityService = new CommodityServiceImp();
	private CommodityInfoService commodityInfoService = new CommodityInfoServiceImp();
	CommentService commentService = new CommentServiceImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommodityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String opt = request.getParameter("opt");
		if ("selectAllCommodityList".equals(opt)) {
			String status = request.getParameter("status");
			if ("login".equals(status)) {
				selectAllCommodityListSort(request, response);
				return;
			}
			selectAllCommodityList(request, response);
		}
		if ("commodityQueryById".equals(opt)) {
			showDetail(request, response);
		}
		if ("shop".equals(opt)) {
			shop(request, response);
		}
		if("queryAll".equals(opt)){
			queryAll(request,response);
		}
		if("queryById".equals(opt)){
			queryCommodityById(request,response);
		}
		if("delete".equals(opt)){
			delete(request,response);
			request.getRequestDispatcher("background_commodity.jsp").forward(request, response);
		}
		if("update".equals(opt)){
			queryById(request,response);
			request.getRequestDispatcher("background_commodity_update.jsp").forward(request, response);
		}
		if("updating".equals(opt)){
			update(request,response);
			request.getRequestDispatcher("background_commodity.jsp").forward(request, response);
		}
		if("add".equals(opt)){
			response.sendRedirect("background_commodity_add.jsp");
		}
		if("adding".equals(opt)){
			add(request,response);
			request.getRequestDispatcher("background_commodity.jsp").forward(request, response);
		}
		if("addComment".equals(opt)){
			addComment(request,response);
		}
	}

	/**
	 * 未登录时展示所有商品
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void selectAllCommodityList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String json = "";
		String type = request.getParameter("type");
		if("".equals(type) || type == null) {
			json = commodityService.getAllCommodityJSONString();			
		} else {
			json = commodityService.getAllCommodityJSONString(type);
		}
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 登陆时展示并置顶部分商品
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void selectAllCommodityListSort(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("currentUserInfoObj");
		String json = "";
		String type = request.getParameter("type");
		if("".equals(type) || type == null) {
			json = commodityService.getAllCommoditySortJSONString(userInfo);			
		} else {
			json = commodityService.getAllCommoditySortJSONString(userInfo, type);
		}
		out.print(json);
		out.close();
	}

	/**
	 * 获取保险基本信息并展示
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int commodityId = Integer.parseInt(request.getParameter("commodity_id"));
		Commodity commodity = commodityService.getCommodityById(commodityId);
		CommodityInfo commodityInfo = commodityInfoService.getCommodityInfoByCommodityId(commodityId);
		request.setAttribute("commodity", commodity);
		request.setAttribute("commodityInfo", commodityInfo);
		List<Comment> list = commentService.queryCommentById(commodityId);
		if(list!=null){
			request.setAttribute("CommentById", list);
		}
		request.getRequestDispatcher("page_info.jsp").forward(request, response);
	}

	/**
	 * 获取保险详细信息并展示（未登录则跳转登陆界面）
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void shop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 未登录时
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUserObj");
		if (currentUser == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		// 已登录，展示信息
		int commodityId = Integer.parseInt(request.getParameter("commodity_id"));
		Commodity commodity = commodityService.getCommodityById(commodityId);
		CommodityInfo commodityInfo = commodityInfoService.getCommodityInfoByCommodityId(commodityId);
		session.setAttribute("commodity", commodity);
		session.setAttribute("commodityInfo", commodityInfo);
		response.sendRedirect("shop.jsp");
	}
	private void addComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 未登录时
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUserObj");
		if (currentUser == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		// 已登录，展示评论
		int commodityId = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		if(message!=null){
			boolean bo = commentService.addComment(commodityId, email, message);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	/**
	 * 展示所有商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Commodity> list = commodityService.queryAll();
		if(list!=null){
			request.setAttribute("allCommodity", list);
		}
	}
	/**
	 * 删除该商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean bo = commodityService.deleteCommodityById(id);
		queryAll(request,response);
	}
	/**
	 * 查询该商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Commodity> list = commodityService.queryCommodityById(id);
		if(list!=null){
			request.setAttribute("CommodityById", list);
		}
		
	}
	/**
	 * 更新该商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String introduce = request.getParameter("introduce");
		String img = request.getParameter("img");
		int ageStart = Integer.parseInt(request.getParameter("ageStart"));
		int ageEnd = Integer.parseInt(request.getParameter("ageEnd"));
		String timeLength = request.getParameter("timeLength");
		String applicableGender = request.getParameter("applicableGender");
		String applicableLocation = request.getParameter("applicableLocation");
		String signingForm = request.getParameter("signingForm");
		String liabilityZjs = request.getParameter("liabilityZjs");
		String detail1 = request.getParameter("detail1");
		String detail2 = request.getParameter("detail2");
		String detail3 = request.getParameter("detail3");
		String typeDetail = request.getParameter("typeDetail");
		int on = Integer.parseInt(request.getParameter("on"));
		boolean bo = commodityService.updateCommodityById(name, price, introduce, img, ageStart, ageEnd, timeLength, applicableGender, applicableLocation, signingForm, liabilityZjs, detail1, detail2, detail3, typeDetail,on, id);
		queryAll(request,response);
	}
	/**
	 * 搜索该商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryCommodityById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query");
		List<Commodity> list;
		if(query.equals("")){
			list = commodityService.queryAll();
			if(list!=null){
				request.setAttribute("allCommodity", list);
			}
		}else{
			int id = Integer.parseInt(query);
			list = commodityService.queryCommodityById(id);
			if(list!=null){
				request.setAttribute("allCommodity", list);
			}
		}
		if(list!=null){
			request.setAttribute("allCommodity", list);
		}
		request.getRequestDispatcher("background_commodity_query.jsp").forward(request, response);
	}
	/**
	 * 新增商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String introduce = request.getParameter("introduce");
		String img = request.getParameter("img");
		int ageStart = Integer.parseInt(request.getParameter("ageStart"));
		int ageEnd = Integer.parseInt(request.getParameter("ageEnd"));
		String timeLength = request.getParameter("timeLength");
		String applicableGender = request.getParameter("applicableGender");
		String applicableLocation = request.getParameter("applicableLocation");
		String signingForm = request.getParameter("signingForm");
		String liabilityZjs = request.getParameter("liabilityZjs");
		String detail1 = request.getParameter("detail1");
		String detail2 = request.getParameter("detail2");
		String detail3 = request.getParameter("detail3");
		String typeDetail = request.getParameter("typeDetail");
		int on = Integer.parseInt(request.getParameter("on"));
		boolean bo = commodityService.addCommodity(name, price, introduce, img, ageStart, ageEnd, timeLength, applicableGender, applicableLocation, signingForm, liabilityZjs, detail1, detail2, detail3, typeDetail, on);
		queryAll(request,response);
	}
}
