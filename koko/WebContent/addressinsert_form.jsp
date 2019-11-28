<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<a href="/koko/address/list.do">연락처 목록</a>
<h3>연락처 등록</h3>
<hr>
<form action="/koko/address/AddressInsertAction.do" method="post">

	이름 : <input type="text" name="ad_name"><br>
	이메일 : <input type="text" name="ad_email"><br>
	회사 : <input type="text" name="ad_company"><br>
	부서 : <input type="text" name="ad_department"><br>
	연락처 : <input type="text" name="ad_phonenumber"><br>
	<hr>


	<input type="submit" value="등록" >
</form>

</body>
</html>








