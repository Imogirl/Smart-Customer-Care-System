package studentacc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertTicketServlet")
public class InsertTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String subject = request.getParameter("subject");
		String description = request.getParameter("description");
		
		System.out.println("ID: " + id);
	    System.out.println("Subject: " + subject);
	    System.out.println("Description: " + description);

		boolean isTrue = userDBUtil.insertticket(id, subject, description);
		
		if(isTrue == true)
		{
			RequestDispatcher dis = request.getRequestDispatcher("studentsuccess.jsp");
			dis.forward(request, response);
		}
		else
		{
			RequestDispatcher dis2 = request.getRequestDispatcher("ticketinsertunsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
