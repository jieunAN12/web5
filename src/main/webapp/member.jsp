<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<h2> 회원가입</h2>
<HR>
<form method="post" action="join.do" name="form1">
<table width="450" border="1" align="center" cellspacing="0" cellpadding="5">
 
    <tr> 
    <td colspan="2" align="center">회원가입 </td>
    </tr>
  <tr> 
      <td width="150">아이디</td>
      <td><input type="text" name="userid" size=30></td>
  </tr>
  <tr> 
      <td width="150">비밀번호</td>
      <td><input type="password" name="userpwd" size=30></td>
  </tr>
    <tr> 
      <td width="150">이름</td>
      <td><input type="text" name="username" size=30></td>
  </tr>
  <tr>
	<td width="150">권한</td>
	<td>
		<input type="checkbox" name="role" value="USER"> USER
        <input type="checkbox" name="role" value="ADMIN"> ADMIN
    </td>
  </tr>
  <tr> 
      <td width="150">Email</td>
      <td><input type="email" name="email" size=30></td>
  </tr>
  <tr> 
      <td width="150">연락처(Phone)</td>
      <td><input type="tel" name="phone" size=30></td>
  </tr>
  <tr> 
      <td width="150"> 주소 </td>
      <td><input type="text" name="address" size=30></td>
  </tr>
  <tr> 
    <td colspan="2" align="center"> 
        <input type="submit" name="Submit" value="회원가입"></td>
  </tr>
</table>
</form>

</body>
</html>