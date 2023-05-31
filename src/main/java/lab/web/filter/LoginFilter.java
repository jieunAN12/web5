package lab.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class LoginFilter extends HttpFilter implements Filter {
	ServletContext context;
       
    public LoginFilter() {
        super();

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		
		context.log("client IP : "+req.getRemoteAddr()+", userid : "+session.getAttribute("userid"));
		context.log(req.getHeader("Cookie"));
		
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
			context = fConfig.getServletContext();
	}

}
