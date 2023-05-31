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
<title>장바구니</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<div id="confirmed">
<table>
<tr>
<th>상품이미지</th>
<th>상품ID</th>
<th>상품명</th>
<th>수량</th>
<th>구매가격</th>
</tr>

<c:forEach items="${cart}" var="snack">
<tr>
<td width="100"><img src="${snack.pimg }" width="70" height="70"></td>
<td width="100">${snack.pid }</td>
<td width="250">${snack.pname }</td>
<td width="100">${snack.qty }</td>
<td width="70">${snack.qty*snack.price }원</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>