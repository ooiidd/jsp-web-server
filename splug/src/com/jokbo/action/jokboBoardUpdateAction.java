package com.jokbo.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.imgBoardDAO;
import com.saeyan.dto.MemberVO;
import com.saeyan.dto.imgBoardVO;

public class jokboBoardUpdateAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int check;
		response.setContentType("text/html;charset=UTF-8");
		String url = "/home/main.jsp";
		imgBoardDAO bDao = imgBoardDAO.getInstance();
		String str=request.getParameter("num");
		
		PrintWriter out = response.getWriter();  
		imgBoardVO dVo=bDao.selectOneBoardByNum(str, "jokboboard");
		
		
		HttpSession session = request.getSession();
		MemberVO login = (MemberVO)session.getAttribute("loginUser");
		
		imgBoardVO bVo = new imgBoardVO();
		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		
		if(dVo.getUserid().equals(login.getUserid()) || login.getAdmin()>=3){
			bDao.updateIkBoard(bVo, "jokboboard");
			response.sendRedirect("/ik.do?command=jokboboardList&page=1");
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
	