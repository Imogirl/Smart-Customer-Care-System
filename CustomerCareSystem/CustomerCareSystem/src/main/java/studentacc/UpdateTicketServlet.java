package studentacc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateTicketServlet
 */
@WebServlet("/UpdateTicketServlet")
public class UpdateTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String userid = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		
		int newid = Integer.parseInt(id);
		
		boolean isTrue = userDBUtil.UpdateTicket(newid, userid, subject, description, status);
		
		if (isTrue) {
			response.sendRedirect("allticket?userid=" + userid);

		} else {
		    RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
		    dis2.forward(request, response);
		}
	}

}
