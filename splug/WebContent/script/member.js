function checkbyte(obj, maxByte){
	var maxByte = obj.value;
	var str = document.frm.content.value;
	var str_len = str.length;

	var rbyte = 0;
	var rlen = 0;
	var one_char = "";
	var str2 = "";

	for(var i=0; i<str_len; i++){
		one_char = str.charAt(i);
		if(escape(one_char).length > 4){
			rbyte += 2;                                         //한글2Byte
		}else{
			rbyte++;                                            //영문 등 나머지 1Byte
		}
			
		if(rbyte <= maxByte){
			rlen = i+1;                                          //return할 문자열 갯수
		}
	}

	if(rbyte > maxByte){
		alert("한글 "+(maxByte/2)+"자 / 영문 "+maxByte+"자를 초과 입력할 수 없습니다.");
		str2 = str.substr(0,rlen);                                  //문자열 자르기
		obj.value = str2;
		fnChkByte(obj, maxByte);
	}else{
		document.getElementById('byteInfo').innerText = rbyte;
	}
}

function loginCheck() {
	if (document.frm.userid.value == "") {
		alert("아이디를 입력해 주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	return true;
}
function realDelete(){
	if(confirm("정말 삭제하시겠습니까?")==true){
		deleteform.submit();
	}
	return;
}
function idCheck() {
	if (document.frm.userid.value == "") {
		alert('아이디를 입력하여 주세요');
		document.formm.userid.focus();
		return;
	}
	var url = "Superser?command=idcheck&userid=" + document.frm.userid.value;
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok(userid) {
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
}

function joinCheck() {
	if (document.frm.name.value.length == 0) {
		alert("이름을 써주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.userid.value.length < 4) {
		alert("아이디는 4글자이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd.value != document.frm.pwd_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.reid.value.length == 0) {
		alert("중복 체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.hakbun.value.length != 8){
		alert("학번은 8자리 입니다.");
		frm.hakbun.focus();
		return false;
	}
	return true;
}