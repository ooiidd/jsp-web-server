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
  	<div id="wrap" align="center">
		<table>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${board.writedate}" /></td>
				<th>작성자</th>
				<td>${board.name }</td>
				<th>조회수</th>
				<td>${board.readcount }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${board.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${content }</pre></td>
			</tr>
		</table>
		<table>
			<c:forEach var="datlist" items="${dat }">
				<tr>
					<td>${datlist.name }</td>
					<td>${datlist.content }</td>
					<td><fmt:formatDate value="${datlist.writedate}" pattern="yy/MM/dd HH:mm" /></td>
				</tr>
			</c:forEach>
		</table>
		<form name="frm" action="ik.do" method="post">
			<input type="hidden" name="command" value="noticedat_write">
			<input type="hidden" name="num" value="${board.num }">
			<input type="hidden" name="table" value="notice">
			<table>
				<tr>
					<th>댓글쓰기</th>
					<td><textarea cols="50" rows="5" name="content" onKeyUp="checkbyte(this,'200')"></textarea></td>
					<td><span id="byteInfo">0</span>/200Byte</td>
					<td><input type="submit" value="입력"></td>
				</tr>
			</table>
		</form>
		<br> <br> 
		<c:if test="${requestScope.check == loginUser.userid ||loginUser.admin >= 3 }">
		<input type="button" value="게시글 수정"
			onclick="location.href='ik.do?command=noticeboard_update_form&num=${board.num}'">
		<form name="deleteform" action="ik.do" method="post">
			<input type="hidden" name="command" value="noticeboard_delete">
			<input type="hidden" name="num" value="${board.num }">
			<input type="button" value="게시글 삭제" onclick="return realDelete()">
		</form>
		</c:if>
	</div>
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