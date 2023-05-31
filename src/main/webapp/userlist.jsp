<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, tr, th, td{
		border: 1px solid black;
	}
	td{
		text-align:center;
	}
	th{
	 background-color: #c7d3ef;
	 color:white;
	}
</style>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body bgcolor="#ffffff" align="center">
<div id="confirmed">
<h2>회원 리스트</h2>
<hr>
<table>
<tr>
<th>번호</th>
<th>아이디</th>
<th>이름</th>
<th>email</th>
<th>전화번호</th>
<th>주소</th>
</tr>
<c:forEach items="${users }" var="user" begin="0" step="1" end="10" varStatus="status">
	<tr><td>${status.count }</td>
	<td width="100">${user.userid }</td>
	<td width="250">${user.username }</td>
	<td width="100">${user.email } </td>
	<td width="250">${user.phone }</td>
	<td width="100">${user.address } </td>
	</tr>
</c:forEach>
</table>
</div>
</body>
</html>