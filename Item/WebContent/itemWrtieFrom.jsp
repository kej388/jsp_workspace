<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>정보 입력 폼</h2>
	<form action="itemInfo.do" method="post">
	<table>
		<tr>
			<td>상품명</td>
			<td>
				<input type="text" name="name" size="20">
			</td>
		</tr>
		<tr>
			<td> 가격 </td>
			<td>
				<input type="text" name="price" size="20">
			</td>
		</tr>
		<tr>
			<td> 설명 </td>
			<td>
				<textarea name="description" rows="5" cols="100">나만의 시원한 이야기를 담는다.</textarea>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="확인"> </td>
			<td><input type="reset" value="취소"> </td>
		</tr>
	</table>
	</form>
</body>
</html>