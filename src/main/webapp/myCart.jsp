<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.cart == null }">
<c:redirect url="./snackList"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니mycart</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<div id="confirmed">


<%
	Cookie[] cookies = request.getCookies();
for(Cookie c : cookies){
	if(!c.getName().startsWith("JSESSION")){
		out.print(URLDecoder.decode(c.getValue(), "utf-8")+"<br>");
	}
}
%>
</div>

</body>
</html>