package studentacc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteTicketServlet")
public class DeleteTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("id");
		String uid = request.getParameter("userid");
		
		
		boolean isTrue = userDBUtil.DeleteTicket(userid);
		System.out.println(isTrue);
		System.out.println(userid);
		
		if (isTrue) {
			response.sendRedirect("allticket?userid=" + uid);

		} else {
		    RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
		    dis2.forward(request, response);
		}

	}

}
