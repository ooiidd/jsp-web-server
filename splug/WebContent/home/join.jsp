<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="css/main.css">
<script type="text/javascript" src="script/member.js"></script>
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
  	<form action="join.do" method="post" name="frm">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" size="20" id="userid"><input 
				type="hidden" name="reid" size="20"><input type="button" value="중복 체크"
				onclick="idCheck()"></td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="pwd" size="20"></td>
			</tr>
			<tr>
				<td>암호 확인</td>
				<td><input type="password" name="pwd_check" size="20"></td>
			</tr>
			<tr>
				<td>학번</td>
				<td><input type="text" name="hakbun" size="20"></td>
			</tr>
			<tr>
				<td>핸드폰 번호</td>
				<td><input type="text" name="phone" size="20"></td>
			</tr>
			<tr>
				<td>학과</td>
				<td><input type="radio" name="hakgwa" value="computer"
				checked="checked">컴퓨터<input type="radio" name="hakgwa"
				value="soft">소프트</td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td><input type="text" name="email" size="20"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="회원 가입"
				onclick="return joinCheck()">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="취소">
			</tr>
		</table>
	</form>
  </section>
  <aside class="rightside">
	<div class="id">
		<form name="login" method="post" action="Superser">
			<input id="log1" type="text" size"12" name="id" placeholder="아이디">
			<input id="log2" type="password" size"12" name"pwd" placeholder="비밀번호">
			<input id="login" type="submit" value="로그인">
		</form>
		<div><a href="Superser?command=join">회원 가입</a></div>
	</div>
  </aside>
  <footer>
  
  </footer>
</body>
</html>