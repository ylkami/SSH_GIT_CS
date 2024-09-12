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
	<form action="CommodityServlet?opt=adding" method="post">
	<center>
	           新增保险信息                                    <input type="submit" value="确定">
		<table style="margin-top:20px" cellspacing="0" border="1px" width="500px">
			<tr>
				<td align="center">商品名称</td>
				<td align="center"><input name="name" id="name" type="text" ></td>
			</tr>
			<tr>
				<td align="center">商品价格</td>
				<td align="center"><input type="text" name="price" id="price" ></td>
			</tr>
			<tr>
				<td align="center">商品介绍</td>
				<td align="center"><input type="text" name="introduce" id="introduce"/></td>
			</tr>
			<tr>
				<td align="center">商品照片</td>
				<td align="center"><input type="text" name="img" id="img" /></td>
			</tr>
			<tr>
				<td align="center">适用年龄（始）</td>
				<td align="center"><input type="text" name="ageStart" id="ageStart"/></td>
			</tr>
			<tr>
				<td align="center">适用年龄（终）</td>
				<td align="center"><input type="text" name="ageEnd" id="ageEnd" /></td>
			</tr>
			<tr>
				<td align="center">有效时长</td>
				<td align="center"><input type="text" name="timeLength" id="timeLength" /></td>
			</tr>
			<tr>
				<td align="center">适用性别</td>
				<td align="center"><input type="text" name="applicableGender" id="applicableGender" /></td>
			</tr>
			<tr>
				<td align="center">适用范围</td>
				<td align="center"><input type="text" name="applicableLocation" id="applicableLocation" /></td>
			</tr>
			<tr>
				<td align="center">签署形式</td>
				<td align="center"><input type="text" name="signingForm" id="signingForm" /></td>
			</tr>
			<tr>
				<td align="center">保险责任</td>
				<td align="center"><input type="text" name="liabilityZjs" id="liabilityZjs"/></td>
			</tr>
			<tr>
				<td align="center">详细信息1</td>
				<td align="center"><input type="text" name="detail1" id="detail1" /></td>
			</tr>
			<tr>
				<td align="center">详细信息2</td>
				<td align="center"><input type="text" name="detail2" id="detail2" /></td>
			</tr>
			<tr>
				<td align="center">详细信息3</td>
				<td align="center"><input type="text" name="detail3" id="detail3" /></td>
			</tr>
			<tr>
				<td align="center">商品类型</td>
				<td align="center"><input type="text" name="typeDetail" id="typeDetail" /></td>
			</tr>
			<tr>
				<td align="center">是否上架</td>
				<td align="center"><input type="text" name="on" id="on" /></td>
			</tr>
		</table>
	</center>
	</form>
</body>
</html>