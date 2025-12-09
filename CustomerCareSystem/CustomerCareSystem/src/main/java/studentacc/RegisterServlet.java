package studentacc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String stream = request.getParameter("stream");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isTrue = userDBUtil.insertStudent(name, address, phone, stream, username, password);
		
		if(isTrue == true)
		{
			response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().println("<!DOCTYPE html>");
		    response.getWriter().println("<html><head>");
		    response.getWriter().println("<title>Registration Success</title>");
		    response.getWriter().println("<link rel='stylesheet' href='css/registersuccessbox.css'>"); // your success CSS
		    response.getWriter().println("</head><body>");

		    response.getWriter().println("<div class='success-box'>");
		    response.getWriter().println("<h2>Registration Successful</h2>");
		    response.getWriter().println("<p>Your account has been created successfully!</p>");
		    response.getWriter().println("<div class='buttons'>");
		    response.getWriter().println("<a href='signin.jsp' class='btn success'>Go to Sign In</a>");
		    response.getWriter().println("</div>");
		    response.getWriter().println("</div>");

		    response.getWriter().println("</body></html>");
		}
		else
		{
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<!DOCTYPE html>");
			response.getWriter().println("<html><head>");
			response.getWriter().println("<title>Registration Failed</title>");
			response.getWriter().println("<link rel='stylesheet' href='css/registererrorbox.css'>"); // your CSS file
			response.getWriter().println("</head><body>");

			response.getWriter().println("<div class='confirm-box'>");
			response.getWriter().println("<h2>Registration Failed</h2>");
			response.getWriter().println("<p>Something went wrong. Please try again.</p>");
			response.getWriter().println("<div class='buttons'>");
			response.getWriter().println("<a href='Register.jsp' class='btn confirm'>Back to Register</a>");
			response.getWriter().println("</div>");
			response.getWriter().println("</div>");

			response.getWriter().println("</body></html>");


		}
	}

}
