package lab.web.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public PropertyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		ServletConfig config = getServletConfig();
		out.print("servlet의 초기화 파라미터 <br>");
		out.print(config.getInitParameter("MS")+"<br>");
		out.print(config.getInitParameter("Google")+"<br>");
		out.print("<hr>");
		out.print("servletContext의 초기화 파라미터 <br>");
		out.print(context.getInitParameter("Apple")+"<br>");
		out.print(context.getInitParameter("Samsung")+"<br>");
	}

}
