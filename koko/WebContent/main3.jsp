<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="css/boardCss.css"> -->
<style type="text/css">
	#board {
	border: 1px solid;
	width: 1000px;
	position: center;
	}
	
	#writeForm, #report {
	border: 1px solid;
	width: 1000px;
	}
	#b_contents{
    outline: 2px dashed #92b0b3 ;
    outline-offset:-10px;  
    text-align: center;
    transition: all .15s ease-in-out;
    width: 800px;
    height: 200px;
    background-color: gray;
}
	
</style>
<script src="/koko/js/jquery.js" type="text/javascript"></script>
<script src="/koko/js/jquery-1.10.2.min.js"></script>
<script src="/koko/js/jquery.ba-throttle-debounce.min.js"></script>
<script src="/koko/js/dragAndDrop.js" type="text/javascript"></script>
<script src="/koko/js/scroll.js" type="text/javascript"></script>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

<script type="text/javascript" src="/koko/js/chart.js"></script>


</head>
<body>
	<p>${p_name }</p>
	<h2>업무 리포트</h2>
	<div id="report">
		- 요청: ${b_request } - 피드백: ${b_feedback } - 진행: ${b_doing } - 완료: ${b_done } - 보류: ${b_issue }	
		<input type="hidden" id="b_request" value="${b_request }">
		<input type="hidden" id="b_feedback" value="${b_feedback }">
		<input type="hidden" id="b_doing" value="${b_doing }">
		<input type="hidden" id="b_done" value="${b_done }">
		<input type="hidden" id="b_issue" value="${b_issue }">
		
		<div id="work_piechart" style="width: 450px; height: 250px;"></div>
	</div>
	
	<h2>글 작성폼</h2>
	<div id ="writeForm">
	<form action="/koko/todoBoard/todoBoardInsertAction.do?p_no=${p_no }&m_id=${login.m_id }"
	method="post" enctype="multipart/form-data">
		<h4>작성자: ${login.m_name }</h4><br>
		<!-- board의 시퀀스 알아야 한다 -->

		제목: <input type="text" name="b_title" placeholder="제목"><br>
		<textarea name = "b_contents" rows="20" cols="100" placeholder="내용을 입력하세요."></textarea>
		<!-- <div id="b_contents" >DragZone</div> -->
		<br><br>
		공개범위: <select name ="b_scope">
			<option value = "all">전체공개</option>
			<option value = "admin">비공개</option>
		</select>
		글유형: <select name ="b_type">
			<option value = "b_request">요청</option>
			<option value = "b_feedback">피드백</option>
			<option value = "b_doing">진행중</option>
			<option value = "b_done">완료</option>
			<option value = "b_issue">보류</option>
		</select>
		파일: <input type="file" name="bf_name">
		<input type = "submit" name = "board" value="올리기">
	</form>
	</div>
		<c:forEach var="boardList" items="${todoBoardTotalList }">
			<div id="board">

			<c:choose>
				<c:when test="${boardList.b_scope == 'all' }">
				<ul>
					<li>제목: ${boardList.b_title }</li>
					<li>작성자: ${boardList.m_id }</li>
					<li>공개범위: ${boardList.b_scope }</li>
					<li>작성일자: ${boardList.b_lastUpdate }</li>
					<li>글유형: ${boardList.b_type }</li>
					<c:if test="${boardList.bf_name != null }">
					<li>파일: <a href="/koko/download.jsp?bf_name=${boardList.bf_name }">${boardList.bf_name }</a></li>
					</c:if>
					<li>내용: ${boardList.b_contents }</li>
					<c:if test="${boardList.m_id == login.m_id }">
						<a href="todoBoardUpdateFormAction.do?b_seq=${boardList.b_seq }&p_no=${p_no }&p_name=${p_name }">수정</a>
						<a href="todoBoardDeleteAction.do?b_seq=${boardList.b_seq }&p_no=${p_no }">삭제</a>
					</c:if>
					<hr>
					<div id="todoReply">
					<c:forEach var="replyList" items="${todoReplyList }">
						<c:if test="${replyList.b_seq == boardList.b_seq }">
							<hr>
							작성자: ${replyList.m_id } <br>
							내용: ${replyList.br_contents }
							<c:if test="${replyList.m_id == login.m_id }">
								<a href="todoReplyDeleteAction.do?br_seq=${replyList.br_seq }&p_no=${p_no }">삭제</a>
							</c:if>
						</c:if>
					</c:forEach>
					</div>
					<br>
					<!-- 댓글 입력 폼 -->
					<form action="todoReplyInsertAction.do?b_seq=${boardList.b_seq }&m_id=${login.m_id }&p_no=${p_no }&p_name=${p_name }" method="post">
						<textarea name = "br_contents" rows="3" cols="100" placeholder="댓글 내용을 입력하세요."></textarea>
						<input type="submit" value="올리기" id="replyInsert">
					</form>
				</ul>
				</c:when>
				<c:when test="${boardList.b_scope == 'admin' }">
					<c:if test="${boardList.m_id == login.m_id }">
						<ul>
							<li>제목: ${boardList.b_title }</li>
							<li>작성자: ${boardList.m_id }</li>
							<li>공개범위: ${boardList.b_scope }</li>
							<li>작성일자: ${boardList.b_lastUpdate }</li>
							<li>글유형: ${boardList.b_type }</li>
							<c:if test="${boardList.bf_name != null }">
							<li>파일: <a href="/koko/download.jsp?bf_name=${boardList.bf_name }">${boardList.bf_name }</a></li>
							</c:if>
							<li>내용: ${boardList.b_contents }</li>
							<c:if test="${boardList.m_id == login.m_id }">
								<a href="todoBoardUpdateFormAction.do?b_seq=${boardList.b_seq }&p_no=${p_no }&p_name=${p_name }">수정</a>
								<a href="todoBoardDeleteAction.do?b_seq=${boardList.b_seq }&p_no=${p_no }">삭제</a>
							</c:if>
							<hr>
							<div id="todoReply">
							<c:forEach var="replyList" items="${todoReplyList }">
								<c:if test="${replyList.b_seq == boardList.b_seq }">
									<hr>
									작성자: ${replyList.m_id } <br>
									내용: ${replyList.br_contents }
									<c:if test="${replyList.m_id == login.m_id }">
										<a href="todoReplyDeleteAction.do?br_seq=${replyList.br_seq }&p_no=${p_no }">삭제</a>
									</c:if>
								</c:if>
							</c:forEach>
							</div>
							<br>
							<!-- 댓글 입력 폼 -->
							<form action="todoReplyInsertAction.do?b_seq=${boardList.b_seq }&m_id=${login.m_id }&p_no=${p_no }&p_name=${p_name }" method="post">
								<textarea name = "br_contents" rows="3" cols="100" placeholder="댓글 내용을 입력하세요."></textarea>
								<input type="submit" value="올리기" id="replyInsert">
							</form>
						</ul>
					</c:if>
				</c:when>
			</c:choose>
			</div>
		</c:forEach>


</body>
</html>