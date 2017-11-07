package com.jokbo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.imgBoardDAO;
import com.saeyan.dto.MemberVO;
import com.saeyan.dto.imgBoardVO;

public class jokboShowBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/home/main.jsp";
		int check;
		
		response.setContentType("text/html;charset=UTF-8");
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
			out.println("alert('로그인 후 이용해 주세요.');"); 
			out.println("location.href=\"Superser?command=loginhome\"");
			out.println("</script>");
			out.close();
		} else if(check >= 2){
			url = "/jokbo/jokboboardView.jsp";
		}
		
		String num = request.getParameter("num");
		imgBoardDAO bDao = imgBoardDAO.getInstance();
		bDao.updateReadCount(num,"jokboboard");
		imgBoardVO bVo = bDao.selectOneBoardByNum(num,"jokboboard");
		String str = bVo.getUserid();
		System.out.println(str);
		request.setAttribute("check", str);
		request.setAttribute("board", bVo);
		str=bVo.getImg();
		
		String content=bVo.getContent();
		content = content.replace("\r\n", "<br>");
		request.setAttribute("content", content);
		
		List<String> image = new ArrayList<String>();
		List<String> usershow = new ArrayList<String>();
		StringTokenizer strToken = new StringTokenizer(str,"|");
		while(strToken.hasMoreTokens()){
			
			String kk = new String();
			image.add(kk=strToken.nextToken());
			System.out.println(kk);
			StringTokenizer tok = new StringTokenizer(kk,"_");
			tok.nextToken();
			String a="";
			while(tok.hasMoreTokens()){
				a=a+tok.nextToken();
				if(tok.hasMoreTokens()){
					a=a+"_";
				}
			}
			usershow.add(a);
		}
		request.setAttribute("item", image);
		request.setAttribute("useritem", usershow);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}