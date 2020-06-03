<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script src="script/product.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>상품 삭제 - 관리자 페이지</h1>
		<form action="productDelete.do" method="post">
			<table>
				<tr>
					<td>
						<c:choose>
							<c:when test="${empty product.pictureurl}">
								<img src="upload/noImage.jpg">
							</c:when>
							<c:otherwise>
								<img src="upload/${product.pictureurl}">
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<!-- 상품수정Table ------------------------------- -->
						<table>
							<tr> 
								<th style="width : 80px"> 상품명 </th>
								<td>
									<input type="text" name="name" value="${product.name}" size="80" readonly>
								</td>
							</tr>
							<tr> 
								<th> 가 격 </th>
								<td>
									<input type="text" name="price" value="${product.price}" readonly>원
								</td>
							</tr>
							<tr> 
								<th> 설 명 </th>
								<td>
									<textarea cols="90" rows="10" name="description" readonly>${product.description}</textarea>
								</td>
							</tr>
						</table>
						<!-- 상품수정Table -->
					</td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="code" value="${product.code}">
			<input type="submit" value="삭제" onclick="return deleteCheck()">
			<input type="button" value="목록" onclick="location.href='productList.do'">
		</form>
	</div>
</body>
</html>