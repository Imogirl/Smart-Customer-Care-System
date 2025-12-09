package techacc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewFaqsServlet")
public class ViewFaqsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve the list of FAQs from the database using techDBUtil
		List<faqs> faq = techDBUtil.getFaqs();
		
		// Set the list of FAQs as an attribute to be accessed in the JSP page
		request.setAttribute("allfaq", faq);
		
		
		List<Ticket> ticket = techDBUtil.gettickets();
		
		request.setAttribute("allticket", ticket);
		// Forward the request to the techdashboard.jsp page to display the FAQs
		RequestDispatcher dis = request.getRequestDispatcher("techdashboard.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}
}
