<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="emaildeleteAction.do" method="post">
	<table border="1">
		<tr>			
			<td>체크</td>
			<td>글번호</td>
			<td>파일</td>
			<td>제목</td>
			<td>받는 주소</td>
			<td>작성일</td>
		</tr>
		<c:forEach var="email" items="${emaillistdo.getSlist()}">
			<tr>
				<td>
					<input type="checkbox" name="edelete" value="${email.getE_seq()}"/>
				</td>
				<td>${email.e_seq}</td>
				<td><c:if test="${email.e_file != null}">
						<c:set var="head" value="${fn:substring(email.e_file,
								0, fn:length(email.e_file)-4)}"></c:set>
						<c:set var="pattern" value="${fn:substring(email.e_file,
								fn:length(head) +1, fn:length(email.e_file))}"></c:set>
						
						<c:set var="filePath" value='./upload/${head}.${pattern}'></c:set>
						${head}
						</c:if></td>
				<td>${email.e_title}</td>
				<td>${email.e_receipt}</td>
				<td>${email.e_regdate}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<c:if test="${emaillistdo.startPage > 5}">
		<a href="Senderlist.do?pageNum=${emaillistdo.startPage -1 }">[이전]</a>
	</c:if>
	<c:forEach var="pageNo" begin="${emaillistdo.startPage }"
		end="${emaillistdo.endPage }">
		<c:if test="${emaillistdo.requestPage == pageNo }"><b>
		</c:if>
		<a href="Senderlist.do?pageNum=${pageNo }">[${pageNo }]</a>
		<c:if test="${emaillistdo.requestPage == pageNo }"></b>
		</c:if>
	</c:forEach>
	<c:if test="${emaillistdo.endPage < emaillistdo.totalPageCount }">
		<a href="Senderlist.do?pageNum=${emaillistdo.endPage +1 }">[이후]</a>
	</c:if>
	
		<input type="submit"value="삭제">
	</form>
	
	<form action="Senderlist.do" method="post">
		<input type="checkbox" name="area" value="e_title">메일 제목 
		<input type="checkbox" name="area" value="e_regdate">작성일
		<input type="text" name="searchKey" size="15"> 
		<input type="submit"value="검색">
	</form>
	<script type="text/javascript">
		alert(filePath);
	</script>
</body>
</html>