<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h1>자료실 등록</h1>
	<form action="DocumentInsertAction.do" method="post" enctype="multipart/form-data">
			제목: <input type="text" name="doc_title"><br>
			첨부파일: <input type="file" name="doc_file"><br>
			내용 <br>
				<textarea rows="10" cols="70" name="doc_content"></textarea>
				<br>
			<a href="DocumentListAction.do">자료실 목록으로 가기</a>
			<input type="submit" value="등록">
			<input type="reset" value="다시입력">
	</form>
	
	<%@ include file="footer.jsp" %>
</body>
</html>