package lab.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab.web.model.SnackVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CartSaveService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartSaveService() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = null;
		session = request.getSession();
		String uid = (String)session.getAttribute("userid");//로그인 상태를 체크할 수 있는 상태 정보를 세션에 저장, 장바구니 (KEY 객체)
		//session.remove(key객체)
		if(uid != null) {
			SnackVO snack = new SnackVO();
			snack.setPimg(request.getParameter("pimg"));
			snack.setPid(request.getParameter("pid"));
			snack.setPname(request.getParameter("pname"));
			snack.setPrice(Integer.parseInt(request.getParameter("price")));
			snack.setQty(Integer.parseInt(request.getParameter("qty")));
			ArrayList<SnackVO> cart = null;
			cart = (ArrayList)session.getAttribute("cart");
			if(cart != null) {
				cart.add(snack);
			}else {
				cart = new ArrayList<SnackVO>();
				cart.add(snack);
			}
			session.setAttribute("cart", cart);//(KEY객체, VALUE객체)
			//response.sendRedirect("./snackList");
			out.println("<html><head></head><body>");
			out.println("<script>");
			out.println("if (window.confirm('계속 쇼핑하시겠습니까?')){");
			out.println("location.href='./snackList'");
			out.println("}else{");
			out.println("location.href='./viewCart.jsp'");
			out.println("}</script>");
			out.println("</body></html>");
			
		}
	}

}
