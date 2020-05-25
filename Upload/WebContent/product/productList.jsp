<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>상품리스트 - 관리자페이지</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border:white; text-align:right">
					<a href="productWrite.do">상품등록</a>
				</td>
			</tr>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>가격</td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
			<c:forEach var="product" items="${productList}">
				<tr class="record">
					<td>${product.code}</td>
					<td>${product.name}</td>
					<td>${product.price} 원</td>
					<td>
						<a href="productUpdate.do?code=${product.code}">상품수정</a>
					</td>
					<td>
						<a href="productDelete.do?code=${product.code}">상품삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>