<%@page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String name = request.getParameter("name");
%>
아이디 : <%=request.getParameter("emailId")%> <br>
비번 : <%=request.getParameter("pwd")%><br>
이름 : <%=URLDecoder.decode(request.getParameter("name"), "UTF-8") %><br>
번호 : ${param.phone}<br>