package lab.web.handler;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import lab.web.model.Product;

public class ItemTagHandler extends SimpleTagSupport{
	//태그 속성 처리를 위한 멤버변수
	private String bgcolor;
	private String border;
	
	//시작 태그를 만나면 호출되는 매서드
	public void doTag() throws IOException, JspException{
		JspWriter out = getJspContext().getOut();
		JspFragment body = getJspBody();
		Product product = new Product();
		StringBuffer msg = new StringBuffer();
		if(body != null) {
			out.println("<h2>");
			body.invoke(null);
			out.println("</h2>");
		}
		msg.append("<table border=")
		.append(border)
		.append(" bgcolor=")
		.append(bgcolor)
		.append(" width=150>");
		out.println(msg.toString());
		for(String item : product.getProductList()){
			out.println("<tr><td>"+item+"</td></tr>");
		}
		out.println("</table>");
	}
	
	public String getBgcolor() {
		return bgcolor;	
	}
	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}
	
	public String getBorder() {
		return border;	
	}
	public void setBorder(String border) {
		this.border = border;
	}

}
