package studentacc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewTicketServlet")
public class ViewTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userid = request.getParameter("userid");
		
		try
		{
		
		List<Ticket> ticket = userDBUtil.RetrieveTickets(userid);
		request.setAttribute("ticket", ticket);
		
		RequestDispatcher dis = request.getRequestDispatcher("ViewTicket.jsp");
		dis.forward(request, response);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
