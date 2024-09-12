<%@ page language="java" import="com.edu.seiryo.servlet.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>健康保険のホームページ</title>
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<link rel="stylesheet" href="https://at.alicdn.com/t/c/font_3881267_wfv3iyzbijg.css">
		<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
		<script type="text/javascript" src="js/banner.js"></script>
	</head>
	<body>
		<div align="center" id="div_all">
			<div id="top1">
				<div id="top1_text">
					<div id="top1_text1">こんにちは、健康保険モールへようこそ</div>
					<div id="top1_text2">
						<span id="span1">最新情報：</span>
						<marquee id="lb" direction="left">
							ログインしてサインするとプレゼントがあります
						</marquee>
						<c:if test="${empty currentUserInfoObj}" var="ifLogin">
							<a href="login.jsp">
								<button type="button" id="userlogin">login/regist</button>
							</a>
							<input type="hidden" id="ifLogin" value="0">
						</c:if>
						<c:if test="${!ifLogin }">
							<a href="my_info.jsp">
								<button type="button" id="userlogin">${currentUserInfoObj.name }${currentUserInfoObj.sex }、こんにちは！</button>
							</a>
							<input type="hidden" id="ifLogin" value="1">
						</c:if>
					</div>
				</div>
			</div>
			<div id="top2">
			<%
				TypeServlet servlet = new TypeServlet();
				servlet.queryAllOn(request, response);
			%>
				<div id="top2_text">
					<ul id="top2_text_ul">
						<li id="li1"><a id="a0" href=""><b>すべての保険</b></a></li>
						<li id="li2"><b>${type1 }</b></li>
						<li id="li3"><b>${type2 }</b></li>
						<li id="li4"><b>${type3 }</b></li>
						<li id="li5"><b>${type4 }</b></li>
						<li id="li6"><b>${type5 }</b></li>
					</ul>
				</div>
			</div>
			<div id="context_all2">
				<div id="banner_img">
					<div id="banner_img_text">
					    <img src="images/my_img.jpg" width="100%" />
					</div>
				</div>
				<div id="context" class="context" style="height: auto;">
					<div id="context_text_1" style="height: 70px;">
						<a href="my_info.jsp"><div id="myinfo" ><b>マイメッセージ</b></div></a>
						<a href=""><div id="myorder" style="background-color:#FF7F50;color: white;"><b>私の注文</b></div></a>
					</div>
					<div id="context_text_2">
						<div id="context_text_2_1">
							<b>こんにちは、ご注文情報は以下の通りです！</b>
							<table id="table_orderinfo">
								<tr>
									<th>オーダー番号</th>
									<th>オーダー名</th>
									<th>注文価格</th>
									<th>保険加入者</th>
									<th>保証人</th>
									<th>開始時間</th>
									<th>終了時間</th>
									<th>保険加入期間</th>
								</tr>
								<c:forEach var="myOrder" items="${myOrderList }">
									<tr>
										<td>${myOrder.orderId }</td>
										<td>${myOrder.commodityName}</td>
										<td>${myOrder.commodityPrice }</td>
										<td>${myOrder.userName }</td>
										<td>${myOrder.beneficiaryName }</td>
										<td>${myOrder.timeStart }</td>
										<td>${myOrder.timeEnd }</td>
										<td>${myOrder.timeLength }年間</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
				<div id="foot">
					<h5 class="h51">カスタマーサービスホットライン：888-888-8888 （9:00~21:00）</h5>
					<h5 class="h52">○○健康保険株式会社 027-666666 &nbsp;&nbsp; ICP認証：UP9999999 &nbsp;&nbsp; Copyright © 2023 All Rights Reserved</h5>
				</div>
			</div>
		</div>
	</body>
</html>