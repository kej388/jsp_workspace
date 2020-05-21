<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("userid", "hkd");
		RequestDispatcher dispatcher=request.getRequestDispatcher("b.jsp");
		dispatcher.forward(request, response);
	%>
	<form action="b.jsp" method="post">
		<input type="submit" value="전송">
	</form>
</body>
</html>