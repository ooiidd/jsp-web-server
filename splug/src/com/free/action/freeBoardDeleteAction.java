package com.free.action;

import java.io.IOException;
import java.io.PrintWriter;
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

public class freeBoardDeleteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int check;
		response.setContentType("text/html;charset=UTF-8");
		String url = "/home/main.jsp";
		BoardDAO bDao = BoardDAO.getInstance();
		String str=request.getParameter("num");
		
		PrintWriter out = response.getWriter();  
		BoardVO dVo=bDao.selectOneBoardByNum(str, "freeboard");
		
		
		HttpSession session = request.getSession();
		MemberVO login = (MemberVO)session.getAttribute("loginUser");
		if(dVo.getUserid().equals(login.getUserid()) ){
			bDao.deleteBoard(str, "freeboard");
			response.sendRedirect("/ik.do?command=freeboardList&page=1");
			return;
		} else if(login==null){
			out.println("<script>"); 
			out.println("alert('잘못된 접근 입니다.');"); 
			out.println("location.href=\"Superser?command=home\"");
			out.println("</script>");
			out.close();
			return;
		} else{
			out.println("<script>"); 
			out.println("alert('권한이 없습니다 관리자에게 요청해 주세요.');");
			out.println("location.href=\"Superser?command=loginhome\"");
			out.println("</script>");
			out.close();
			return;
		}
	}
}