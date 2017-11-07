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

public class memberUpdate implements Action{
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
		
		int t = login.getAdmin();
		List<MemberVO> memberList = bDao.memberManage(t);
		request.setAttribute("member", memberList);
		int admin = Integer.valueOf(request.getParameter("admin"));
		if(login == null ){
			out.println("<script>"); 
			out.println("alert('로그인 후 이용해 주세요.');");
			out.println("location.href=\"Superser?command=home\"");
			out.println("</script>");
			out.close();
			return;
		} else if(  (check=login.getAdmin()) == 1 || login.getAdmin()==2){
			out.println("<script>"); 
			out.println("alert('권한이 없습니다 관리자에게 요청해 주세요.');");
			out.println("location.href=\"Superser?command=loginhome\"");
			out.println("</script>");
			out.close();
			return;
		} else if(check >= 3){
			if(login.getAdmin()>admin){
				String id=request.getParameter("id");
				bDao.updateAdmin(id, admin);
			}
			response.sendRedirect("/ik.do?command=member");
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
