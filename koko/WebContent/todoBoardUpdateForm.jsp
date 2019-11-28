<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 수정</h2>
	<div id ="writeForm">
	<form action="todoBoardUpdateAction.do?b_seq=${b_seq }"
	method="post">
		<!-- board의 시퀀스 알아야 한다 -->
		<input type ="hidden" name = "m_id" value = "${login.m_id }">
		<input type ="hidden" name = "p_no" value = "${p_no }">

		제목: <input type="text" name="b_title">
		<textarea name = "b_contents" rows="20" cols="100"></textarea>
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
		<!-- 파일: <input type="file" name="bf_name" > -->
		<input type="submit" value="올리기">
	</form>
	</div>
</body>
</html>