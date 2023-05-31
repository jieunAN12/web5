<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set value="Hello World" var="msg"/><%-- jstl 변수 선언, 초기화 --%>
msg : ${msg }<br>
<c:out value="${msg }"/><br>
<c:remove var="msg"/>
after remove : ${msg }<br>
<c:catch var="errMsg">
<%= 9/0 %>
</c:catch>
error message : ${errMsg }<br>
</body>
</html>