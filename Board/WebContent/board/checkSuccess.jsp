<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		if(window.name == "update"){
			window.opener.parent.location.href = "BoardServlet?command=board_update_form&num=${param.num}";
		}else if(window.name == 'delete'){
			confirm('삭제하시겠습니까? ');
			
			window.opener.parent.location.href = "BoardServlet?command=board_delete&num=${param.num}";
		} else if(window.name == "replyUpdate") {
			window.opener.parent.location.href = "BoardServlet?command=board_view&num=${param.num}";
			console.log("${param.no}");
		}
		window.close();
	</script>
</body>
</html>