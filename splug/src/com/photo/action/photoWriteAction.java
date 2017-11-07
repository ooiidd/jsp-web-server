package com.photo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.saeyan.dao.imgBoardDAO;
import com.saeyan.dto.MemberVO;
import com.saeyan.dto.imgBoardVO;

/**
 * Servlet implementation class photoWriteAction
 */
@WebServlet("/photo.do")
public class photoWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public photoWriteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
	private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String url = "/photo/photoList.jsp";
		String title="",content="";
		String database="";
		imgBoardVO bVo = new imgBoardVO();
		HttpSession session = request.getSession();
		MemberVO login = (MemberVO)session.getAttribute("loginUser");
		imgBoardDAO bDao = imgBoardDAO.getInstance();

		PrintWriter out = response.getWriter();
		int check;
		if(login == null ){
			out.println("<script>"); 
			out.println("alert('잘못된 접근 입니다.');"); 
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
		}
		
		
		
		if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
		DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        upload.setSizeMax(MAX_REQUEST_SIZE);
 
        String uploadPath = getServletContext().getRealPath("")
        		+ File.separator + "imgboard";
         
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
 
        try {
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
            	
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        	String fileName = new File(item.getName()).getName();
                        if(fileName != ""){
                        	fileName= System.currentTimeMillis()+"_"+fileName;
                        
                        	String filePath = uploadPath + File.separator + fileName;
                        	File storeFile = new File(filePath);
                        	System.out.println("저장 경로 : "+ filePath);
                        	item.write(storeFile);
                        	request.setAttribute("message",
                        		"Upload has been done successfully!");
                        	if(database==""){
                        		database = database+fileName;
                        	}else{
                        		database = database + "|" +fileName;
                        	}
                        }
                    }
                    else{
                    	String name = item.getFieldName();
                    	String value = item.getString("UTF-8");
                    	System.out.println(name + "   " +value);
                    	if(name.equals("title")){
                    		title=value;
                    	}else if(name.equals("content")){
                    		content=value;
                    	}
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }
		
		
		System.out.println(request.getParameter("content"));
		bVo.setUserid(login.getUserid());
		bVo.setName(login.getName());
		bVo.setHakbun(login.getHakbun());
		bVo.setTitle(title);
		bVo.setContent(content);
		bVo.setImg(database);
		bDao.insertBoard(bVo, "imgboard");
		
		//테스트
		//System.out.println(title+"   "+content);
		System.out.println(database);
		
		response.sendRedirect("/ik.do?command=photo&page=1");
	}

}
