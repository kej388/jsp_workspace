<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="board" class="com.eunjin.javabeans.BoardBean"></jsp:useBean>
<jsp:setProperty name="board" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>입력 왼료된 정보</h2>
	작성자 : <jsp:getProperty property="name" name="board"/> <br>
	비밀번호 : <jsp:getProperty property="pass" name="board"/> <br>
	이메일 : <jsp:getProperty property="email" name="board"/> <br>
	글제목 : <jsp:getProperty property="title" name="board"/> <br>
	글내용 : <jsp:getProperty property="content" name="board"/>
</body>
</html>