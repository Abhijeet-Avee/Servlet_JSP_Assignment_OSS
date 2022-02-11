package com.question02;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlFilter implements Filter {
	private String forbiddenUrl;
	
	public void init(FilterConfig fConfig) throws ServletException{
		this.forbiddenUrl = fConfig.getInitParameter("forbidden");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println(req.getRequestURI());
		System.out.println(req.getRequestURL().toString());
		System.out.println(req.getRemoteHost());
		if(forbiddenUrl.equals(req.getRemoteAddr()))
			res.sendRedirect("forbidden.jsp");
		else
		chain.doFilter(request, response);
	}


}
