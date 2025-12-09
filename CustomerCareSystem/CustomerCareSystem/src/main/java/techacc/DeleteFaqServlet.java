package techacc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteFaqServlet")
public class DeleteFaqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Handles HTTP POST requests
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the FAQ ID from the request
		String id = request.getParameter("id");
		
		// Convert the ID from String to Integer
		int fid = Integer.parseInt(id);
		
		// Call the database utility to delete the FAQ
		boolean isTrue = techDBUtil.deletefaq(fid);
		
		
		if(isTrue) {
			RequestDispatcher dis = request.getRequestDispatcher("techdashboard.jsp");
			dis.forward(request, response);
		}
		
		// If deletion fails, redirect to the error page
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("error.jsp");
			dis2.forward(request, response);
		}
	}
}

