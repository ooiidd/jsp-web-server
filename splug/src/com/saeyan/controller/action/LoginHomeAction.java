package com.saeyan.controller.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;
import com.saeyan.dto.MemberVO;

public class LoginHomeAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		BoardDAO bDao = BoardDAO.getInstance();
		List<BoardVO> noticeboardList = bDao.selectPartBoards("noticeboard",1,5);
		List<BoardVO> freeboardList = bDao.selectPartBoards("freeboard",1,5);
		List<BoardVO> ikboardList = bDao.selectPartBoards("ikboard",1,5);
		List<BoardVO> qnaboardList = bDao.selectPartBoards("qnaboard",1,5);
		List<BoardVO> suggestboardList = bDao.selectPartBoards("suggestboard",1,5);
		request.setAttribute("notice", noticeboardList);
		request.setAttribute("free", freeboardList);
		request.setAttribute("ik",ikboardList);
		request.setAttribute("qna", qnaboardList);
		request.setAttribute("suggest", suggestboardList);
		
		Date d = new Date();
		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
		String a1=today.format(d);
		
		int i =0;
		List<Integer> noticedate = new ArrayList<Integer>();
		Iterator iterator = noticeboardList.iterator();
		while(iterator.hasNext()){
			BoardVO a=noticeboardList.get(i);
			if(a1.equals(today.format(a.getWritedate()))){
				noticedate.add(1);
			}else{
				noticedate.add(0);
			}
			iterator.next();
			i++;
		}
		request.setAttribute("notice_new", noticedate);
		
		i=0;
		List<Integer> freedate = new ArrayList<Integer>();
		iterator = freeboardList.iterator();
		while(iterator.hasNext()){
			BoardVO a=freeboardList.get(i);
			if(a1.equals(today.format(a.getWritedate()))){
				freedate.add(1);
			}else{
				freedate.add(0);
			}
			iterator.next();
			i++;
		}
		request.setAttribute("free_new", freedate);
		
		i=0;
		List<Integer> ikdate = new ArrayList<Integer>();
		iterator = ikboardList.iterator();
		while(iterator.hasNext()){
			BoardVO a=ikboardList.get(i);
			if(a1.equals(today.format(a.getWritedate()))){
				ikdate.add(1);
			}else{
				ikdate.add(0);
			}
			iterator.next();
			i++;
		}
		request.setAttribute("ik_new", ikdate);
		
		i=0;
		List<Integer> qnadate = new ArrayList<Integer>();
		iterator = qnaboardList.iterator();
		while(iterator.hasNext()){
			BoardVO a=qnaboardList.get(i);
			if(a1.equals(today.format(a.getWritedate()))){
				qnadate.add(1);
			}else{
				qnadate.add(0);
			}
			iterator.next();
			i++;
		}
		request.setAttribute("qna_new", qnadate);
		
		i=0;
		List<Integer> suggestdate = new ArrayList<Integer>();
		iterator = suggestboardList.iterator();
		while(iterator.hasNext()){
			BoardVO a=suggestboardList.get(i);
			if(a1.equals(today.format(a.getWritedate()))){
				suggestdate.add(1);
			}else{
				suggestdate.add(0);
			}
			iterator.next();
			i++;
		}
		request.setAttribute("suggest_new", suggestdate);
		
		
		String url = "/home/main.jsp";
		MemberVO login = (MemberVO)session.getAttribute("loginUser");
		if(login == null ){
			url = "/home/main.jsp";
		}else{
			url = "/home/mainlogin.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}