package lab.web.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab.web.dao.SnackDAO;
import lab.web.model.SnackVO;

import java.io.IOException;
import java.util.List;

public class ItemListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ItemListService() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = null;
		session = request.getSession();
		String uid = (String)session.getAttribute("userid");
		List<SnackVO> snackList = null;
		RequestDispatcher rd = null;
		if(uid != null) {//로그인이 되어있는 경우
			SnackDAO dao = new SnackDAO();
			snackList = dao.getSnackList();
			if(snackList != null) {
				rd = request.getRequestDispatcher("/snackList.jsp");
				request.setAttribute("snacks", snackList);
				rd.forward(request, response);
			}
		}else {//로그인이 안되어 있는 경우
				response.sendRedirect("./login.do");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	

}
