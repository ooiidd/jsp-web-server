package com.suggest.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dto.MemberVO;

public class suggestBoardWriteFormAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = "/suggest/suggestboardWrite.jsp";
		PrintWriter out = response.getWriter();
		int check;
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
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}
}
