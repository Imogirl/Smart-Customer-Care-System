package techacc;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ReplyTicketServlet")
public class ReplyTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String userid = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String description = request.getParameter("description");
		String reply = request.getParameter("reply");
		
		int newid = Integer.parseInt(id);
		
		boolean isTrue = techDBUtil.updateticket(newid, userid, subject, description, reply);
		
		if(isTrue)
		{
			RequestDispatcher dis = request.getRequestDispatcher("techdashboard.jsp");
			dis.forward(request, response);
		}
		// If the update fails, forwarding to the error.jsp page
		else
		{
			RequestDispatcher dis2 = request.getRequestDispatcher("error.jsp");
			dis2.forward(request, response);
		}
	}

}

