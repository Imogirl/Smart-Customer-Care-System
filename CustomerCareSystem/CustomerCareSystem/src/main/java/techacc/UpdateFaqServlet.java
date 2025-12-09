package techacc;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateFaqServlet")
public class UpdateFaqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		
		int uid = Integer.parseInt(id);
		
		// Calling the updatefaq method from techDBUtil to update the FAQ in the database
		boolean isTrue = techDBUtil.updatefaq(uid, name, description);
		
		// If the FAQ update is successful, forwarding to the techdashboard.jsp page
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
