<%@ page language="java" import="com.edu.seiryo.servlet.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Home</title>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="css/all.css">
  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="css/mdb.min.css" rel="stylesheet">
  <!-- Your custom styles (optional) -->
  <link href="css/style.min.css" rel="stylesheet">
  <style>

    .map-container{
overflow:hidden;
padding-bottom:56.25%;
position:relative;
height:0;
}
.map-container iframe{
left:0;
top:0;
height:100%;
width:100%;
position:absolute;
}
  </style>
</head>
<body>
<c:forEach var="user" items="${UserById }" varStatus="no">
	<form action="UserServlet?opt=updating&id=${user.id }" method="post">
	<center>
	           修改用户信息                                    <input type="submit" value="确定">
		<table style="margin-top:20px" cellspacing="0" border="1px" width="500px">
			<tr>
				<td align="center">用户序号</td>
				<td align="center"><c:out value="${user.id }"></c:out></td>
			</tr>
			<tr>
				<td align="center">用户邮箱</td>
				<td align="center"><input name="email" id="email" type="text" value="${user.email }"></td>
			</tr>
			<tr>
				<td align="center">用户密码</td>
				<td align="center"><input type="text" name="password" id="password" value="${user.password}"/></td>
			</tr>
			<tr>
				<td align="center">是否可以登录</td>
				<td align="center"><input type="text" name="status" id="status" value="${user.status}"/></td>
			</tr>
			</c:forEach>
			<c:forEach var="userInfo" items="${UserInfoById }" varStatus="no">
			<tr>
				<td align="center">用户电话</td>
				<td align="center"><input name="phone" id="phone" type="text" value="${userInfo.phone }"></td>
			</tr>
			<tr>
				<td align="center">用户余额</td>
				<td align="center"><input name="money" id="money" type="text" value="${userInfo.money }"></td>
			</tr>
			<tr>
				<td align="center">用户姓名</td>
				<td align="center"><input type="text" name="name" id="name" value="${userInfo.name}"/></td>
			</tr>
			<tr>
				<td align="center">用户生日</td>
				<td align="center"><input type="text" name="birthday" id="birthday" value="${userInfo.birthday}"/></td>
			</tr>
			<tr>
				<td align="center">用户性别</td>
				<td align="center"><input name="sex" id="sex" type="text" value="${userInfo.sex }"></td>
			</tr>
			</c:forEach>
		</table>
	</center>
	</form>
</body>
</html>