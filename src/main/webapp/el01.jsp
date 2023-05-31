<%@page import="lab.web.model.UserVO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String, String> cart = new HashMap<>();
	cart.put("사과","5");
	cart.put("참외","10");
	cart.put("토마토","15");
	//page, request, session, application
	pageContext.setAttribute("cart", cart);
	
	UserVO user1 = new UserVO();
	user1.setUserid("lee");
	user1.setUsername("MJ");
	pageContext.setAttribute("user01", user1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL표현언어</title>
</head>
<body>
<em>EL 리터럴 표현식</em><br>
<hr>
문자열 : ${"test"}<br>
문자열 : ${'test'}<br>
정수 : ${20}<br>
부동소수점 : ${3014}<br>
Boolean : ${true}<br>
null : ${null}<br>
cart : ${cart["사과"]}, ${cart["참외"]}<br>
user : ${user01.userid},${user01.username }<br>

${10 % 20}<br>
${10 mod 20 }<br>
${10 == 11}<br>
${10 eq 11}<br>
${10 != 11}<br>

${10 > 20 ? "크다" : "작다"}<br>
<hr>
파라미터 userid : ${param.userid }<br>
파라미터 userpwd : ${param.userpwd }<br>
파라미터 email : ${param.email }<br>
파라미터 memo : ${param.memo }<br>
<hr>
http헤더 host : ${header.host }<br>
http헤더 connection : ${header.connection }<br>
http헤더 user-agent : ${header.user-agent }<br>
http헤더 cookie : ${header.cookie }<br>

</body>
</html>