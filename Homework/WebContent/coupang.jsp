<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="css/coupang.css">
</head>
<body>
	<div id="wrap">
        <form name="frm" action="coupangTest.jsp" method="post">
            <h1><img src="images/logo-coupang.png" alt="쿠팡로고이미지"></h1>
            <div class="input-container">
                <i class="far fa-envelope icon"></i>
                <input class="input-file" type="text" placeholder="아이디(이메일)" id="emailId" name="emailId">
            </div>
            <p class="alertText emailIdText">이메일을 입력하세요</p>
            <div class="input-container">
                <i class="fas fa-unlock-alt icon"></i>
                <input class="input-file" type="password" placeholder="비밀번호(영문 숫자 특수문자 2가지 이상 6 ~ 15자 이내)" name="pwd" id="pwd">
            </div>
            <p class="alertText pwdText">비밀번호는 6~15자 이내로 입력하셔야 합니다.</p>
            <div class="input-container">
                <i class="fas fa-unlock-alt icon"></i>
                <input id="pwdchk" class="input-file" type="password" placeholder="비밀번호 확인" name="pwdchk">
            </div>
            <p class="alertText pwdchkText">비밀번호가 일치하지 않습니다.</p>
            <div class="input-container">
                <i class="far fa-user icon"></i>
                <input id="name"
                class="input-file" type="text" placeholder="이름" name="name">
            </div>
            <p class="alertText nameText">이름을 정확히 입력하세요</p>
            <div class="input-container">
                <i class="fas fa-mobile-alt icon"></i>
                <input id="phone" name="phone" class="input-file" type="text" placeholder="휴대폰 번호">
            </div>
            <p class="alertText phoneText">휴대폰 번호를 정확하게 입력하세요</p>
            <button type="submit" class="btn" onclick="check()">동의하고 가입하기</button>
            <footer>
                ©Coupang Corp. All rights reserved.
            </footer>
        </form>
    </div>

    <script src="js/coupang.js"></script>
</body>
</html>