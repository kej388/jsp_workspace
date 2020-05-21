<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="board" class="com.eunjin.javabeans.BoardBean"></jsp:useBean>
<%
	board.setName(request.getParameter("name"));
	board.setPass(request.getParameter("pass"));
	board.setEmail(request.getParameter("email"));
	board.setTitle(request.getParameter("title"));
	board.setContent(request.getParameter("content"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>입력 완료된 정보</h2>
	작성자 : <%=board.getName() %> <br>
	비밀번호 : <%=board.getPass() %> <br>
	이메일 : <%=board.getEmail()%> <br>
	글제목 : <%=board.getTitle() %> <br>
	글내용 : <%=board.getContent() %> <br>
</body>
</html>