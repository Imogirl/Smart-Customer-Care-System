package techacc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertFaqsServlet")
public class InsertFaqsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Handles GET requests used here for inserting FAQ data
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get form values for name question and answer from request
		String name = request.getParameter("name");
		String answer = request.getParameter("answer");
		
		
		System.out.println("Received FAQ name: " + name);
        System.out.println("Received FAQ answer: " + answer);
		
		// Call database  to insert the FAQ
		boolean isTrue = techDBUtil.insertfaqs(name, answer);
		
		// If insert successful, redirect to dashboard
		if(isTrue == true)
		{
			RequestDispatcher dis = request.getRequestDispatcher("techdashboard.jsp");
			dis.forward(request, response);
		}
		else
		{
			// If insert fails, redirect to unsuccess page
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}
	
	// Handles POST requests by calling doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
}
