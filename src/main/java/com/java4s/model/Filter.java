package com.java4s.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
@Component
public class Filter implements javax.servlet.Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("Request uri is :"+ req.getRequestURI());
		System.out.println();
		Enumeration<String> headerNames = ((HttpServletRequest) request).getHeaderNames();
	    if (headerNames != null) {
	            while (headerNames.hasMoreElements()) {
	                    System.out.println("Header: " + ((HttpServletRequest) request).getHeader(headerNames.nextElement()));
	            }
	    }
	    
	    
	    response.setContentType("text/html");
	    
        /***** Print The Response *****/
        PrintWriter out = response.getWriter();
        String title = "HTTP Header Request Example";
        String docType = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n"+
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<table width = \"100px\" border = \"1\" align = \"center\">\n" +
                "<tr bgcolor = \"#949494\">\n" +
                "<th>Header Name</th><th>Header Value(s)</th>\n"+
                "</tr>\n");
 
        Enumeration<String> headerNames1 = ((HttpServletRequest) request).getHeaderNames();
        while(headerNames1.hasMoreElements()) {
            String paramName = (String)headerNames1.nextElement();
            out.print("<tr><td>" + paramName + "</td>\n");
            String paramValue = ((HttpServletRequest) request).getHeader(paramName);
            out.println("<td> " + paramValue + "</td></tr>\n");
        }
        out.println("</table>\n</body></html>");
	    
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
