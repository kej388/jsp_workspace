<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        * {
            padding: 0;
            margin: 0;
        }

        header {
            width: 100%;
            height: 150px;
            padding: 50px;
            background-color: black;
            color: whitesmoke;

        }

        aside {
            width: 100px;
            height: 600px;
            padding: 10px;
            background: #cccccc;
            float: left;

        }

        article {
            width: 700px;
            height: 600px;
            padding: 10px;
            background: white;
        }

        footer {
            width: 100%;
            height: 70px;
            padding: 20px;
            background: rgb(230, 227, 227);
            clear: both;
        }

        nav {
            width: 100%;
            height: 30px;
            background-color: rgb(90, 90, 87);
            padding-left: 20px;
        }
        #menu_container{
            list-style-type: none;
            position: relative;
        }
        .menu_float {
            float: left;
            margin-right: 10px;
        }
        a{
            text-decoration: none;
            color: #000;
        }
        #li_container{
            position: absolute;
            left: 210px;
            top: -70px;
            list-style-type: none;
            display:none;
            transition: top 2s;
        }
        #menu_container:hover > #li_container{
            display:block;
            top: 30px;
        }
        #li_container li {
            background-color: #fff;
            border:1px solid;
            color:#000;
        }
    </style>
</head>
<body>
	<header>
        <h1>TIS edu</h1>
    </header>
    <%@ include file="nav.jsp" %>
    <aside>
        <!--왼쪽-->
        About<br>
        History<br>
        Board<br>
    </aside>
    <article>
        <!--본문내용-->
        TIS 교육센터는 정부지원 IT전문교육기관 입니다.
    </article>
    <footer>
        TIS Edu.
    </footer>
</body>
</html>