<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<h1>자료실 목록</h1>
	<a href="DocumentInsertFormAction.do">글쓰기</a>
	<a href="DocumentListAction.do">목록</a>
	
	<table border="1" width="100%" style="text-align:center">
		<tr>
			<th>글번호</th>
			<th>이미지</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
		
		<c:forEach var="documentDO" items="${listModelDO.list}">
			<tr>
			<td>${documentDO.doc_seq}</td>
			<td>
               <c:if test="${documentDO.doc_file != null }">
                  <c:set var="head" value="${fn:substring(documentDO.doc_file, 0, fn:length(documentDO.doc_file)-4) }"></c:set>
                  <c:set var="pattern" value="${fn:substring(documentDO.doc_file, fn:length(head) +1, fn:length(documentDO.doc_file)) }"></c:set>
               
                  <c:choose>
                     <c:when test="${pattern == 'jpg' || pattern == 'gif' }">
                        <a href="/koko/download.jsp?filename=${documentDO.doc_file}"><img src="/koko/upload/${head }_small.${pattern}"></a>
                     </c:when>
                     <c:otherwise>
                        <c:out value="NO IMAGE"></c:out>
                     </c:otherwise>
                  </c:choose>
               </c:if>
         </td>
			<td><a href="/koko/document/DocumentDetailAction.do?doc_seq=${documentDO.doc_seq}">${documentDO.doc_title}</a></td>
			<td>${documentDO.m_id}</td>
			<td>${documentDO.doc_regdate}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br><br>
	
	<!-- 페이지처리 영역 -->
	<!-- 이전  -->
	<c:if test="${listModelDO.startPage>5 }">
		<a href="DocumentListAction.do?PageNum=${listModelDO.startPage -1}">[이전]</a>
	</c:if>
	
	<!-- 페이지 목록 -->
	<c:forEach var="pageNo" begin="${listModelDO.startPage}" end="${listModelDO.endPage }">
	<c:if test="${listModelDO.requestPage == pageNo }"><b></c:if>
		<a href="DocumentListAction.do?pageNum=${pageNo}">[${pageNo }]</a>
	<c:if test="${listModelDO.requestPage == pageNo }"></b></c:if>
	</c:forEach>
	
	<!-- 이후  -->
	<c:if test="${listModelDO.endPage < listModelDO.totalPageCount }">
		<a href="DocumentListAction.do?pageNum=${listModelDO.endPage +1 }">[이후]</a>
	</c:if>
	
	
	<form action="DocumentListAction.do" method="post">
		<input type="checkbox" name="area" value="doc_title">제목
		<input type="checkbox" name="area" value="m_id">작성자
		<input type="text" name="searchKey" size="10" />
		<input type="submit" value="검색">
	</form>
	
		
	<%@ include file="footer.jsp" %>
</body>
</html>