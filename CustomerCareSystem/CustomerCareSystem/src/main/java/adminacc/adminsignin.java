package adminacc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageracc.ManageDButil;
import manageracc.manager;
import studentacc.userDBUtil;
import studentacc.useracc;
import techacc.tech;
import techacc.techDBUtil;

@WebServlet("/adminsignin")
public class adminsignin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//get user parameters
		String user = request.getParameter("uid");
		String password = request.getParameter("psw");
		try
		{
			//check user is admin or not
			List<adminacc> adminDetails = adminDBUtil.retrieveadmin(user, password);
			
			if(adminDetails !=null && !adminDetails.isEmpty())
			{	
				//start a session
				HttpSession session = request.getSession();
				session.setAttribute("adminDetails", adminDetails);

				RequestDispatcher dis = request.getRequestDispatcher("adminacc.jsp");
				dis.forward(request, response);
				
				//to end the code
				return;
			}
			
			List<useracc> studentDetails = userDBUtil.RetrieveUser(user,password);
			if(studentDetails !=null && !studentDetails.isEmpty())
			{	
				HttpSession session = request.getSession();
				session.setAttribute("userDetails", studentDetails);

				RequestDispatcher dis = request.getRequestDispatcher("useracc.jsp");
				dis.forward(request, response);
				
				return;
			}
			
			List<tech> tech = techDBUtil.loginuser(user, password);
			
			// If login is successful and user exists
			if (tech != null && !tech.isEmpty()) {
				// Pass user data to the next page
				HttpSession session = request.getSession();
				session.setAttribute("tech", tech);
				
				
				RequestDispatcher dis = request.getRequestDispatcher("techacc.jsp");
				dis.forward(request, response);
				return;
			}
			
			boolean isTrue = ManageDButil.validate(user, password);

	        if (isTrue) {
	            List<manager> ManDetails = ManageDButil.getManager(user); // you may adjust this as needed
	            HttpSession session = request.getSession();
	            session.setAttribute("ManDetails", ManDetails);
	            
	            RequestDispatcher dis = request.getRequestDispatcher("manage.jsp");
	            dis.forward(request, response);
	            
	            return;
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//else part
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<!DOCTYPE html>");
		response.getWriter().println("<html><head>");
		response.getWriter().println("<title>Signin Failed</title>");
		response.getWriter().println("<link rel='stylesheet' href='css/adminerror.css'>");
		response.getWriter().println("</head><body>");

		response.getWriter().println("<div class='confirm-box'>");
		response.getWriter().println("<h2>Signin Failed</h2>");
		response.getWriter().println("<p>Something went wrong. Please try again.</p>");
		response.getWriter().println("<div class='buttons'>");
		response.getWriter().println("<a href='signin.jsp' class='btn confirm'>Back to Login</a>");
		response.getWriter().println("</div>");
		response.getWriter().println("</div>");

		response.getWriter().println("</body></html>");
	}

}
