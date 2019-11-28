<%@page import="javax.websocket.Session"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>참여중인 프로젝트</h2>
	<%-- <p>${login.m_id }</p> --%>
		<!-- <a href="#">프로젝트1</a>
		<a href="#">프로젝트2</a> -->
		<!-- <input type = "submit" name = "project" value="프로젝트2"> -->
	<c:if test="${projectList != null }">
		<c:forEach var="project" items="${projectList }">
			<hr>
				<a href="/TodoBoard/main2/projectAction.do?p_no=${project.p_no }&m_id=${login.m_id }&p_name=${project.p_name }">${project.p_name }</a>
			<hr>
		</c:forEach>
	</c:if>
	<c:if test="${projectList == null }">
			<hr>
				참여중인 프로젝트가 없습니다.
			<hr>
	</c:if>
</body>
</html>