<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Splug</title>
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
		<li><a href="#">알림</a>
		<ul>
			<div class="angle"></div>
			<li><a href="Superser?command=noticeboardList&page=1">공지사항</a></li>
			<li><a href="Superser?command=history">연혁</a></li>
		</ul>
		</li>
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
			<li><a href="ik.do?command=jokboboardList&page=1">자료실</a></li>
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
  <aside class="rightside">
	<div class="id" >
		<form name="frm" method="post" action="Superser">
			<input id="log1" type="text" size"12" name="userid" placeholder="아이디">
			<input id="log2" type="password" size"12" name="pwd" placeholder="비밀번호">
			<input id="login" type="submit" value="로그인" onclick="return loginCheck()">
		</form>
		<div><a href="Superser?command=join">회원 가입</a></div>
		<div><p>${message} </p></div>
	</div>
  </aside>
  <section>
 		<img flow="left" width="80%" alt="보노보노" src="image/no.jpg">
  </section>
  
  <footer>
  
  </footer>
</body>
</html>