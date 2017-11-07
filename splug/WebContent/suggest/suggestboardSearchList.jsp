<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Splug</title>
<link rel="stylesheet" href="css/main.css">
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
  	<table class="boardlist">
  		<tr>
				<td colspan="5" style="border: white; text-align: right"><a
					href="Superser?command=suggest_writeForm">글 등록</a></td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<tr class="record">
				<td>${board.num }</td>
				<td><a href="Superser?command=suggest_show&num=${board.num}"> ${board.title } </a></td>
				<td><fmt:formatDate value="${board.writedate }" pattern="yy/MM/dd HH:mm" /></td>
				<td>${board.readcount}</td>
			</tr>
		</c:forEach>
  	</table>
  	<form method="post" action="ik.do">
  		<input type="hidden" name="command" value="suggest_search">
  		<table>
  			<tr>
  				<td>
  					<select id="search" name="search_option" size="1">
  						<option value="title">제목</option>
  						<option value="content">내용</option>
  					</select>
  				</td>
  				<td>
  					<input type="text" name="search_text" id="search_text">
  				</td>
  				<td>
  					<input type="submit" value="검색">
  				</td>
  			</tr>
  		</table>
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