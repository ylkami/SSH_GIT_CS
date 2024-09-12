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
	<form action="TypeServlet?opt=adding" method="post">
	<center>
	           新增类别信息                                    <input type="submit" value="确定">
		<table style="margin-top:20px" cellspacing="0" border="1px" width="500px">
			<tr>
				<td align="center">类别名称</td>
				<td align="center"><input type="text" name="type" id="type" ></td>
			</tr>
			<tr>
				<td align="center">是否上架</td>
				<td align="center"><input type="text" name="typeOn" id="typeOn"/></td>
			</tr>
		</table>
	</center>
	</form>
</body>
</html>