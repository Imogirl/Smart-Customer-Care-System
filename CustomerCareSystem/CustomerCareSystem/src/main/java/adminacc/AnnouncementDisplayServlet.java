package adminacc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentacc.userDBUtil;
import studentacc.useracc;


@WebServlet("/AnnouncementDisplayServlet")
public class AnnouncementDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		List<announcement> allannouncement = adminDBUtil.retrieveannouncement();
		request.setAttribute("allannouncement", allannouncement);
		
		 List<useracc> allUsers = userDBUtil.getAllUsers(); 
         request.setAttribute("allUsers", allUsers);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("customercare.jsp");
        dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
