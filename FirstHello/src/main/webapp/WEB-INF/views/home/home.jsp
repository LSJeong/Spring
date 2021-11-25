<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>Welcome To My web Site</h1></div>
	
	<form id="frm" action="memberLogin.do" method="post">
		<div align="center">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><input type="text" id="id" name="id"></td>					
				</tr>
				<tr>
					<th>password</th>
					<td><input type="password" id="password" name="password"></td>
				</tr>
			</table>		
		</div><br>
		<div>
			<input type="submit" value="로그인">
			<input type="reset" value="취 소">
		</div>
	</form>
	
	
	<br>
	<div><a href="memberList.do">Member List</a></div>
</div>
</body>
</html>