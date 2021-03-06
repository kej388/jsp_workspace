<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<script src="script/member.js"></script>
</head>
<body>
	<h2>회원의 정보 입력 폼</h2>
	<form method="post" action="join.do" name="frm">
		<table>
			<tr>
			<td> 이름 </td>
			<td> <input type="text" name="name" size="20"></td>
			</tr>
			<tr>
			<td> 아이디 </td>
			<td> 
				<input type="text" name="userid" size="20" readonly>
				<input type="hidden" name="reid" size="20">
				<input type="button" value="중복체크" onclick="idCheck()">
			</td>
			</tr>
			<tr>
			<td> 비밀번호 </td>
			<td> <input type="password" name="pwd" size="20"></td>
			</tr>
			<tr>
			<td> 비밀번호 확인 </td>
			<td> <input type="password" name="pwd_check" size="20"></td>
			</tr>
			<tr>
			<td> 이메일 </td>
			<td> <input type="text" name="email" size="20"></td>
			</tr>
			<tr>
			<td> 전화번호 </td>
			<td> <input type="text" name="phone" size="11"></td>
			</tr>
			<tr>
			<td> 등급 </td>
			<td> <input type="radio" name="admin" value="0" checked="checked"> 일반회원
				<input type="radio" name="admin" value="1"> 관리자
			</td>
			</tr>
			<tr>
			<td><input type="submit" value="확인" onclick="return joinCheck()"> </td>
			<td><input type="reset" value="취소"> </td>
			</tr>
			<tr>
				<td>${message}</td>
			</tr>
		</table>
	</form>
</body>
</html>