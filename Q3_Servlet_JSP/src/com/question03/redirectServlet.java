package com.question03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirectServlet")
public class redirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("options");
		if(option.equals("gmail"))
			response.sendRedirect("https://www.google.com");
		else if(option.equals("rediff"))
			response.sendRedirect("https://www.google.com");
		else if(option.equals("yahoo"))
			response.sendRedirect("https://www.yahoo.com");
		else if(option.equals("hotmail"))
			response.sendRedirect("https://www.google.com");
		else if(option.equals("unknown"))
			response.sendError(404,"Website not accessible");
		
	}

}
