<%@page import="java.util.ArrayList"%>
<%@page import="lab.web.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
UserVO user1 = new UserVO();
	user1.setUserid("lee");
	user1.setUsername("MJ");
	user1.setEmail("MJ@naver.com");
UserVO user2 = new UserVO();
	user2.setUserid("kim");
	user2.setUsername("HH");
	user2.setEmail("HH@naver.com");
UserVO user3 = new UserVO();
	user3.setUserid("Park");
	user3.setUsername("ZM");
	user3.setEmail("ZM@naver.com");
ArrayList<UserVO> users = new ArrayList();
	users.add(user1);
	users.add(user2);
	users.add(user3);
pageContext.setAttribute("users", users);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl : 조건 태그</title>
</head>
<body>
<c:set var="name" value="대한민국"/>

<c:if test="${name eq '대한민국' }">
	대한민국 심각 <br>
</c:if>
<c:if test="${name ne '대한민국' }">
	대한민국 덜 심각 <br>
</c:if>

<c:choose>
<c:when test="${name eq '대한민국' }">
대한민국 심각 <br>
</c:when>
<c:otherwise>
대한민국 덜 심각 <br>
</c:otherwise>
</c:choose>
<hr>
<table>
<c:forEach var="item" items="${users }" begin="0" end="5" step="1" varStatus="status">
<tr>
<td>번호 : ${status.count }</td>
<td>아이디 : ${item.userid }</td>
<td>이름 : ${item.username }</td>
<td>이메일 : ${item.email }</td>
</tr>
</c:forEach>
</table>
<%-- varStatus는 반복상태를 알 수 있는 변수로서 index, count, first, last 속성에 대한 값을 알 수 있다. --%>

<c:forTokens var="item" items="서울, 대전, 대구, 부산, 울산" delims=",">
지역 : ${item }<br>
</c:forTokens>

${application.Apple }<br>
${application.Samsung }<br>
${Apple }<br>
${Samsung }<br>
<%= application.getInitParameter("Apple") %>
<%= application.getInitParameter("Samsung") %>

</body>
</html>