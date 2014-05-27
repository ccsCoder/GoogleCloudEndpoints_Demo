package com.tfl;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class BillGeneratorServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
//		this.getServletContext().getRequestDispatcher("index.html").forward(req, resp);
		
	}
}
