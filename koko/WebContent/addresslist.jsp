<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="/ADDRESS/jquery.js" type="text/javascript"></script>
<script src="/ADDRESS/addresslist.js" type="text/javascript"></script>

</head>
<body>
<a href="insert_form.do">주소록 등록</a>

	<form method="post">
	<select>
	 <option value="">이름</option>
	 <option value="">회사</option>
	</select>
	


	<table style="text-align:center" id="example-table-1" width = "100%" border="1" class="table table-bordered table-hover text-center">
		<thead>
		<tr>
			<th><input type="checkbox" name="check_all" id="th_checkAll" onclick="checkAll();"/></th>
			<th>글번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>회사</th>
			<th>부서</th>
			<th>연락처</th>
		</tr>
		</thead>
		
		<tbody>    
		<c:forEach var = "list" items="${li.list }">
			<tr>
			<td><input type = "checkbox" name= "check" value= "${list.ad_seq }" class="ab"></td> 
			<td>${list.ad_seq }</td>
			<td>${list.ad_name }</td>
			<td>${list.ad_email }</td>
			<td>${list.ad_company }</td>
			<td>${list.ad_department }</td>
			<td>${list.ad_phonenumber }</td>
		</tr>
		</c:forEach>
		
		</tbody>		
	</table>
		
		<input type="submit" value="삭제" formaction="delete.do">
		<input type="submit" value="수정" formaction="select.do">
		<input type= "checkbox" name = "area" value="ad_name">이름
		<input type= "checkbox" name = "area" value="ad_phonenumber">연락처
		<input type="text" placeholder="연락처 검색" name="searchkey" size="10"/>
		<input type="submit" value="검색" formaction = "list.do">
		
	</form>
	
	
	<!-- 페이지 처리 영역 -->
	<!-- 이전 (현재페이지가 6페이지부터는 이전이 나와야한다) 이전 누르면 현재페이지가 5페이지 되게끔한다-->
	<c:if test="${li.startPage > 5 }">
	<a href = "list.do?pageNum=${li.startPage - 1 }"> [이전] </a>
	</c:if>
	
	<!--페이지 목록-->
	<c:forEach var = "pageNo" begin ="${li.startPage }"
	end = "${li.endPage }">
	<!-- 현재 누른 페이지 진하게 -->
	<c:if test="${li.requestPage == pageNo }"><b></c:if>
	<a href = "list.do?pageNum=${pageNo}"> [${pageNo }] </a>
	<c:if test="${li.requestPage == pageNo }"></b></c:if>
	</c:forEach>
	
	<!-- 이후 endpage보다 total페이지가 많다면 이후로 갈 페이지가 있다는것!-->
	<c:if test="${li.endPage < li.totalPageCount }">
	<a href = "list.do?pageNum=${li.endPage + 1 }"> [이후] </a> <!-- +1 헤서 다음 페이지로 가게끔 한다. -->
	</c:if>
	
		<!-- <button onclick="window.open('addressindex.html','window_name','width=430,height=500,location=no,status=no,scrollbars=yes');">button</button> -->
</body>
</html>