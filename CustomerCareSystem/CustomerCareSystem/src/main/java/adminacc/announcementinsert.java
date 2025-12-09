package adminacc;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/announcementinsert")
public class announcementinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String des = request.getParameter("description");
		
		boolean isTrue = adminDBUtil.insertannouncement(title, des);
		
		
		if(isTrue == true)
		{
			response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().println("<!DOCTYPE html>");
		    response.getWriter().println("<html><head>");
		    response.getWriter().println("<title>Creation Success</title>");
		    response.getWriter().println("<link rel='stylesheet' href='css/adminsuccess.css'>"); // your success CSS
		    response.getWriter().println("</head><body>");

		    response.getWriter().println("<div class='success-box'>");
		    response.getWriter().println("<h2>Inserted Successful</h2>");
		    response.getWriter().println("<p>Your announcement has been created successfully!</p>");
		    response.getWriter().println("<div class='buttons'>");
		    response.getWriter().println("<a href='customercare.jsp' class='btn success'>Go to Dashboard</a>");
		    response.getWriter().println("</div>");
		    response.getWriter().println("</div>");

		    response.getWriter().println("</body></html>");
		}
		else
		{
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<!DOCTYPE html>");
			response.getWriter().println("<html><head>");
			response.getWriter().println("<title>Creation Failed</title>");
			response.getWriter().println("<link rel='stylesheet' href='css/adminerror.css'>"); 
			response.getWriter().println("</head><body>");

			response.getWriter().println("<div class='confirm-box'>");
			response.getWriter().println("<h2>Creation Failed</h2>");
			response.getWriter().println("<p>Something went wrong. Please try again.</p>");
			response.getWriter().println("<div class='buttons'>");
			response.getWriter().println("<a href='customercare.jsp' class='btn confirm'>Back to Dashboard</a>");
			response.getWriter().println("</div>");
			response.getWriter().println("</div>");

			response.getWriter().println("</body></html>");
		}
	}
 
}
