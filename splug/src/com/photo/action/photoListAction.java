package com.photo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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

public class photoListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/photo/photoList.jsp";
		int check;
		response.setContentType("text/html;charset=UTF-8");
		imgBoardDAO bDao = imgBoardDAO.getInstance();
		String str=request.getParameter("page");
		int t = Integer.parseInt(str);
		PrintWriter out = response.getWriter();  
		List<String> main_img = new ArrayList<String>();
		
		List<imgBoardVO> boardList = bDao.selectPartBoards("imgboard",(t-1)*10+1,t*10);
		request.setAttribute("boardList", boardList);
		request.setAttribute("nowpage", t);
		int tablenum=bDao.tableNumber("imgboard");
		request.setAttribute("tablenum", tablenum );
		
		int i =0;
		Iterator iterator = boardList.iterator();
		while(iterator.hasNext()){
			imgBoardVO a=boardList.get(i);
			if(a.getImg() != null){
				StringTokenizer strToken = new StringTokenizer(a.getImg(),"|");
				main_img.add(strToken.nextToken());
			}else{
				main_img.add("");
			}
			iterator.next();
			i++;
		}
		
		request.setAttribute("main_img", main_img);
		HttpSession session = request.getSession();
		MemberVO login = (MemberVO)session.getAttribute("loginUser");
		if(login == null ){
			out.println("<script>"); 
			out.println("alert('로그인 후 이용해 주세요.');"); 
			out.println("location.href=\"Superser?command=home\"");
			out.println("</script>");
			out.close();
			url = "/home/main.jsp";
		} else if((check=login.getAdmin()) == 1 ){
			out.println("<script>"); 
			out.println("alert('권한이 없습니다 관리자에게 요청해 주세요.');"); 
			out.println("location.href=\"Superser?command=loginhome\"");
			out.println("</script>");
			out.close(); 
		} else if(check >= 2){
			url = "/photo/photoList.jsp";
		}	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}