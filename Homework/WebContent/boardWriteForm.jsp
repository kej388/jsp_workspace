<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        input{
            display:block;
            margin-bottom: 10px;
            width: 300px;
        }
        form{
            width: 500px;
            margin: 0 auto;
        }
        .leftTitle{
            width: 100px;
            float: left;
            text-align: right;
        }
        .leftTitle p {
            margin-top: 0;
            margin-bottom: 10px;
            
        }
        .rightForm{
            float:left;
            padding: 0 10px;
        }
        .bottomButton{
            clear:left;
            width: 300px;
            margin: 0 auto;
            padding-top: 10px;
            padding-left: 100px;
        }
        .bottomButton input {
            display: inline-block;
            width: 100px;
        }
    </style>
</head>
<body>
	<h2 style="text-align: center;">게시판 글쓰기</h2>
    <form action="boardWrite2.jsp" method="POST">
        <div class="leftTitle">
            <p>작성자</p>
            <p>비밀번호</p>
            <p>이메일</p>
            <p>글 제목</p>
            <p>글 내용</p>
        </div>
        <div class="rightForm">
            <input type="text" name="name">
            <input type="password" name="pass">
            <input type="text" name="email">
            <input type="text" name="title">
            <textarea name="content" cols="40" rows="10"></textarea>
        </div>
        <div class="bottomButton">
            <input type="submit" value="등록">
            <input type="reset" value="다시 작성">
        </div>
    </form>
</body>
</html>