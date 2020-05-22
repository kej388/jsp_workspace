<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="script/member.js"></script>
</head>
<body>
	<h2>로그인</h2>
	<form method="post" action="login.do" name="frm">
		<input type="text" placeholder="아이디입력" name="userid" id="userid" value="${userid}"><br>
		<input type="password" name="pwd" id="userpwd" placeholder="비밀번호입력"><br>
		<input type="submit" value="로그인" onclick="return loginCheck()">
		<input type="reset" value="취소">
		<input type="button" value="회원가입" onclick="location.href='join.do'"> 
	</form>
	<div>${message}</div>
</body>
</html>