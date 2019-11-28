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
	<%@ include file="header.jsp"%>
	<h1>자료실 - 수정</h1>
	<form action="/koko/document/DocumentUpdateAction.do" method="post">
		<input type="hidden" name="doc_seq" value="${doc_seq}">
		제목: <input type="text" name="doc_title" value="${u.doc_title}"><br>
		첨부파일: <input type="file" name="doc_file" value="${u.doc_file}"><br>
		내용<br>
			<textarea rows="10" cols="70" name="doc_content">${u.doc_content}</textarea>
			<br>
			<a href="DocumentListAction.do">자료실 목록으로 가기</a>
			<input type="submit" value="수정완료">
			<input type="reset" value="다시입력">
	</form>
	
	<%@ include file="footer.jsp"%>
</body>
</html>