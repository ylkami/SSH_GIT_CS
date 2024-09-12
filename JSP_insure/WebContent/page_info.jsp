<%@ page language="java" import="com.edu.seiryo.servlet.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<div id="context" class="context" style="height: auto;">
					<div id="context_text_1" style="height: 200px">
						<div id="context_text_info1" >
							<table id="context_text_info1_table">
								<tr>
									<td>
										<b>該当の人：</b>
										<span>
											${commodity.ageStart }~${commodity.ageEnd }歳&nbsp;&nbsp;
											<c:choose>
												<c:when test="${commodity.applicableGender == '0' }">男性</c:when>
												<c:when test="${commodity.applicableGender == '1' }">女性</c:when>
												<c:when test="${commodity.applicableGender == '2' }">男性と女性</c:when>
											</c:choose>
										</span>	
									</td>
									<td><b>保険期間：</b><span>${commodity.timeLength }</span></td>
								</tr>
								<tr>
									<td><b>販売範囲：</b><span>${commodity.applicableLocation }</span></td>
									<td><b>保証書形式：</b><span>${commodity.signingForm }</span></td>
								</tr>
								<tr>
									<td colspan="2"><b>保険責任：</b><span>${commodity.liabilityZjs }</span></td>
								</tr>
							</table>
						</div>
						<div id="context_text_info2">
							<div class="price1">
								<span class="fh1"><b>¥${commodity.price }</b></span>
								<span class="price_a1"><b></b></span>
								<span class="fh1"><b>/起</b></span>
							</div>
							<a href="CommodityServlet?opt=shop&commodity_id=${commodity.id }">
								<div class="img_a1">
									<b>ただちに保険をかける</b>
								</div>
							</a>
						</div>
					</div>
					<div id="context_text_2">
						<div>
							评论：<br>
							<c:forEach var="comment" items="${CommentById }" varStatus="no">
								${comment.email } 说： ${comment.message }<br>
							</c:forEach>
							<form method="post" action="CommodityServlet?opt=addComment&email=${currentUserObj.email }&id=${commodity.id}">
								<input type="text" name="message" id="message"><input type="submit" value="发布评论">
							</form>
						</div>
						<div id="context_text_2_1">
							<b>保険の詳細は次のとおりです：</b>
						</div>
						<div id="context_text_2_2">
							<img style="width: 100%;" alt="" src="${commodity.detail1 }">
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