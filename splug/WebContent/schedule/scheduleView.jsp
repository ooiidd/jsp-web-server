<%@ page info="diary calendar" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" import="java.sql.*,java.io.*,java.net.*,java.util.*, com.saeyan.dto.*" %>

 
<%
	
	response.setContentType("text/html;charset=UTF-8");
	String strYear = request.getParameter("year");
	String strMonth = request.getParameter("month");
	String query = new String();
	String url = new String();
	String selected = new String();
	
	//달력객체 생성
	Calendar myCalendar = Calendar.getInstance();
	
	int year = 0;
	int month = 0;
	int previous_year = 0;
	int previous_month = 0;
	int next_year = 0;
	int next_month = 0;
	int day = 0;
	int id = 0;
	
	
	int t_year = 0;
	int t_month = 0;
	int t_day = 0;
		
	t_year = myCalendar.get(myCalendar.YEAR);
	t_month = myCalendar.get(myCalendar.MONTH)+1;
	t_day = myCalendar.get(myCalendar.DAY_OF_MONTH);

	
	//디비 연결해서 객체 어레이리스트에 가져오기
	List<ScheduleVO> datas = (List<ScheduleVO>)request.getAttribute("datas");
	request.setAttribute("datas", datas);
	
	
	if (strYear == null) {
		year = myCalendar.get(myCalendar.YEAR);
	} else {
		year = Integer.parseInt(strYear);
	}
	
	if(strMonth == null) {
		month = myCalendar.get(myCalendar.MONTH);
	} else {
		month = Integer.parseInt(strMonth) -1;
	}
	
	myCalendar.set(myCalendar.YEAR, year);
	myCalendar.set(myCalendar.MONTH, month);
	month = month + 1;
	
	previous_year = myCalendar.get(myCalendar.YEAR) - 1;
	previous_month = myCalendar.get(myCalendar.MONTH);
	
	if (previous_month < 1) {
		previous_month = 12;
	} else if(previous_month > 12) {
		previous_month = 1;
	}
	
	next_year = myCalendar.get(myCalendar.YEAR) + 1;
	next_month = myCalendar.get(myCalendar.MONTH) + 2;
	
	if (next_month < 1) {
		next_month = 12;
	} else if (next_month > 12) {
		next_month = 1;
	}
	
	%>

