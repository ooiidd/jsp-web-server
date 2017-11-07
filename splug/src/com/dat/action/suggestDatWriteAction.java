package com.dat.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.DatDAO;
import com.saeyan.dto.DatVO;
import com.saeyan.dto.MemberVO;

public class suggestDatWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		DatVO bVo = new DatVO();
		String str1 = request.getParameter("table");
		String str2 = request.getParameter("num");
		
		HttpSession session = request.getSession();
		MemberVO login = (MemberVO)session.getAttribute("loginUser");
		PrintWriter out = response.getWriter();
		int check;
		if(login == null ){
			out.println("<script>"); 
			out.println("alert('로그인 후 이용해 주세요.');"); 
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return;
		} else if((check=login.getAdmin()) == 1 ){
			out.println("<script>"); 
			out.println("alert('권한이 없습니다 . 관리자에게 요청해 주세요.');"); 
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return;
		}
		
		
		bVo.setBoardnum(Integer.parseInt(str2));
		bVo.setUserid(login.getUserid());
		bVo.setName(login.getName());
		bVo.setContent(request.getParameter("content"));
		DatDAO bDao = DatDAO.getInstance();
		bDao.insertDat(bVo,str1+"dat");
		
		response.sendRedirect("/Superser?command="+str1+"_show"+"&num="+str2);
		
	}
}
