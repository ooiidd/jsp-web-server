package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardDAO;
import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.BoardVO;
import com.saeyan.dto.MemberVO;

/**
 * Servlet implementation class Superser
 */
@WebServlet("/Superser")
public class Superser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Superser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println("요청을 받음을 확인 : " + command);
		ActionFactory af=ActionFactory.getInstance();
		Action action=af.getAction(command);
		if(action != null){
		action.execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String url = "home/main.jsp";
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		System.out.println(userid);
		System.out.println(userid+"  "+pwd);
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.userCheck(userid, pwd);

		PrintWriter out = response.getWriter(); 
		if (result == 1) {
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
			MemberVO mVo = mDao.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			
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
			
			session.setMaxInactiveInterval(60*100);
			url = "home/mainlogin.jsp";
		} else if (result == 0) {
			out.println("<script>"); 
			out.println("alert('비밀번호가 틀렸습니다.');"); 
			out.println("location.href=\"Superser?command=home\"");
			out.println("</script>");
			out.close();
			return;
		} else {
			out.println("<script>"); 
			out.println("alert('존재하지 않는 회원입니다.');"); 
			out.println("location.href=\"Superser?command=home\"");
			out.println("</script>");
			out.close();
			return;
		} 
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
