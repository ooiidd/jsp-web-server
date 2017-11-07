package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;
import com.saeyan.dto.MemberVO;

public class ikBoardWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		BoardVO bVo = new BoardVO();
		
		HttpSession session = request.getSession();
		MemberVO login = (MemberVO)session.getAttribute("loginUser");
		PrintWriter out = response.getWriter();
		int check;
		if(login == null ){
			out.println("<script>"); 
			out.println("location.href=\"Superser?command=home\""); 
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return;
		} else if((check=login.getAdmin()) == 1 ){
			out.println("<script>"); 
			out.println("location.href=\"Superser?command=loginhome\""); 
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return;
		}
		
		
		bVo.setUserid(login.getUserid());
		bVo.setName(login.getName());
		bVo.setHakbun(login.getHakbun());
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.insertBoard(bVo,"ikboard");
		
		
		
		response.sendRedirect("/Superser?command=ikboardList&page=1");
		
	}
}
