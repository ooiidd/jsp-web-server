package com.jokbo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.imgBoardDAO;
import com.saeyan.dto.MemberVO;
import com.saeyan.dto.imgBoardVO;

public class jokboSearchAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/board/ikboardSearchList.jsp";
		int check;
		imgBoardDAO bDao = imgBoardDAO.getInstance();
		String option = request.getParameter("search_option");
		String text = request.getParameter("search_text");
		System.out.println(option + "'%    %'"+text);
		List<imgBoardVO> boardList = bDao.selectSearchBoards("jokboboard",option,text);
		request.setAttribute("boardList", boardList);
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		MemberVO login = (MemberVO)session.getAttribute("loginUser");
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
			url = "/jokbo/jokboboardSearchList.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
