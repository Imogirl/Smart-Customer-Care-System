package techacc;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateTechServlet")
public class UpdateTechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//convert string id into int id
		int uid = Integer.parseInt(id);
		
		boolean isTrue = techDBUtil.updatetech(uid, name, address, phone, username, password);
		
		if(isTrue)
		{
			RequestDispatcher dis = request.getRequestDispatcher("signin.jsp");
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

