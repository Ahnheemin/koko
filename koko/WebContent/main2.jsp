<%@page import="javax.websocket.Session"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>참여중인 프로젝트</h2>
	<%-- <p>${login.m_id }</p> --%>
	<form action="projectAction.do" method="post" >	
		<input type = "submit" name = "project" value="프로젝트1">
	</form>
</body>
</html>