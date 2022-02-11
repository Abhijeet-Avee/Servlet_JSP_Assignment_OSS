package com.question01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/myServlet"},
			initParams = {
					@WebInitParam(name="username", value="yash"),
					@WebInitParam(name="password", value="yash")
			}
		)
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int i = 0;
	
	public void init() {
		i=1;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int counter = Integer.parseInt(this.getServletContext().getInitParameter("counter"));
		if(username.equals(this.getInitParameter("username")) 
				&& password.equals(this.getInitParameter("password"))) {
				out.println("Succesfully logged in");
		}else {
			if(i<=counter) {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
				out.println("<br><br><p style=\"color:red\">Invalid username and password</p>");
				i++;
			}else {
				out.println("Maximum attempts failed, retry after some time");
			}
		}
	}

}
