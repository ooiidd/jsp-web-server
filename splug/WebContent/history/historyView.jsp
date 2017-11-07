<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>연혁</title>
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
		<a href="Superser?command=logout">로그아웃</a>
	</div>
  </aside>
  <section>
  <p><b>SPLUG 역사</b><br>
  1997~1998년도 12월~1월쯤 당시 리눅스에 열정을 보여 컴퓨터학부 선배이신 장승규님의 제안으로 장승규외 3인이 모여 스플럭의 홈페이지를 처음으로 가동하기 시작했습니다. (Open.ssu.ac.kr) 그 때는 소모임이라는 개념 보다 그냥 좋아서 공부하고 그런 동기였습니다. 그러다가 1998년 5월 숭실대학교 컴퓨터학부 한 강의실에 여러 명이 모여 Linux운영체제에 관한 정보 공유와 관련 기술 개발, 서버 운영등의 목적으로 SPLUG (Soongsil Power Linux User Group)이란 이름을 짓고 정식 소모임으로 발돋음 하였습니다.<br><br>

<b>SPLUG 연혁<br>
  1997~1998 년도 (회장 : 이순신)</b><br>
    -SPLUG 창단 및 1 기 모집(정회원 7 인)<br>
    -SPLUG 홈페이지 구축 (http://open.ssu.ac.kr)<br>
    -제 1 회 Linux Open Seminar 개최 - 리눅스 소개, 설치, X윈도우 설정<br>
    -Summer Project 주제 : 웹상에서의 리눅스 관리<br><br>

  <b>1999 년도 (회장 : 김봉규)<br></b>
    -2기 모집(정회원 4명 승격)<br>
    -제 2 회Linux Open Seminar 개최 - 리눅스 기초(일반 유저 대상)<br>
    -SPLUG Homepage 1 차 Update<br><br>

  <b>2000 년도 (회장 : 김봉규)<br></b>
    -3기 모집(정회원 7 명 승격)<br>
    -SPLUG Homepage 2 차 Update<br>
    -SPLUG STUDY (Linux 에서의 웹 서버 구축 APM, JAVA, 시스템프로그래밍)<br><br>

  <b>2001 년도 (회장 : 정성재)<br></b>
    -4기 모집(정회원 12 명 승격)<br>
    -SPLUG Homepage 3 차 Update<br>
    -제 3 회 Linux Open Seminar 개최 - 리눅스 설치 및 응용프로그램(VMWare, <br>
     Wine, Office, X-Manager, Multimedia) - 후원 : 한컴 리눅스<br>
    -SPLUG STUDY (Linux 기초, C 초 중급, 분산객체, Kernel)<br>
    -Summer Project : 오픈메신저, Linux USB Driver<br>
    -연합 러그 엠티 ( 9월 28~29일 )<br>
    -에릭레이몬드 Open Source Seminar 진행 보조<br><br>

  <b>2002 년도 (회장 : 조규하)<br></b>
	-5기 모집<br><br>

  <b>2003 년도 (회장 : 이희원)<br></b>
    -6기 모집<br>
    -신입생 대상 리눅스 세미나 개최 - (리눅스란?, 리눅스 설치, 리눅스 명령어, 리눅스에서의 어플리케이션, VI사용 TIP)
    -여름방학 릴레이 세미나 - (Linux Device Driver, C Library, LVM, RTOS, <br>
                    Database, Ncurses, Kernel Compile, Wine, rsync, 암호화 관리, PHP, Cron)<br>
    -SPLUG STUDY (Linux기초, C기초, C중급, JAVA, Linux 실습, JBuilder, PHP, 자료구조, 알고리즘)<br>
    -상반기 연합 세미나 발표 - SDL(Simple Direct Layer)Library<br>
    -제 5회 Linux Open Seminar 개최 - (WIKI, ACID&SNORT, KERNEL2.6, Embedded Linux)<br>
    -소프트웨어 공모전 준비 프로젝트<br>
      - PLUG ( Telent , FTP 동시접속 프로그램 )<br>
      - SPLUG ACID ( 리눅스 기반의 자동침입대응 시스템 ) - 소공전 은상수상<br>
      -하반기 연합 세미나 발표 - Kerberos<br>
      -홈커밍데이 : SPLUG 최초 홈커밍 데이<br>
      -YTN 촬영 : YTN 과학과 미래 코너에 출연함<br>
      -KELP 세미나 주최 : 정보대 102호 (SPLUG 주최)<br>
      -마이크로소프트웨어 "스터디그룹탐방" 인터뷰<br><br>
	
  <b>2004 년도 (회장 : 양정우)<br></b>
    -7기 모집<br><br>
  
  <b>2005 년도 (회장 : 구범회)<br><br></b>

  <b>2006 년도 (회장 : 김진우)<br></b>
    -9기 모집(정회원 12명 승격)<br>
    -신입생 대상 리눅스 세미나 개최 - (스플럭이란?, 리눅스란?, 리눅스 설치 및 x-window구현, vi사용 TIP, 리눅스 사용시 유의할점 10가지)<br>
    -전반기 연합 세미나 발표 - XGL 설치 및 구현<br>
    -SPLUG STUDY(LINUX 기초, C언어 기초, C언어 중급, LINUX 중급, JAVA 초급, PYTHON 초급)<br>
    -홈퍼밍데이 개최<br>
    -정과학대학 소프트웨어 공모전 입상 - (대상:포세이돈, 은상:MCS, 동상:INFOMICRO)<br>
    -하반기 연합 세미나 발표 - GDB 와 DDD를 이용한 디버깅 기법<br>
    -SPLUG OPEN 세미나 개최 - (VMWARE를 이용한 O/S사용, CRONE을 이용한 백업, TDD를 이용한 프로그래밍 기법)<br><br>

  <b>2007 년도 (회장 : 유정헌)<br><br></b>
  
  <b>2008 년도 (회장 : 박보규, 부회장 : 구범회)<br></b>
    -  대상 : Active Ubiquitous System (02 이희원, 04구범회, 05 김진우)<br>
    -  금상 : Multi touch Interface system using Wii mote (04 김남현, 04 최원영, 04강민욱)<br>
    -  은상 : m-Presentator(03 김재현 외 2명)<br>
    -  장려 : 실시간 환자 상태 감시 시스템(Ubiq-Health) (05 박보규, 05 신현욱, 05 최재원)<br><br>

  <b>2009 년도 (회장 : 정민성, 부회장 : 유정호)<br><br></b>

  <b>2010 년도 (회장 : 조지은, 부회장 : 최재원)<br><br></b>

  <b>2011 년도 (회장 : 김현진, 부회장 : 김지연)<br></b>
	- 14기 정회원 11명 모집<br>
	- 신입생 대상 리눅스 세미나 개최 (3 / 17)<br>
	- 한강 소풍 (4 / 9)<br>
	- 체육대회 및 10회 홈커밍데이 개최 (5 / 14)<br>
	- 하계 대성리 엠티 (7 / 28 ~ 7 / 29)<br>
	- 학부생 대상 리눅스 세미나 (리눅스 설치, 프로그래밍 환경 설정, gdb 사용법, 유저 관리, APM 설치및 서버 운영) (8월 한달간 주 2회)<br>
	- 교내 소프트웨어 공모전<br>
	  	대상 : I-Quad (05 유정헌, 06 이준영, 06 김충희, 10 박성진(SCCC))<br>
	  	장려 : Impressive Presentation Tool (07 김현진, 10 김효정, 09 이준서(SCCC))<br>
	- 공개 소프트웨어 개발자 대회<br>
	  	은상 : EzTrans (07 채장희, 07 김선영, 10 강윤경)<br>
	- ULUG 연합 홈페이지 개편 (13기 이진혁, 10기 김현진, 13기 차지원)<br>
	- ULUG 연합 세미나 (발표 : 13기 이진혁 "ULUG 홈페이지 개편")<br>
	- 13회 Open 세미나 개최 (12 / 3)<br>
		.소셜네트워크의 수익모델 (14기 정상혁, 14기 안주열)<br>
		.통합 플랫폼 Tizen (10기 유정호, 14기 박경준)<br>
		.L.T.E (13기 오정훈, 14기 송지은, 14기 박정우)<br>
		.VIM 활용법 (14기 김세환, 14기 진서영, 14기 황수경)<br>
		.Code Igniter를 이용한 php 게시판 만들기 (13기 김지연, 13기 이지연, 13기 김효정)<br>
		.HTML5 (10기 채장희, 13기 강윤경, 14기 정지연)<br>
		.스티브 잡스 (8기 유정헌, 14기 장현우)<br>
		.아이폰을 이용한 쿼드콥터 컨트롤 (8기 유정헌, 9기 이준영<br><br>

    <b>2012 년도 (회장 : 정병우, 부회장 : 송지은)<br></b>
	- 15기 정회원 20명 모집<br>
	- 삼성 트랙 인턴 후 최종합격 (14기 진서영)<br>
	- 1학년 대상으로 C언어 스터디 활동 (타 소모임 포함 30명 참여)<br><br>

    <b>2013 년도 (회장 : 채수민, 부회장 : 김홍석)<br></b>
	- 16기 정회원 10명 모집<br>
	- 삼성 트랙 인턴 후 최종합격 (15기 황재경)<br>
	- 1학년 대상으로 C언어 스터디 활동 (타 소모임 포함 20명 참여)<br>
	- 스플럭 최초로 2인 1맨토 시스템 도입<br><br>

    <b>2014 년도 (회장 : 장현우, 부회장 : 정대철)<br></b>
        - 17기 정회원 9명 모집<br>
	- SPLUG 봄 소풍<br>
	- C 스터디 진행<br>
	- 아이디어 공모전 실시<br>
	- 동계,하계 대성리 엠티<br>
	- 대학 연합 리눅스 유저그룹 ULUG 연합 세미나<br>
		YLUG – SQLAlchecmy<br>
		GNUVILL – Robocar와 HEBE-SM-2 기반의 Auto<br>
		Solux – Python과 Pycon<br>
		SPLUG – OpenSSL<br>
		CLUG – JPEG Image Compression<br><br>

	- 제 26회 글로벌 SW공모대전<br>
		동상 : 김봉준 김준호 조선영 (한국 정보화 진흥원)<br>
	- 창업 경진대회<br>
		최우수상 : 장현우 김동은 홍성웅 ( 숭실대학교 )<br>
	- Start-up 창업캠프<br>
		최우수상 : 김봉준 김준호 김동은 ( 숭실대학교 )<br>
	- 교내 소프트웨어 공모전<br>
		장려상 : Post Memories(차지원 오우석 이지연 진서영)<br>
	- 제3회 숭실 산업융합 아이디어 공모전<br>
		장려상 : VIVE (강성규 김성수 최사무엘 김유정)<br>
	- 대국민 아이디어 공모전<br>
		우수상 : 김동은 진은총 ( 한국 항공 우주 연구원 )<br>
	- 제7회 학생 포트폴리오 경진대회<br>
		은상 : 김동은 ( 숭실대학교 )<br>
	- 제 9회 PSV 창업스쿨 & 창업경진대회<br>
		우수상 : 해피마이애미(김동은,이지혜,박경희) - 대전 충남지방 중소기업 청장<br>
	- 창의적 공학설계 전시회<br>
		은상 : 에이쁠 Tetrees (신태수 박민진 신윤희 전지훈)<br>
		동상 : TET SSUTRIS (현재일 최혜정 김창엽 오서원)<br>
		동상 : 특이한연구소 Coop-Escaper (송누리 지화영 송누리 최종근)<br><br>


    <b>2015 년도 (회장 : 현재일, 부회장 : 김형빈)<br></b>
        - 18기 정회원 22명 모집<br>
        - 현재 IT 주력기술 및 기업 분석 세미나 & 취업 세미나 진행<br>
	- 외국계 기업 취업하기 세미나 강연( SPLUG 02 이민섭 선배님)<br>
	- ULUG 대한민국 유일 Software Freedom day 연합 SPLUG 진행 <br>
	  (전 세계 중 대한민국에선 유일하게 ULUG에서 진행 )<br>
	- 신입생 세미나 (학점&학교생활 가이드, 군대 Tip, 컴퓨터 언어에 대한 간단 분석)<br>
        - SPLUG 여의나루 봄 소풍<br>
	- SPLUG 5월 MT & 학업 관련 Recreation <br>
	- 대학 연합 리눅스 유저 그룹 ULUG 4월 연합 세미나 SPLUG 대표 참석 진행<br>
	- 대학 연합 리눅스 유저 그룹 ULUG 8월 연합 세미나 SPLUG OPEN –STACK 주제 연구 발표 <br>
	- 공개SW개발자센터 & nipa & Open Technet 후원 대학 연합 리눅스 유저그룹 ULUG 에서 연합 세미나 SPLUG - 해킹기술 연구 결과 시현 및 발표 (Buffer Overflow, <br>               RTL 해킹 기술)
        - C언어 과외 스터디 4인 1조, 14조 편성 후 주기적으로 진행 <br>
        - 신입생 50명 대상 Linux 스터디 진행 (Linux 기초 다지기 및 심화 분석)<br>
	- 2학년 대상 Java스터디 형성 진행<br>
	- 스플럭 최초 로고 디자인 창설<br>
	- SPLUG 동아리 잠바 신청 구입<br>
	- 대학 연합 리눅스 유저 그룹 ULUG Linux Project & Study<br>
	  (현재일 김형빈 전민호 이은솔 김도현 김수만)<br>
        - 선배님들과 함께하는 홈커밍 데이 개최<br>
	- SPLUG 홍대 파티룸 무료 엠티 행사<br>
        - 도서 구입 비용 지원 사업 진행 ( 교제 구입비용 3/4 회비 지원 )<br>
	- 필요 도서 투표 추천 구입 사업 진행<br>
        - A4용지 7천장 회비 구입 SPLUG 회원에게 기부사업 진행<br>
	- Open.ssu.ac.kr 서버 및 홈페이지 재구축 진행<br>
	- Open.ssu.ac.kr SSH 서버에 SPLUG 회원 인당 개인 계정 생성 후 사용 진행 <br>
	- 참여 유도를 위한 상/벌점제 재 도입<br><br>

	-제 42회 동계학술 발표회<br>
		우수 논문상 (안드로이드 플랫폼 기반 프로세스 모니터링을 이용한 랜섬웨어 방지 시스템의 설계 및 구현) : 김봉준(팀장),김운수 – 한국정보과학회<br><br>

	-한국 정보화 진흥원 프로그래밍 경시대회<br>
		동상 : 김형빈,박정우 (Coding Amolang팀)<br><br>

	- Certificate of Achievement (acm)<br>
		ACM-ICPC Asia Daejeon KAIST 6-7,November,2015 : Park Jeong Woo ,Hyeong bin Kim<br><br>

	-서울어코드 활성화 지원사업단<br>
		우수성과학생공모전 입상 (이상기후) : 김봉준 김운수<br>
		우수성과학생공모전 입상 (Coding_Amolang) : 박정우 김형빈<br>
		우수성과학생공모전 입상 (SPLUG) : 김홍기 김준석 정대철 남궁준 우정미<br>
		우수성과학생공모전 입상 (그리디 꿈) : 박정우<br><br>

	- 2015 ACM/ICPC 국제 대학생 프로그래밍 대회 국내 예선<br>
		교내 1위 (Coding_Amolang팀) : 박정우 김형빈<br>
		교내 3위(www.mma.go.kr팀) : 김한재<br><br>

	- 교내 SW공모전<br>
		금상 (MapTalk) : 박정우<br>
		동상 (모바일 랜섬웨어 방지 솔루션) : 김봉준 김운수<br>
		동상 (ITK와 VTK를 활용한 의료 데이터 처리 소프트웨어) :  박정우 이규현<br><br>

	- 제5회 캡스톤 디자인 경진대회<br>
		장려상(이상기후) : 김봉준 김운수 – 숭실대학교<br>
		장려상(SPLUG) : 김홍기 정대철 김준석 남궁준 우정미 – 숭실대학교<br><br>


	- 한이음 엑스포 2015 공모전<br>
		입선 (이상기후) : 김봉준 김운수 – 정보통신기술진흥센터장<br>
		입선 (SPLUG팀) : 김준석 김홍기 남궁준 우정미 정대철 – 정보통신기술진흥센터장<br>

	- 제3회 숭실 특허경진대회<br>
		최우수상 : 박정우 – 숭실대학교<br><br>

	- 창의적 공학설계 전시회<br>
		금상 (B.E.S.T) : 장현우 –엘리베이터 과금 시스템<br>
		은상 (MadMax) : 정지수 - 오빠차 티코<br>
		동상 (GaSa) : 임경현 – moms touch<br>
		동상 (Mr.Drum) : 이현빈 – Drum Helper<br><br>
		
	- 2015 빅데이터 경진대회<br>
		최우수상 : 신용구 박상순 하현수 – POV를 이용한 장식 및 교육기구 COMOS<br>
		최우수상 : 정훈 – 3D Priter와 근전도 센서를 이용한 전자의수<br><br>
  
  </p>
  </section>




</body>
</html>