<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function delete_event() {
		if(confirm("정말 삭제하시겠습니까?") == true) {
			document.form.submit();
		} else {
			return;
		}
	}
</script>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h1>자료실 글보기</h1>
	<a href="DocumentListAction.do">목록</a>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>첨부파일</td>
			<td>작성자</td>
			<td>내용</td>
		</tr>

		<tr>
			<td>${documentDO.doc_seq}</td>
			<td>${documentDO.doc_title}</td>
			<td><a href="/koko/download.jsp?filename=${documentDO.doc_file}">${documentDO.doc_file}</a></td>
			<td>${documentDO.m_id}</td>
			<td>${documentDO.doc_content}</td>
		</tr>
	</table>
	<a href="/koko/document/DocumentUpdateFormAction.do?doc_seq=${documentDO.doc_seq}">수정</a>
	<a href="/koko/document/DocumentDeleteAction.do?doc_seq=${documentDO.doc_seq}" onclick="delete_event()">삭제</a>
		
	<%@ include file="footer.jsp" %>
</body>
</html>