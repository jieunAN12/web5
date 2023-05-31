package lab.web.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab.web.dao.UserDAO;
import lab.web.model.UserVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserControll() {
        super();
    }
    
	RequestDispatcher rd = null;
	HttpSession session = null;
	UserDAO dao = new UserDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestUri = request.getRequestURI();
		String reqStr = requestUri.substring(requestUri.lastIndexOf("/")+1, requestUri.lastIndexOf(".do"));
		if(reqStr.equals("join")) { //join.do를 입력하면 sendRedirect 되어서 member.jsp가 나옴
			response.sendRedirect("./member.jsp");
		
		}else if(reqStr.equals("login")) {
			response.sendRedirect("./login.jsp");
			
		}else if(reqStr.equals("logout")) {
			session = request.getSession();
			session.invalidate();
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies) {
				c.setMaxAge(0);//쿠키정보 다 지우기
				response.addCookie(c);
			}
			response.sendRedirect("./login.jsp");
			
		}else if(reqStr.equals("modify")) {
			session = request.getSession();
			String uid = (String)session.getAttribute("userid");
			if(uid != null) {//로그인이 되어 있는 경우
				UserVO user = dao.getUser(uid);
				rd=request.getRequestDispatcher("/editUserInfo.jsp");
				request.setAttribute("user", user);//request는 불러오기 setattribute는 속성 셋팅
				rd.forward(request, response);
			}else {
				response.sendRedirect("./login.jsp");
			}
		
		}else if(reqStr.equals("list")) {
			//System.out.println("list");
			session = request.getSession();
			String uid = (String)session.getAttribute("userid");
			if(uid != null) {//로그인이 되어 있는 경우
				ArrayList<UserVO> users = dao.getUserList();
				rd = request.getRequestDispatcher("/userlist.jsp");
				request.setAttribute("users", users);
				rd.forward(request, response);
			}else {
				response.sendRedirect("./login.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		UserVO vo = new UserVO();
		
		String requestUri = request.getRequestURI();
		String reqStr = requestUri.substring(requestUri.lastIndexOf("/")+1, requestUri.lastIndexOf(".do"));

		if(reqStr.equals("join")) { //join.do를 입력하면 sendRedirect 되어서 member.jsp가 나옴
			vo.setUserid(request.getParameter("userid"));
			vo.setUserpwd(request.getParameter("userpwd"));
			vo.setUsername(request.getParameter("username"));
			vo.setEmail(request.getParameter("email"));
			vo.setPhone(request.getParameter("phone"));
			vo.setAddress(request.getParameter("address"));
			if(dao.insertUser(vo)>0) {
				response.sendRedirect("./login.jsp");
			}
			
		}else if(reqStr.equals("login")) {
			UserVO user = dao.login(request.getParameter("userid"), request.getParameter("userpwd"));
//			String role = (String)session.getAttribute("role");
			if(user != null) {
				session = request.getSession();
//				if(role == "user") {
				rd=request.getRequestDispatcher("/index.html");
//				}else if(role == "admin") {
//					rd=request.getRequestDispatcher("/index_m.html");
//				}
				request.setAttribute("user", user);//request는 불러오기 setattribute는 속성 셋팅
				session.setAttribute("userid", user.getUserid());//session으로 userid객체 저장
				rd.forward(request, response);
			}
			
		}else if(reqStr.equals("update")) {
			vo = new UserVO();
			vo.setUserid(request.getParameter("userid"));
			vo.setUserpwd(request.getParameter("userpwd"));
			vo.setUsername(request.getParameter("username"));
			vo.setEmail(request.getParameter("email"));
			vo.setPhone(request.getParameter("phone"));
			vo.setAddress(request.getParameter("address"));
			if(dao.updateUser(vo) != false) {
				response.sendRedirect("./list.do");
			}
			
		}else if(reqStr.equals("remove")){
			if(dao.removeUser(request.getParameter("userid")) > 0) {
				response.sendRedirect("./list.do");
			}
		}
		
	}
}
