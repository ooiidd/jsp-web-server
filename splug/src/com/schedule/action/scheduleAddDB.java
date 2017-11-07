package com.schedule.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.ScheduleDAO;
import com.saeyan.dto.MemberVO;
import com.saeyan.dto.ScheduleVO;

public class scheduleAddDB implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/home/main.jsp";
		response.setContentType("text/html;charset=UTF-8");
		int check;
		PrintWriter out = response.getWriter(); 
		HttpSession session = request.getSession();
		MemberVO login = (MemberVO)session.getAttribute("loginUser");
		if(login == null ){
			out.println("<script>"); 
			out.println("alert('로그인 후 이용해 주세요.');"); 
			out.println("location.href=\"Superser?command=home\"");
			out.println("</script>");
			out.close();
		} else if((check=login.getAdmin()) == 1 ){
			out.println("<script>"); 
			out.println("alert('권한이 없습니다.');"); 
			out.println("location.href=\"Superser?command=loginhome\"");
			out.println("</script>");
			out.close();
		} else if((check=login.getAdmin()) == 2 ){
			out.println("<script>"); 
			out.println("alert('권한이 없습니다.');"); 
			out.println("location.href=\"Superser?command=loginhome\"");
			out.println("</script>");
			out.close();
		}else {
			ScheduleDAO dao = ScheduleDAO.getInstance();
			ScheduleVO vo = new ScheduleVO();
			vo.setS_year(Integer.valueOf(request.getParameter("s_year")));
			vo.setS_month(Integer.valueOf(request.getParameter("s_month")));
			vo.setS_day(Integer.valueOf(request.getParameter("s_day")));
			vo.setS_time(Integer.valueOf(request.getParameter("s_time")));
			vo.setS_title(request.getParameter("s_title"));
			vo.setS_content(request.getParameter("s_content"));
			dao.insert(vo);
			
			response.sendRedirect("/Superser?command=schedule_show");
		}
	}
}