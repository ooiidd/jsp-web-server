<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Splug</title>
<link rel="stylesheet" href="css/main.css">
<script>
function checkbyte(obj,tarid,maxByte){
	var maxByte = maxByte;
	var str = obj.value;
	var str_len = str.length;
	var id = tarid;

	var rbyte = 0;
	var rlen = 0;
	var one_char = "";
	var str2 = "";

	for(var i=0; i<str_len; i++){
		one_char = str.charAt(i);
		if(escape(one_char).length > 4){
			rbyte += 3;
		}else{
			rbyte++;
		}
			
		if(rbyte <= maxByte){
			rlen = i+1;
		}
	}

	if(rbyte > maxByte){
		alert("한글 "+(maxByte/3)+"자 / 영문 "+maxByte+"자를 초과 입력할 수 없습니다.");
		str2 = str.substr(0,rlen);
		obj.value = str2;
		fnChkByte(obj, maxByte);
	}else{
		document.getElementById(id).innerText = rbyte;
	}
}
</script>
</head>
<body>
 <header>
 	<center>
 		<img alt="개발" src="image/SPLUG.png" height="100">
	</center>

	<ul id="nav">
		<div class="logo">
			<h2><a href="Superser?command=loginhome">SPLUG</a></h2>
		</div>
		<li><a href="Superser?command=noticeboardList&page=1">공지사항</a></li>
		<li><a href="#">글 게시판</a>
		<ul>
			<div class="angle"></div>
			<li><a href="Superser?command=ikboardList&page=1">익명 게시판</a></li>
			<li><a href="ik.do?command=freeboardList&page=1">자유 게시판</a></li>
		</ul>
		</li>
		<li><a href="#">자료 공간</a>
		<ul>
			<div class="angle"></div>
			<li><a href="ik.do?command=jokboboardList&page=1">족보 게시판</a></li>
			<li><a href="ik.do?command=photo&page=1">갤러리</a></li>
		</ul>
		</li>
		<li><a href="#">SPLUG</a>
			<ul>
				<div class="angle"></div>
				<li><a href="ik.do?command=meetingboardList&page=1">회의록</a></li>
				<li><a href="ik.do?command=schedule_show">일정표</a></li>
			</ul>
		</li>
		<li><a href="#">물어보자</a>
			<ul>
				<div class="angle"></div>
				<li><a href="ik.do?command=suggestboardList&page=1">건의사항</a></li>
				<li><a href="ik.do?command=qnaboardList&page=1">QnA</a></li>
			</ul>
		</li>
	</ul>
  </header>
  <section>
		<form method="post" action="photo.do"  name="frm" enctype="multipart/form-data">
			<table>
				<tr>
					<th>제 목</th>
					<td><input type="text" name="title" size="80" onKeyUp="checkbyte(this,'title','150')"></td>
					<td><span id="title">0</span>/150Byte</td>
				</tr>
				<tr>
					<th>사 진</th>
					<td><input type=file name="filename" multiple><br>
				</tr>
				<tr>
					<th>내 용</th>
					<td><textarea cols="80" rows="10" name="content" onKeyUp="checkbyte(this,'content','2000')"></textarea></td>
					<td><span id="content">0</span>/2000Byte</td>
				</tr>
			</table>
			<br> <input type="submit" value="등록" > 
				<input type="reset" value="다시작성"> 
		</form>
  </section>
  <aside class="rightside">
	<div class="log">
		<p>${loginUser.userid}</p>
		<p>${loginUser.name }</p>
		<p>${loginUser.hakbun }</p>
		<a href="Superser?command=logout">로그아웃</a>
	</div>
  </aside>
  <footer>
  
  </footer>
</body>
</html>