<%--HTML 코드 시작--%>
<html>
<head>
<title>다이어리</title>
<style type="text/css">
<!--
A:link{font-size:9pt; font-family:"굴림"; text-decoration:none;color:#3E3E3E}
A:visited{font-size:9pt; font-family:"굴림"; text-decoration:none;color:#3E3E3E}
A:hover {font-size: 9pt; font-family:"굴림"; text-decoration: underline;color: #F29708;}

.title {font-size: 9pt; font-family:"굴림"; color:#504F4F}
-->
</style>
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
  <aside class="rightside">
	<div class="log">
		<p>${loginUser.userid}</p>
		<p>${loginUser.name }</p>
		<p>${loginUser.hakbun }</p>
		<a href="ik.do?command=self_update_form">정보 수정</a>
		<a href="Superser?command=logout">로그아웃</a>
	</div>
  </aside>
<section  LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0" >
<%--FORM 태그 시작--%>
<form method="post" action="ik.do">
<input type="hidden" name="command" value="schedule_show">

<table width="200" height="170" border="0" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td align="center" valign="top" >
		
		
	<table border="0" cellspacing="0" cellpadding="0" align="center" width="210" valign="top">
		<tr>
			<td width="10%" height="20" align="center">
				<a href="calendar.jsp?year=<%= previous_year %>&month=<%= month %>"><img src="image/left_year.gif" border="0" align="absmiddle"></a>
				<a href="calendar.jsp?year=<%= previous_month == 12 ? previous_year : year %>&month=<%= previous_month %>"><img src="image/left_month.gif" border="0" align="absmiddle"></a>
			</td>
			<td wdith="80%" align="center" class="title">
				<select name="year" style="background-color:#F5F7F8;" class="title">				
			<%
				for(int i = -5; i<5; i++){
					int temp_year = year + i;
					if (year == temp_year) {
						selected = "selected";
					} else{
						selected = "";
					}
			%>
					<option value = "<%= temp_year %>" <%= selected %>><%= temp_year %></option>
			<%
				}
			%>
				</select>년
				<select name="month" style="background-color:#F5F7F8;" class="title">
			<%
				for(int i = 1; i<=12; i++) {
					if (month == i) {
						selected = "selected";
					} else {
						selected = "";
					}
			%>
					<option value="<%= i %>" <%= selected %>><%= i %></option>
			<%
				}
			%>
				</select>월				
				<input type="submit" value="이동" style="border-width:1; color:#FFFFFF; background-color:#44A5E9;" class="title">
			</td>
			<td width="10%" align="center" >
				<a href="calendar.jsp?year=<%= next_month == 1 ? next_year : year%>&month=<%= next_month %>"><img src="image/right_month.gif" border="0" align="absmiddle"></a>
				<a href="calendar.jsp?year=<%= next_year %>&month=<%= month %>"><img src="image/right_year.gif" border="0" align="absmiddle"></a>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<table border="1" cellspacing="0" cellpadding="3" align="center" width="600" bordercolorlight="#EAFAE9" bordercolordark="#FFFFFF">
		<tr align="center" valing="middle">
			<td width="50" height="50" class="title"><font color="red">일</font></td>
			<td width="50" height="50" class="title">월</td>
			<td width="50" height="50" class="title">화</td>
			<td width="50" height="50" class="title">수</td>
			<td width="50" height="50" class="title">목</td>
			<td width="50" height="50" class="title">금</td>
			<td width="50" height="50" class="title"><font color="blue">토</font></td>
		</tr>
	<%
		while(true){
			day++;
			
			//날짜를 day 값으로 세팅
			myCalendar.set(myCalendar.DAY_OF_MONTH, day);
			
			//달력의 날짜가 다음달로 넘어가면 day 값이랑 달라짐
			if (day != myCalendar.get(myCalendar.DAY_OF_MONTH)) {
				break;
			}
			
			if (day == 1) {
				out.println("<tr align='right' valign='top'>");
				
				//요일 수만큼 빈칸 만들기
				for (int j = 1; j < myCalendar.get(myCalendar.DAY_OF_WEEK); j++) {
					out.print("<td width='50' height='50'>&nbsp;</td>");
				}
			}
			
			if (id > 0) {
				out.println("<td width='50' height='50' background='image/is_bg.gif'>");
				url = "view.jsp?id="+id+"&mode=view";
			} else {
				out.println("<td width='50' height='50'>");
				url = "add.jsp?year="+year+"&month="+month+"&day="+day+"&mode=insert";
				url = "ik.do?command=schedule_add&year="+year+"&month="+month+"&day="+day;
			}
			out.println("<a href='"+url+"'>");

			if (t_year == year && t_month == month && t_day == day) 
			{
				//오늘일 경우 폰트는 크고 색깔은 초록으로				
				out.println("<font color=#2F9D27><b>");
				out.println(myCalendar.get(myCalendar.DAY_OF_MONTH));
				out.println("</b></font>");
			
			}
			//요일이 일요일이면 빨간색으로 표시
			else if (myCalendar.get(myCalendar.DAY_OF_WEEK) == myCalendar.SUNDAY) {
				out.println("<font color=red>");
				out.println(myCalendar.get(myCalendar.DAY_OF_MONTH));
				out.println("</font>"); 
				
			} else if (myCalendar.get(myCalendar.DAY_OF_WEEK) == myCalendar.SATURDAY) {
				//요일이 토요일이면 파란색으로 표시					
				out.println("<font color=blue>");
				out.println(myCalendar.get(myCalendar.DAY_OF_MONTH));
				out.println("</font>");
				
			} 
			else {
				out.println(myCalendar.get(myCalendar.DAY_OF_MONTH));
			}
			
			//데이터베이스에 일정 정보 가져오기
			for(ScheduleVO ab : (ArrayList<ScheduleVO>)datas)
			{
				if(year == ab.getS_year() && month == ab.getS_month() && day == ab.getS_day())
				{
					out.println("<b><br>");
					out.println(ab.getS_time() + "시 ");
					out.println(ab.getS_title()+"<br></b>");
					out.println(ab.getS_content());	
				}
			}
			
			out.println("</a></td>");
			
			//요일이 토요일이면 다음줄로 내림
			if (myCalendar.get(myCalendar.DAY_OF_WEEK) == myCalendar.SATURDAY) {
				out.println("</tr>");
				out.println("<tr align='right' valign='top'>");
			}
		}
		
		
		//마지막이 토요일로 끝나지 않았으면 줄을 닫아줌
		if (myCalendar.get(myCalendar.DAY_OF_WEEK) != myCalendar.SATURDAY){
			out.println("</tr>");
		}
		
	%>
	
	</table>
</form>
</section>
</body>
</html>
		