function productCheck() {
	if (document.frm.name.value.length == 0) {
		alert("상품명을 써주세요");
		frm.name.focus();
		return false;
	}
	if (document.frm.price.value.length == 0) {
		alert("가격을 써주세요");
		frm.price.focus();
		return false;
	}
	if (isNaN(document.frm.price.value)) {
		alert("숫자를 입력해야 합니다.");
		frm.price.select();
		return false;
	}
	return true;
}

function deleteCheck() {
	var check = confirm('삭제하시겠습니까?');
	if(check == true) {
		return true;
	} else {
		return false;
	}
}