package com.board.action;

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
import com.saeyan.dao.DatDAO;
import com.saeyan.dto.BoardVO;
import com.saeyan.dto.DatVO;
import com.saeyan.dto.MemberVO;

public class ikShowBoardAction implements Action {

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
			out.println("alert('권한이 없습니다 . 관리자에게 요청해 주세요.');"); 
			out.println("location.href=\"Superser?command=loginhome\"");
			out.println("</script>");
			out.close();
		} else if(check >= 2){
			url = "/board/ikboardView.jsp";
		}
		
		String num = request.getParameter("num");
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateReadCount(num,"ikboard");
		BoardVO bVo = bDao.selectOneBoardByNum(num,"ikboard");
		String str = bVo.getUserid();
		
		String content=bVo.getContent();
		content = content.replace("\r\n", "<br>");
		request.setAttribute("content", content);
		
		DatDAO Dao = DatDAO.getInstance();
		List<DatVO> datList = Dao.selectBoardDats("ikdat", num);
		
		
		
		request.setAttribute("dat", datList);
		request.setAttribute("check", str);
		request.setAttribute("board", bVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}