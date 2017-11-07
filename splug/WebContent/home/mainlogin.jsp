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
	<div class="log">
		<p>${loginUser.userid}</p>
		<p>${loginUser.name }</p>
		<p>${loginUser.hakbun }</p>
		<a href="ik.do?command=self_update_form">정보 수정</a>
		<a href="Superser?command=logout">로그아웃</a>
	</div>
  </aside>
  <section>
 	<div>
 		<table>
 			<caption>공지사항</caption>
 			<tr>
 				<th>작성자</th>
 				<th>제목</th>
 				<th>작성일</th>
 			</tr>
 			<c:forEach var="board" items="${notice }" varStatus="status">
				<tr class="record">
					<td>${board.name}</td>
					<td><a href="ik.do?command=notice_show&num=${board.num}"> ${board.title } </a>
					<c:if test="${notice_new[status.index]==1 }">
						<img src=image/new.jpg>
					</c:if>
					</td>
					<td><fmt:formatDate value="${board.writedate }" pattern="yy/MM/dd" /></td>
				</tr>
			</c:forEach>
 		</table>
 	</div>
 	<div>
 		<table>
 			<caption>익명 게시판</caption>
 			<tr>
 				<th>제목</th>
 				<th>작성일</th>
 			</tr>
 			<c:forEach var="board" items="${ik }" varStatus="status">
				<tr class="record">
					<td><a href="ik.do?command=ik_show&num=${board.num}"> ${board.title } </a>
					<c:if test="${ik_new[status.index]==1 }">
						<img src=image/new.jpg>
					</c:if>
					</td>
					<td><fmt:formatDate value="${board.writedate }" pattern="yy/MM/dd" /></td>
				</tr>
			</c:forEach>
 		</table>
 	</div>
 	<div>
 		<table>
 			<caption>자유 게시판</caption>
 			<tr>
 				<th>작성자</th>
 				<th>제목</th>
 				<th>작성일</th>
 			</tr>
 			<c:forEach var="board" items="${free }" varStatus="status">
				<tr class="record">
					<td>${board.name}</td>
					<td><a href="ik.do?command=free_show&num=${board.num}"> ${board.title } </a>
					<c:if test="${free_new[status.index]==1 }">
						<img src=image/new.jpg>
					</c:if>
					</td>
					<td><fmt:formatDate value="${board.writedate }" pattern="yy/MM/dd" /></td>
				</tr>
			</c:forEach>
 		</table>
 	</div>
 	<div>
 		<table>
 			<caption>QnA</caption>
 			<tr>
 				<th>작성자</th>
 				<th>제목</th>
 				<th>작성일</th>
 			</tr>
 			<c:forEach var="board" items="${qna }" varStatus="status">
				<tr class="record">
					<td>${board.name}</td>
					<td><a href="ik.do?command=qna_show&num=${board.num}"> ${board.title } </a>
					<c:if test="${qna_new[status.index]==1 }">
						<img src=image/new.jpg>
					</c:if>
					</td>
					<td><fmt:formatDate value="${board.writedate }" pattern="yy/MM/dd" /></td>
				</tr>
			</c:forEach>
 		</table>
 	</div>
 	<div>
 		<table>
 			<caption>건의사항</caption>
 			<tr>
 				<th>작성자</th>
 				<th>제목</th>
 				<th>작성일</th>
 			</tr>
 			<c:forEach var="board" items="${suggest }" varStatus="status">
				<tr class="record">
					<td>${board.name}</td>
					<td><a href="ik.do?command=suggest_show&num=${board.num}"> ${board.title } </a>
					<c:if test="${suggest_new[status.index]==1 }">
						<img src=image/new.jpg>
					</c:if>
					</td>
					<td><fmt:formatDate value="${board.writedate }" pattern="yy/MM/dd" /></td>
				</tr>
			</c:forEach>
 		</table>
 	</div>
  </section>
  
  <footer>
  
  </footer>
</body>
</html>