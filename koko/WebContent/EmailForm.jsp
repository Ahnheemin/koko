<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<form action="Senderlist.do" method="post">
		<input type="submit" value="보낸메일함">
	</form>
	
	<table width="600" border="2" cellpadding="0" cellspacing="0" bordercolor="#d6d4a6" align="center">
		<tr height="40">
			<td style="padding-left: 20px;"><b>E_mail 전송</b></td>
		</tr>
	</table>
	<br/><br/>
	<form action="/koko/email/emailinsertAction.do" method="post" enctype="multipart/form-data">
		<table width="600" border="0" cellpadding="3" cellspacing="0" align="center">
			<tr>
				<td colspan="2" height="3" bgcolor="#dbdbdb" align="center"></td>
			</tr>
			<tr>
				<td colspan="2" height="1" bgcolor="#dbdbdb" align="center"></td>
			</tr>
			
			<tr>
				<td colspan="2" height="1" bgcolor="#dbdbdb" align="center"></td>
			</tr>
			<tr>
				<td width="140" height="30" bgcolor="#eeeeee" style="padding-left: 20px;">받는 사람 E-Mail</td>
				<td width="460" style="padding-left: 10px;">
				<input type="text" name="e_receipt" size="35" maxlength="20" class="boxTF">
				</td>
			</tr>
			<tr>
				<td colspan="2" height="1" bgcolor="#dbdbdb" align="center"></td>
			</tr>
			<tr>
				<td width="140" height="30" bgcolor="#eeeeee" style="padding-left: 20px;">제목</td>
				<td width="460" style="padding-left: 10px;">
				<input type="text" name="e_title" size="64" maxlength="100" class="boxTF"></td>
			</tr>
			<tr>
				<td colspan="2" height="1" bgcolor="#dbdbdb" align="center"></td>
			</tr>
			<tr>
				<td width="140" height="30" bgcolor="#eeeeee" style="padding-left: 20px;">내용</td>
				<td width="460" style="padding-left: 10px;">
				<textarea rows="12" cols="62" name="e_contents" class="boxTA"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" height="1" bgcolor="#dbdbdb" align="center"></td>
			</tr>
			<tr>
				<td colspan="2" height="10"></td>
			</tr>
			<tr>
				<td colspan="2" height="1" bgcolor="#dbdbdb" align="center"></td>
			</tr>
			<tr>
				<td width="140" height="30" bgcolor="#eeeeee" style="padding-left: 20px;">첨부파일</td>
				<td width="460" style="padding-left: 10px;">
				<input type="file" name="e_file" maxlength="100" size="48" class="boxTF" /></td>
			</tr>
			<tr>
				<td colspan="2" height="3" bgcolor="#dbdbdb" align="center"></td>
			</tr>
		</table>
		<table width="600" border="0" cellpadding="3" cellspacing="0" align="center">
			<tr align="center">
				<td height="40">
				<input type="submit" name="submit" value="메일보내기">
				<input type="reset" value="다시입력">				
				</td>
			</tr>
		</table>
	</form>
	



<!-- 	<form action="/Komail/email/emailinsertAction.do" method="post"
		enctype="multipart/form-data">
		보내는 주소 : <input type="text" name="e_sender"><br> 받는 주소: <input
			type="text" name="e_receipt"><br> 메일 제목 : <input
			type="text" name="e_title"><br> 내용 입력 : <input
			type="file" name="e_file"> <br>
		<textarea rows="10" cols="100" name="e_contents"></textarea>
		<br> <input type="submit" name="submit" value="메일보내기">
	</form>

	<hr> -->


</body>
</html>