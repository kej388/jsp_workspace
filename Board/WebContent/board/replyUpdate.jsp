<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/shopping.css">
<script src="script/board.js"></script>
</head>
<body>
	<form name="frm" method="post" action="BoardServlet">
		<input type="hidden" name="command" value="reply_update">
		<input type="hidden" name="num" value="${reply.no}">
		<table class="list">    			
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name" value="${reply.name}"> * 필수 </td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pass"> * 필수 (댓글 수정 삭제시 필요합니다.) </td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea cols="50" rows="5" name="content">${reply.content}</textarea></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="댓글등록" onclick="return replyCheck()">
				</td>	
			</tr> 
	    </table>    
	</form>
</body>
</html>