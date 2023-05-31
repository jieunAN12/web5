package lab.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab.web.model.SnackVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;


public class AddCartService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCartService() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = null;
		session = request.getSession();
		String uid = (String)session.getAttribute("userid");
		if(uid != null) {
			SnackVO snack = new SnackVO();
			snack.setPid(request.getParameter("pid"));
			snack.setPname(request.getParameter("pname"));
			snack.setPrice(Integer.parseInt(request.getParameter("price")));
			snack.setQty(Integer.parseInt(request.getParameter("qty")));
			
			Cookie[] cookies = request.getCookies();
			Cookie cart = null;
			
			String cookieValue = URLEncoder.encode(snack.toString(), "utf-8");
			cart = new Cookie(snack.getPid(), cookieValue);
			
			cart.setMaxAge(60*60);
			response.addCookie(cart);
			
			out.println("<html><head></head><body>");
			out.println("<script>");
			out.println("if (window.confirm('계속 쇼핑하시겠습니까?')){");
			out.println("location.href='./itemList'");
			out.println("}else{");
			out.println("location.href='./myCart.jsp'");
			out.println("}</script>");
			out.println("</body></html>");
		}
	}

}
