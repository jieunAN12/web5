<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body bgcolor="#FFFFFF">
<div align=center>
<H2>  로그인</H2>
<HR>

<form method="post" action="login.do" name="form1">
  <table width="250" border="1" align="center" cellspacing="0" cellpadding="5">
 
    <tr> 
    <td colspan="2" align="center">로그인</td>
  </tr>
  <tr> 
      <td>아이디</td>
      <td><input type="text" name="userid" size=10></td>
  </tr>
  <tr> 
      <td>비밀번호</td>
      <td><input type="password" name="userpwd" size=10></td>
  </tr>
  <tr> 
    <td colspan="2" align="center"> 
        <input type="submit" name="Submit" value="로그인"></td>
  </tr>
</table>
</form>
</div>
</body>
</html>