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
<body bgcolor="#ffffff">
<div id="nav" align="left">
<a href="./viewCart.jsp">장바구니</a><br>
</div>
<div id="confirmed">
<table>
<tr>
<th>번호</th>
<th>상품이미지</th>
<th>상품내용</th>
<th>상품가격</th>
<th>수량</th>
<th>장바구니</th>
</tr>
<c:forEach items="${snacks }" var="product" begin="0" step="1" end="10" varStatus="status">
	<form action="cartSave" method="post">
		<input type="hidden" id="pid" name="pid" value="${product.pid}">
		<input type="hidden" id="pname" name="pname" value="${product.pname}">
		<input type="hidden" id="price" name="price" value="${product.price}">
		<tr><td>${status.count }</td>
		<td width="100"><img src="${product.pimg }" width="70" height="70"></td>
		<td width="250">${product.pname }</td>
		<td width="100">${product.price } 원</td>
		<td width="70"><select id="qty" name="qty">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
		</select></td>
		<td width="150"><input type="submit" id="addCart" value="장바구니 담기"></td>
		</tr>
	</form>
</c:forEach>
</table>
</div>

</body>
</html>