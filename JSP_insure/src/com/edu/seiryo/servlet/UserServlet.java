package com.edu.seiryo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.seiryo.entity.Type;
import com.edu.seiryo.entity.User;
import com.edu.seiryo.entity.UserInfo;
import com.edu.seiryo.service.UserInfoService;
import com.edu.seiryo.service.UserService;
import com.edu.seiryo.service.imp.UserInfoServiceImp;
import com.edu.seiryo.service.imp.UserServiceImp;

/**
 * Servlet implementation class UserServlet
 */
/**
 * �û���Ϣ����ƽ̨
 * @author GuoYuanZhao
 * @date 2024��6��6��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.servlet
 * @file_name UserServlet.java
 * @classname UserServlet
 * @version 1.0
 */
public class UserServlet extends HttpServlet {
	private UserService userService = new UserServiceImp();
	private UserInfoService userInfoService = new UserInfoServiceImp();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		request.setAttribute("msg", null);
		String flag = request.getParameter("flag");
		if("_login".equals(flag)){
			login(request,response);
		}else if("_regist".equals(flag)){
			regist(request,response);
		}else if("_update".equals(flag)){
			update(request,response);
		}
		String opt = request.getParameter("opt");
		if("queryAll".equals(opt)){
			queryAll(request,response);
		}
		if("queryById".equals(opt)){
			queryUserById(request,response);
			request.getRequestDispatcher("background_user_query.jsp").forward(request, response);
		}
		if("delete".equals(opt)){
			delete(request,response);
			request.getRequestDispatcher("background_user.jsp").forward(request, response);
		}
		if("update".equals(opt)){
			queryById(request,response);
			queryInfoById(request,response);
			request.getRequestDispatcher("background_user_update.jsp").forward(request, response);
		}
		if("updating".equals(opt)){
			updateUser(request,response);
			updateUserInfo(request,response);
			request.getRequestDispatcher("background_user.jsp").forward(request, response);
		}
		if("add".equals(opt)){
			response.sendRedirect("regist.jsp");
		}
	}
	//��¼
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		if(!userService.ifPasswordCorrect(email, password)) {
			// �������
			String msg = "<font color='red'>�ѥ���`�ɡ��ߥ���</font>";
			out.println(msg);
			out.flush();
			out.close();
			return;
		}
		User user = userService.getUserByEmail(email);
		int userId = user.getId();
		UserInfo userInfo = userInfoService.getUserInfoByUserId(userId);
		HttpSession session = request.getSession();
		session.setAttribute("currentUserObj", user);
		session.setAttribute("currentUserInfoObj", userInfo);
		String msg = "<font color='green'>���󥰳ɹ���</font>";
		out.println(msg);
		out.flush();
		out.close();
	}
	//ע��
	public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		if (userService.ifEmailExist(email)) {
			// �����ظ�ע��
			String msg = "<font color='red'>��`��ܥå����Ϥ⤦���h����ޤ�����</font>";
			out.println(msg);
			out.flush();
			out.close();
			return;
		}
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		if (userInfoService.ifPhoneExist(phone)) {
			// �����ظ�ע��
			String msg = "<font color='red'>�Ԓ���ŤϤ⤦���h����ޤ�����</font>";
			out.println(msg);
			out.flush();
			out.close();
			return;
		}
		String money = "0";
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		int status = 1;

		// �ȴ洢User���󲢻�ȡ���ɵ�userId
		int userId = userService.userRegister(email, password);
		if (userId == -1) {
			// user�����쳣
			String msg = "<font color='red'>���`��k��</font>";
			out.println(msg);
			out.flush();
			out.close();
			return;
		}
		// �洢UserInfo����
		if (!userInfoService.userInfoRegister(userId, phone, money, name, birthday, sex, status)) {
			// userInfo�����쳣
			String msg = "<font color='red'>��Ҏ���hʧ��</font>";
			out.println(msg);
			out.flush();
			out.close();
			return;
		}
		// ��֤ͨ��

		String msg = "<font color='green'>��Ҏ���h�ɹ���</font>";
		out.println(msg);
		out.flush();
		out.close();
	}
	//�����û���Ϣ
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentUserObj");
		int userId = user.getId();
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		double charge = Double.parseDouble(request.getParameter("charge"));
		String msg = "";
		//�޸�����
		if(userService.changePasswordById(password, userId)) {
			msg += "�ѥ���`�ɸ��£�\n";
		}
		if(userInfoService.changePhoneByUserId(userId, phone)) {
			msg += "�Ԓ���Ÿ��£�\n";
		}
		
		//��ֵ
		if(charge >= 0) {
			userInfoService.changeMoneyByUserId(userId, charge);
			msg += "����`������";
		} else {
			msg += "���~���������������Ƥ�������";
		}
		//����session
		String email = user.getEmail();
		user = userService.getUserByEmail(email);
		UserInfo userInfo = userInfoService.getUserInfoByUserId(userId);
		session.setAttribute("currentUserObj", user);
		session.setAttribute("currentUserInfoObj", userInfo);
		out.print(msg);
		out.flush();
		out.close();
	}
	/**
	 * ��ѯ�����û�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list = userService.queryAll();
		if(list!=null){
			request.setAttribute("allUser", list);
		}
	}
	/**
	 * ɾ�����û�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		userInfoService.delete(userId);
		boolean bo = userService.delete(userId);
		queryAll(request,response);
	}
	/**
	 * �������û�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		List<User> list = userService.queryById(userId);
		if(list!=null){
			request.setAttribute("UserById", list);
		}
	}
	/**
	 * ��ѯ���û���ϸ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryInfoById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		List<UserInfo> list = userInfoService.queryById(userId);
		if(list!=null){
			request.setAttribute("UserInfoById", list);
		}
	}
	/**
	 * ���¸��û�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int userId = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int status = Integer.parseInt(request.getParameter("status"));
		boolean bo = userService.update(email, password,status, userId);
		queryAll(request,response);
	}
	/**
	 * ���¸��û���ϸ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int userId = Integer.parseInt(request.getParameter("id"));
		String phone = request.getParameter("phone");
		String money = request.getParameter("money");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		int status = Integer.parseInt(request.getParameter("status"));
		boolean bo = userInfoService.update(phone, money, name, birthday, sex, status, userId);
		queryAll(request,response);
	}
	/**
	 * �������û�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryUserById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query");
		List<User> list;
		if(query.equals("")){
			list = userService.queryAll();
			if(list!=null){
				request.setAttribute("allUser", list);
			}
		}else{
			int userId = Integer.parseInt(query);
			list = userService.queryById(userId);
			if(list!=null){
				request.setAttribute("allUser", list);
			}
		}
		if(list!=null){
			request.setAttribute("allUser", list);
		}
	}
}
