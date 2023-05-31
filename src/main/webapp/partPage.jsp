<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css" src="partPage.css"></style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>.
<script type="text/javascript" src="partPage.js"></script>
</head>
<body>

<h3>부분페이지 동적 갱신</h3>
    <table border="1">
      <tr><td colspan="2" align="center"><font size=15><b>우리회사</b></font></td></tr>
      <tr>
         <td><form action="#">
               <div id="confirmed">
                 <table>
                    <tr>
                      <td>아이디</td>
                      <td><input type="text" id="userid" name="userid" size="15" maxlength="12"/></td>
                    </tr>
                    <tr>
                      <td>비밀번호</td>
                      <td><input type="password" id="userpwd"  name="userpwd" size="15" maxlength="12"/></td>
                    </tr>
                    <tr><td colspan="2" align="center">
                        <input type="button" id="login" value="로그인" /></td>
                    </tr>
                </table>
              </div>
             </form>
         </td>
         <td width="400"><img src="./images/dog1.jpg"></td>
      </tr>
      <tr><td colspan="2" align="center">찾아오시는길 |회사소개|정보보호정책</td></tr>
    </table>

</body>
</html>