<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>멤버 리스트</h1></div>
	
	<c:forEach items="${members }" var="member">
		${member.id } : ${member.name } : ${member.tel } : ${member.address } <br>
	</c:forEach>
	<br>
	<button type="button" onclick="location.href='noticeList.do'">공지사항 목록</button>
</div>
</body>
</html>