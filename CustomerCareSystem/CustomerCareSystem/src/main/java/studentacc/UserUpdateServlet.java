package studentacc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String stream = request.getParameter("stream");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isTrue = userDBUtil.updateuser(id, name, address, phone, stream, username, password);
		
		if(isTrue)
		{
			RequestDispatcher dis = request.getRequestDispatcher("signin.jsp");
			dis.forward(request, response);
		}
		else
		{
			RequestDispatcher dis2 = request.getRequestDispatcher("updateuser.jsp");
			dis2.forward(request, response);
		}
	}

}
