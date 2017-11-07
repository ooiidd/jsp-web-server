<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css">
<title>일정 추가</title>
</head>

<form name="form1" method="post" action="ik.do">
<input type=hidden name="command" value="schedule_add_db">
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
<div align="center">
<H2>일정추가 </H2>
<br>
<table border="1">
  <tr>
  <%!
  public static String isSelected(String value1, String value2)
  {

      if (value1 == null || value2 == null) 
          return "";

      return value1.equals(value2) ? "SELECTED" : "";
  }
  %>
  <%
  String a=request.getParameter("year");
  String b=request.getParameter("month");
  String c=request.getParameter("day");
  %>
    <th>날짜 </th>	
    <td><select id="s_year" name="s_year">
    <option value="2016" <%=isSelected(a,"2016")%>>2016</option>
    <option value="2017" <%=isSelected(a,"2017")%>>2017</option>
    <option value="2018" <%=isSelected(a,"2018")%>>2018</option>
    <option value="2019" <%=isSelected(a,"2019")%>>2019</option>
    <option value="2020" <%=isSelected(a,"2020")%>>2020</option>
    <option value="2021" <%=isSelected(a,"2021")%>>2021</option>
    
    </select>
    <select id="s_month" name="s_month">
    <option value="1" <%=isSelected(b,"1")%>>1</option>
    <option value="2" <%=isSelected(b,"2")%>>2</option>
    <option value="3" <%=isSelected(b,"3")%>>3</option>
    <option value="4" <%=isSelected(b,"4")%>>4</option>
    <option value="5" <%=isSelected(b,"5")%>>5</option>
    <option value="6" <%=isSelected(b,"6")%>>6</option>
    <option value="7" <%=isSelected(b,"7")%>>7</option>
    <option value="8" <%=isSelected(b,"8")%>>8</option>
    <option value="9" <%=isSelected(b,"9")%>>9</option>
    <option value="10" <%=isSelected(b,"10")%>>10</option>
    <option value="11" <%=isSelected(b,"11")%>>11</option>
    <option value="12" <%=isSelected(b,"12")%>>12</option>
    </select>
    <select id="s_day" name="s_day">
    <option value="1" <%=isSelected(c,"1")%>>1</option>
    <option value="2" <%=isSelected(c,"2")%>>2</option>
    <option value="3" <%=isSelected(c,"3")%>>3</option>
    <option value="4" <%=isSelected(c,"4")%>>4</option>
    <option value="5" <%=isSelected(c,"5")%>>5</option>
    <option value="6" <%=isSelected(c,"6")%>>6</option>
    <option value="7" <%=isSelected(c,"7")%>>7</option>
    <option value="8" <%=isSelected(c,"8")%>>8</option>
    <option value="9" <%=isSelected(c,"9")%>>9</option>
    <option value="10" <%=isSelected(c,"10")%>>10</option>
    <option value="11" <%=isSelected(c,"11")%>>11</option>
    <option value="12" <%=isSelected(c,"12")%>>12</option>
    <option value="13" <%=isSelected(c,"13")%>>13</option>
    <option value="14" <%=isSelected(c,"14")%>>14</option>
    <option value="15" <%=isSelected(c,"15")%>>15</option>
    <option value="16" <%=isSelected(c,"16")%>>16</option>
    <option value="17" <%=isSelected(c,"17")%>>17</option>
    <option value="18" <%=isSelected(c,"18")%>>18</option>
    <option value="19" <%=isSelected(c,"19")%>>19</option>
    <option value="20" <%=isSelected(c,"20")%>>20</option>
    <option value="21" <%=isSelected(c,"21")%>>21</option>
    <option value="22" <%=isSelected(c,"22")%>>22</option>
    <option value="23" <%=isSelected(c,"23")%>>23</option>
    <option value="24" <%=isSelected(c,"24")%>>24</option>
    <option value="25" <%=isSelected(c,"25")%>>25</option>
    <option value="26" <%=isSelected(c,"26")%>>26</option>
    <option value="27" <%=isSelected(c,"27")%>>27</option>
    <option value="28" <%=isSelected(c,"28")%>>28</option>
    <option value="29" <%=isSelected(c,"29")%>>29</option>
    <option value="30" <%=isSelected(c,"30")%>>30</option>
    <option value="31" <%=isSelected(c,"31")%>>31</option>
    </select></td>
    
  </tr>
  <tr>
    <th>시간</th>	
    <td><select id="s_time" name="s_time">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
    <option value="11">11</option>
    <option value="12">12</option>
    <option value="13">13</option>
    <option value="14">14</option>
    <option value="15">15</option>
    <option value="16">16</option>
    <option value="17">17</option>
    <option value="18">18</option>
    <option value="19">19</option>
    <option value="20">20</option>
    <option value="21">21</option>
    <option value="22">22</option>
    <option value="23">23</option>
    <option value="24">24</option></select>시  </td>
  </tr>
   <tr>
    <th>일정 제목</th>	
    <td>
    <input type="text" name="s_title" maxlength="15">
    </td>
    </tr>
    <tr>
    <th>메모</th>	
    <td>
    <textarea rows="3" name="s_content" maxlength="10"></textarea>
    </td>
    </tr>
 </table>
 <input type=submit value="저장" name="action"><input type=reset value="취소">
 <br>
</div>
</form>
</section>
</body>
</html>