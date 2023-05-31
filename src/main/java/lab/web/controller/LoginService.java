package lab.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab.web.dao.UserDAO;
import lab.web.model.UserVO;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginService() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("userid");
		String passwd = request.getParameter("userpwd");
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		
		int resultCode = -1;
		if(dao.login(id, passwd) != null) {
			resultCode = 1;//아이디와 패스워드 일치
		}else if(dao.getUser(id) != null) {
			resultCode = 0;//패스워드 불일치, 아이디 전제
		}else {
			resultCode = -2;//아이디 존재하지 않음
		}
		
		String outString  = null;
		if(resultCode == 1) {
			outString = "<response><result>"+resultCode+"</result><id>"+id+"</id></response>";
		}else if(resultCode == 0) {
			outString = "<response><result>"+resultCode+"</result><id>"+id+"</id></response>";
		}else {
			outString = "<response><result>"+resultCode+"</result><id>"+id+"</id></response>";
		}
		out.println(outString);
	}

}
