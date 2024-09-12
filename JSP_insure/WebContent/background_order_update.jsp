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
<c:forEach var="order" items="${OrderById }" varStatus="no">
	<form action="OrderServlet?opt=updating&id=${order.id }" method="post">
	<center>
	           修改订单信息                                    <input type="submit" value="确定">
		<table style="margin-top:20px" cellspacing="0" border="1px" width="500px">
			<tr>
				<td align="center">订单编号</td>
				<td align="center"><c:out value="${order.id }"></c:out></td>
			</tr>
			<tr>
				<td align="center">用户编号</td>
				<td align="center"><input name="userId" id="userId" type="text" value="${order.userId }"></td>
			</tr>
			<tr>
				<td align="center">保险编号</td>
				<td align="center"><input type="text" name="commodityId" id="commodityId" value="${order.commodityId}"/></td>
			</tr>
			</c:forEach>
			<c:forEach var="orderInfo" items="${OrderInfoById }" varStatus="no">
			<tr>
				<td align="center">详细信息1</td>
				<td align="center"><input name="liability1" id="liability1" type="text" value="${orderInfo.liability1 }"></td>
			</tr>
			<tr>
				<td align="center">详细信息2</td>
				<td align="center"><input name="liability2" id="liability2" type="text" value="${orderInfo.liability2 }"></td>
			</tr>
			<tr>
				<td align="center">详细信息3</td>
				<td align="center"><input name="liability3" id="liability3" type="text" value="${orderInfo.liability3 }"></td>
			</tr>
			<tr>
				<td align="center">详细信息4</td>
				<td align="center"><input name="liability4" id="liability4" type="text" value="${orderInfo.liability4 }"></td>
			</tr>
			<tr>
				<td align="center">详细信息5</td>
				<td align="center"><input name="liability5" id="liability5" type="text" value="${orderInfo.liability5 }"></td>
			</tr>
			<tr>
				<td align="center">详细信息6</td>
				<td align="center"><input name="liability6" id="liability6" type="text" value="${orderInfo.liability6 }"></td>
			</tr>
			<tr>
				<td align="center">详细信息7</td>
				<td align="center"><input name="liability7" id="liability7" type="text" value="${orderInfo.liability7 }"></td>
			</tr>
			<tr>
				<td align="center">受益人姓名</td>
				<td align="center"><input name="beneficiaryName" id="beneficiaryName" type="text" value="${orderInfo.beneficiaryName }"></td>
			</tr>
			<tr>
				<td align="center">受益人地域</td>
				<td align="center"><input type="text" name="beneficiaryCity" id="beneficiaryCity" value="${orderInfo.beneficiaryCity }"/></td>
			</tr>
			<tr>
				<td align="center">受益人电话</td>
				<td align="center"><input type="text" name="beneficiaryPhone" id="beneficiaryPhone" value="${orderInfo.beneficiaryPhone}"/></td>
			</tr>
			<tr>
				<td align="center">起效时间</td>
				<td align="center"><input name="timeStart" id="timeStart" type="text" value="${orderInfo.timeStart }"></td>
			</tr>
			<tr>
				<td align="center">失效时间</td>
				<td align="center"><input type="text" name="timeEnd" id="timeEnd" value="${orderInfo.timeEnd}"/></td>
			</tr>
			<tr>
				<td align="center">有效时长</td>
				<td align="center"><input name="timeLength" id="timeLength" type="text" value="${orderInfo.timeLength }"></td>
			</tr>
			<tr>
				<td align="center">总金额</td>
				<td align="center"><input type="text" name="price" id="price" value="${orderInfo.price}"/></td>
			</tr>
			</c:forEach>
		</table>
	</center>
	</form>
</body>
</html>