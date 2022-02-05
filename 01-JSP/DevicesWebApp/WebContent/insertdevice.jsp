<%@page import="com.talha.app.deviceswebapp.jsp.DevicesWebAppJSP"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form id="" method="post" action="">
		<div>Name <input type="text" name="name" placeholder="isim giriniz"   /> </div>
		<div>Host <input type="text" name="host" placeholder="ip giriniz"/></div>
		<div> <input type="submit" value="kaydet" ></div>
	</form>
		<%
			DevicesWebAppJSP.insertDevice(request, out);
		%>
	
</body>
</html>