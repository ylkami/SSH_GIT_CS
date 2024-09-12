package com.edu.seiryo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.seiryo.entity.Commodity;
import com.edu.seiryo.entity.CommodityInfo;
import com.edu.seiryo.entity.MyOrder;
import com.edu.seiryo.entity.Order;
import com.edu.seiryo.entity.OrderInfo;
import com.edu.seiryo.entity.Type;
import com.edu.seiryo.entity.User;
import com.edu.seiryo.entity.UserInfo;
import com.edu.seiryo.service.MyOrderService;
import com.edu.seiryo.service.OrderInfoService;
import com.edu.seiryo.service.OrderService;
import com.edu.seiryo.service.UserInfoService;
import com.edu.seiryo.service.imp.MyOrderServiceImp;
import com.edu.seiryo.service.imp.OrderInfoServiceImp;
import com.edu.seiryo.service.imp.OrderServiceImp;
import com.edu.seiryo.service.imp.UserInfoServiceImp;

/**
 * Servlet implementation class OrderServlet
 */
/**
 * ��������ƽ̨
 * @author GuoYuanZhao
 * @date 2024��6��6��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.servlet
 * @file_name OrderServlet.java
 * @classname OrderServlet
 * @version 1.0
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService userInfoService = new UserInfoServiceImp();
	private OrderService orderService = new OrderServiceImp();
	private OrderInfoService orderInfoService = new OrderInfoServiceImp();
	private MyOrderService myOrderService = new MyOrderServiceImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String opt = request.getParameter("opt");
		if ("name".equals(opt)) {
			nameCheck(request, response);
		}
		if ("orderCheck".equals(opt)) {
			orderCheck(request, response);
		}
		if("showMyOrder".equals(opt)) {
			showMyOrder(request,response);
		}
		if("queryAll".equals(opt)){
			queryAll(request,response);
		}
		if("queryById".equals(opt)){
			queryOrderById(request,response);
			request.getRequestDispatcher("background_order_query.jsp").forward(request, response);
		}
		if("delete".equals(opt)){
			delete(request,response);
			request.getRequestDispatcher("background_order.jsp").forward(request, response);
		}
		if("update".equals(opt)){
			queryById(request,response);
			queryInfoById(request,response);
			request.getRequestDispatcher("background_order_update.jsp").forward(request, response);
		}
		if("updating".equals(opt)){
			updateOrder(request,response);
			updateOrderInfo(request,response);
			request.getRequestDispatcher("background_order.jsp").forward(request, response);
		}
	}
	// �ж������Ƿ�ע��
	private void nameCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		if (!userInfoService.ifNameExist(name)) {
			// ����δ��ע��
			out.print("<font color='red'>��ǰ�Ϥޤ����h����Ƥ��ޤ���</font>");
			out.flush();
			out.close();
			return;
		}
		// ��������
		out.print("<font color='green'>��ǰ��ʹ���ޤ�</font>");
		out.flush();
		out.close();
		return;
	}
	// ��֤��������
	private void orderCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Commodity commodity = (Commodity) session.getAttribute("commodity");
		CommodityInfo commodityInfo = (CommodityInfo) session.getAttribute("commodityInfo");
		//����Order��Ҫ������
		String applicantName = request.getParameter("applicantName");
		int commodityId = commodity.getId();
		String orderId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		//����OrderInfo��Ҫ������
		double totalPrice = Double.parseDouble(commodity.getPrice());
		String liability1 = request.getParameter("liability1");
		totalPrice += Double.parseDouble(liability1);
		if("0".equals(liability1)) {
			liability1 = "��ꓤ˼��뤷�ʤ�";
		} else {
			liability1 += "���";
		}
		String liability2 = request.getParameter("liability2");
		totalPrice += Double.parseDouble(liability2);
		if("0".equals(liability2)) {
			liability2 = "��ꓤ˼��뤷�ʤ�";
		} else {
			liability2 += "���";
		}
		String liability3 = request.getParameter("liability3");
		totalPrice += Double.parseDouble(liability3);
		if("0".equals(liability3)) {
			liability3 = "��ꓤ˼��뤷�ʤ�";
		} else {
			liability3 += "���";
		}
		String liability4 = request.getParameter("liability4");
		totalPrice += Double.parseDouble(liability4);
		if("0".equals(liability4)) {
			liability4 = "��ꓤ˼��뤷�ʤ�";
		} else {
			liability4 += "���";
		}
		String liability5 = request.getParameter("liability5");
		totalPrice += Double.parseDouble(liability5);
		if("0".equals(liability5)) {
			liability5 = "��ꓤ˼��뤷�ʤ�";
		} else {
			liability5 += "���";
		}
		String liability6 = request.getParameter("liability6");
		totalPrice += Double.parseDouble(liability6);
		if("0".equals(liability6)) {
			liability6 = "��ꓤ˼��뤷�ʤ�";
		} else {
			liability6 += "���";
		}
		String liability7 = request.getParameter("liability7");
		totalPrice += Double.parseDouble(liability7);
		if("0".equals(liability7)) {
			liability7 = "��ꓤ˼��뤷�ʤ�";
		} else {
			liability7 += "���";
		}
		
		String beneficiaruName = request.getParameter("beneficiaryName");
		String location = request.getParameter("location");
		String phone = request.getParameter("phone");
		int timeLength = Integer.parseInt(request.getParameter("timeLength"));
		
		//������������䡢�Ա𡢵����Ƿ���ϱ���Ҫ��
		//����
		int ageStart = commodity.getAgeStart();
		int ageEnd = commodity.getAgeEnd();
		int age = userInfoService.getAgeByName(beneficiaruName);
		if(age < ageStart || age > ageEnd) {
			out.print("<font color='red'>���h�Τ������I���ޤ���</font>");
			out.flush();
			out.close();
			return;
		}
		//�Ա�
		UserInfo userInfo = userInfoService.getUserInfoByName(beneficiaruName);
		String commodityGende = commodity.getApplicableGender();
		String sex = userInfo.getSex();
		switch(sex) {
		case "����":
			sex = "0";
			break;
		case "Ůʿ":
			sex = "1";
			break;
		}
		if(!"2".equals(commodityGende)) {
			if(!sex.equals(commodityGende)) {
				out.print("<font color='red'>�Ԅe�Τ������I���ޤ���</font>");
				out.flush();
				out.close();
				return;
			}
		}
		//����
		String commodityLocation = commodity.getApplicableLocation();
		if(!commodityLocation.contains(location)) {
			out.print("<font color='red'>����Τ������I���ޤ���</font>");
			out.flush();
			out.close();
			return;
		}
		
		//����Ƿ��㹻
		UserInfo applicantInfo = userInfoService.getUserInfoByName(applicantName);
		double money = Double.parseDouble(applicantInfo.getMoney());
		if(money < totalPrice) {
			out.print("<font color='yellow'>�и߲���</font>");
			out.flush();
			out.close();
			return;
		}
		
		//�����գ����ɶ���
		//����Order
		int userId = applicantInfo.getUserId();
		Order order = new Order(orderId, userId, commodityId);
		
		//��Ӷ�����ϸ��Ϣ
		String timeStart = new SimpleDateFormat("yyyy").format(new Date());
		String timeEnd = (Integer.parseInt(timeStart) + timeLength) + "";
		OrderInfo orderInfo = new OrderInfo(orderId, liability1, liability2, liability3, liability4, liability5, liability6, liability7, beneficiaruName, location, phone, timeStart, timeEnd, timeLength + "", totalPrice + "");
		
		//�������������ݿ�
		if(orderService.safeOrder(order) && orderInfoService.saveOrderInfo(orderInfo)) {
			//�ۿ�
			userInfoService.changeMoneyByUserId(userId, -totalPrice);
			out.print("<font color='green'>�Q�g�ɹ���</font>");
			UserInfo userInfo2 = userInfoService.getUserInfoByUserId(userId);
			session.setAttribute("currentUserInfoObj", userInfo2);
			out.flush();
			out.close();
			return;
		} else {
			out.print("<font color='red'>����`���𤭤ޤ�����</font>");
			out.flush();
			out.close();
			return;
		}
		
		
	}
	//�鿴�ҵĶ���
	private void showMyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = ((User) session.getAttribute("currentUserObj")).getId();
		List<MyOrder> list = myOrderService.getByUserIdSort(userId);
		request.setAttribute("myOrderList", list);
		request.getRequestDispatcher("my_order.jsp").forward(request, response);
	}
	/**
	 * ��ѯ�ö���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> list = orderService.queryAll();
		if(list!=null){
			request.setAttribute("allOrder", list);
		}
	}
	/**
	 * ɾ���ö���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("id");
		orderInfoService.deleteOrderInfo(orderId);
		boolean bo = orderService.deleteOrder(orderId);
		queryAll(request,response);
	}
	/**
	 * �����ö���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("id");
		List<Order> list = orderService.queryOrderById(orderId);
		if(list!=null){
			request.setAttribute("OrderById", list);
		}
	}
	/**
	 * �����ö�����ϸ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryInfoById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("id");
		List<OrderInfo> list = orderInfoService.queryOrderInfoById(orderId);
		if(list!=null){
			request.setAttribute("OrderInfoById", list);
		}
	}
	/**
	 * ���¸ö�����Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String orderId = request.getParameter("id");
		int userId = Integer.parseInt(request.getParameter("userId"));
		int commodityId = Integer.parseInt(request.getParameter("commodityId"));
		boolean bo = orderService.updateOrder(userId, commodityId, orderId);
		queryAll(request,response);
	}
	/**
	 * ���¸ö�����ϸ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateOrderInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String liability1 = request.getParameter("liability1");
		String liability2 = request.getParameter("liability2");
		String liability3 = request.getParameter("liability3");
		String liability4 = request.getParameter("liability4");
		String liability5 = request.getParameter("liability5");
		String liability6 = request.getParameter("liability6");
		String liability7 = request.getParameter("liability7");
		String beneficiaryName = request.getParameter("beneficiaryName");
		String beneficiaryCity = request.getParameter("beneficiaryCity");
		String beneficiaryPhone = request.getParameter("beneficiaryPhone");
		String timeStart = request.getParameter("timeStart");
		String timeEnd = request.getParameter("timeEnd");
		String timeLength = request.getParameter("timeLength");
		String price = request.getParameter("price");
		String orderId = request.getParameter("id");
		boolean bo = orderInfoService.updateOrderInfo(liability1, liability2, liability3, liability4, liability5, liability6, liability7, beneficiaryName, beneficiaryCity, beneficiaryPhone, timeStart, timeEnd, timeLength, price, orderId);
		queryAll(request,response);
	}
	/**
	 * ��ѯ�ö���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryOrderById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query");
		List<Order> list;
		if(query.equals("")){
			list = orderService.queryAll();
			if(list!=null){
				request.setAttribute("allOrder", list);
			}
		}else{
			String orderId = query;
			list = orderService.queryOrderById(orderId);
			if(list!=null){
				request.setAttribute("allOrder", list);
			}
		}
		if(list!=null){
			request.setAttribute("allOrder", list);
		}
	}
}
