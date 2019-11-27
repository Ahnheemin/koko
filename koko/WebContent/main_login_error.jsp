<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
		alert("ID/비밀번호 입력 오류");
</script>
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="loginAction.do" method="post" >
		<input type = "text" name = "m_id"><br>
		<input type = "text" name = "m_password"><br><br>
		<input type = "submit" name = "login" value="로그인">
	</form>
</body>
</html>