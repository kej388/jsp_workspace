function boardCheck() {
	if (document.frm.name.value.length == 0) {
		alert("작성자를 입력하세요.");
		return false;
	}
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	if (document.frm.title.value.length == 0) {
		alert("제목을 입력하세요.");
		return false;
	}
	if (document.frm.content.value.length == 0) {
		alert("내용을 입력하세요.");
		return false;
	}
	let ben = ["원숭이", "이발소", "소방차", "차승원", "원빈", "빈수레", "레코드", "드라마", "마스크", "크레용"];
	for(var i = 0; i < ben.length; i++) {
		if(document.frm.title.value == ben[i]) {
			alert("금칙어를 사용하였습니다. 다시 입력해주세요");
			return false;
		}
		if(document.frm.content.value == ben[i]) {
			alert("금칙어를 사용하였습니다. 다시 입력해주세요");
			return false;
		}
	}
}

function open_win(url, name) {
	window.open(url, name, "width=500, height=230");
}
function open_win2(param) {
	window.open("BoardServlet?command=reply_check_pass_form&pNum="+param, "replyUpdate", "width=600, height=230");
}

function passCheck() {
	if(document.frm.pass.value.length == 0) {
		alert("비밀번호를 입력하세요");
		return false;
	}
}

function replyCheck() {
	if (document.frm.name.value.length == 0) {
		alert("이름를 입력하세요.");
		return false;
	}
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호을 입력하세요.");
		return false;
	}
	if (document.frm.content.value.length == 0) {
		alert("내용을 입력하세요.");
		return false;
	}
}

function close() {
	window.close();
}
