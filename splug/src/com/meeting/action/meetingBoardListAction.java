package com.meeting.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;
import com.saeyan.dto.MemberVO;

public class meetingBoardListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int check;
		response.setContentType("text/html;charset=UTF-8");
		String url = "/home/main.jsp";
		BoardDAO bDao = BoardDAO.getInstance();
		String str=request.getParameter("page");
		int t = Integer.parseInt(str);
		PrintWriter out = response.getWriter();  
		
		List<BoardVO> boardList = bDao.selectPartBoards("meetingboard",(t-1)*15+1,t*15);
		request.setAttribute("boardList", boardList);
		request.setAttribute("nowpage", t);
		int tablenum=bDao.tableNumber("meetingboard");
		request.setAttribute("tablenum", tablenum );
		HttpSession session = request.getSession();
		MemberVO login = (MemberVO)session.getAttribute("loginUser");
		
		Date d = new Date();
		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
		String a1=today.format(d);
		
		int i =0;
		List<Integer> date = new ArrayList<Integer>();
		Iterator iterator = boardList.iterator();
		while(iterator.hasNext()){
			BoardVO a=boardList.get(i);
			if(a1.equals(today.format(a.getWritedate()))){
				date.add(1);
			}else{
				date.add(0);
			}
			iterator.next();
			i++;
		}
		request.setAttribute("new_img", date);
		
		if(login == null ){
			out.println("<script>"); 
			out.println("alert('로그인 후 이용해 주세요.');");
			out.println("location.href=\"Superser?command=home\"");
			out.println("</script>");
			out.close();
			return;
		} else if((check=login.getAdmin()) == 1 ){
			out.println("<script>"); 
			out.println("alert('권한이 없습니다 관리자에게 요청해 주세요.');");
			out.println("location.href=\"Superser?command=loginhome\"");
			out.println("</script>");
			out.close();
			return;
		} else if(check >= 2){
			url = "/meeting/meetingboardList.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
