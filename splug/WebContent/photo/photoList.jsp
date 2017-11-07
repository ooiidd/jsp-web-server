<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
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
  	 <table class="photoBoard">
  		<tr>
				<td colspan="5" style="border: white; text-align: right"><a
					href="ik.do?command=photo_write_form">글 등록</a></td>
		</tr>
		<%int first_end=0,second_start=5;%>
		<c:choose>
			<c:when test="${fn:length(boardList) >= 5 }">
				<c:set var="first_end" value="4"/>
			</c:when>
			<c:otherwise>
				<c:set var="first_end" value="${fn:length(boardList) }"/>
			</c:otherwise>
		</c:choose>
		<!-- 처음 한개 행  -->
		<tr>
			<c:forEach begin="0" end="${first_end}" var="board" items="${boardList }" varStatus="status">
				<c:choose>
				<c:when test="${empty main_img[status.index] || main_img[status.index] eq ''}">
					<td colspan="2"><a href="ik.do?command=photo_show&num=${board.num}"><img src="imgboard/noimg.png" width="200"></a></td>
				</c:when>
				<c:otherwise>
					<td colspan="2"><a href="ik.do?command=photo_show&num=${board.num}"><img src="imgboard/${main_img[status.index] }" width="200" alt="imgboard/noimg.png"></a></td>
				</c:otherwise>
				</c:choose>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach begin="0" end="${first_end}" var="board" items="${boardList }" varStatus="status">
				<td colspan="2">${board.title }</td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach begin="0" end="${first_end}" var="board" items="${boardList }" varStatus="status">
				<td>${board.name }</td>
				<td><fmt:formatDate value="${board.writedate }" pattern="yy/MM/dd HH:mm" /></td>
			</c:forEach>
		</tr>
		
		<!-- 두번째 행 -->
		<c:choose>
			<c:when test="${fn:length(boardList) > 5 }">
			<tr>
				<c:forEach begin="5" end="${fn:length(boardList)-1}" var="board" items="${boardList }" varStatus="status">
					<td colspan="2"><a href="ik.do?command=photo_show&num=${board.num}"><img src="imgboard/${main_img[status.index] }" width="200"></a></td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach begin="5" end="${fn:length(boardList)-1}" var="board" items="${boardList }" varStatus="status">
					<td colspan="2">${board.title }</td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach begin="5" end="${fn:length(boardList)-1}" var="board" items="${boardList }" varStatus="status">
					<td>${board.name }</td>
					<td><fmt:formatDate value="${board.writedate }" pattern="yy/MM/dd HH:mm" /></td>
				</c:forEach>
			</tr>
			</c:when>
		</c:choose>
	</table>
		
		<table>
  		<tr>
  			<% 
 
  				
  				int rowCount = (Integer)request.getAttribute("tablenum");
  				int nowpage = (Integer)request.getAttribute("nowpage");
  				
  				int pageCount = rowCount/10;
  				if(rowCount%10 > 0) pageCount++;
  				
  				int blockCount = pageCount/10;
  				if(pageCount%10 != 0) blockCount++;
  				
  				int block = nowpage/10;
  				if(nowpage%10 != 0) block++;
  				int pageEnd;
  				int pageStart=(block-1)*10 + 1;
  				if(pageCount > block*10){
  					pageEnd = (block)*10;
  				}else{
  					pageEnd = pageCount;
  				}
  				
  				int prev_page = (block-2)*10 + 1;
  				int next_page = (block*10)+1;
  			%>
  			<td><a href="ik.do?command=photo&page=1">[처음으로]</a><td>
  			<%if(block>1){ %>
  				<td><a href="ik.do?command=photo&page=<%=prev_page %>">[이전]</a></td>
  			<%} %>
  			<%for(int i=pageStart; i<=pageEnd ;i++){ 
  				if(nowpage==i){%>
  					<td><p>[<%=i %>]</p></td>
  				<%} else{ %>
  					<td><a href="ik.do?command=photo&page=<%=i %>">[<%=i %>]</a></td>
  				<%} %>
  			<%} %>
  			<%if(block<blockCount){ %>
  				<td><a href="ik.do?command=photo&page=<%=next_page %>">다음</a></td>
  			<%} %>
  			<td><a href="ik.do?command=photo&page=<%=pageCount %>">[맨뒤로]</a></td>
  		</tr>
  	</table>

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