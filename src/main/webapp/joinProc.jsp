<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%--
    	lab.web.model.UserVO vo = new lab.web.model.UserVO();
    	request.setAttribute("vo", vo);
    	vo.setUserid(request.getParmeter("userid"));
    	vo.setUserpwd(request.getParmeter("userpwd"));
    	vo.setUsername(request.getParmeter("username"));
     --%>
    
<jsp:useBean id="vo" class="lab.web.model.UserVO" scope="session">
	<jsp:setProperty name="vo" property="*"/>
</jsp:useBean>
<%-- 
	아이디 : <jsp:getProperty name="vo" property="userid"/><br>
	비밀번호 : <jsp:getProperty name="vo" property="userpwd"/><br>
	이름 : <jsp:getProperty name="vo" property="username"/><br>
--%>

<jsp:forward page="result.jsp"/>