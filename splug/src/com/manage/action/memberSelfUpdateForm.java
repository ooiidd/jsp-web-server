package com.manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.BoardVO;
import com.saeyan.dto.MemberVO;

public class memberSelfUpdateForm implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = "/home/main.jsp";
		MemberDAO bDao = MemberDAO.getInstance();
  
		
		PrintWriter out = response.getWriter();
		int check;
		HttpSession session = request.getSession();
		MemberVO login = (MemberVO)session.getAttribute("loginUser");
		MemberVO member = bDao.getMember(login.getUserid());
		if(login == null ){
			out.println("<script>"); 
			out.println("alert('로그인 후 이용해 주세요.');");
			out.println("location.href=\"Superser?command=home\"");
			out.println("</script>");
			out.close();
			return;
		} else{
			request.setAttribute("member", member);
			url="home/memberUpdate.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
