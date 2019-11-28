<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 업데이트 </title>
</head>
<body>
<form action="koko/address/updateAction.do">
<input type="hidden" value="${b.ad_seq }" name="ad_seq">
이름 : <input type="text" value="${b.ad_name }" name="ad_name"><br>
이메일 : <input type="text" value="${b.ad_email }" name="ad_email"><br>
회사 : <input type="text" value="${b.ad_company}" name="ad_company"><br>
부서 : <input type="text" value="${b.ad_department }" name="ad_department"><br>
연락처 : <input type="text" value="${b.ad_phonenumber }" name="ad_phonenumber"><br>
<br>
<input type="submit" value="확인">
</form>
<a href="list.do">뒤로</a>
</body>
</html>