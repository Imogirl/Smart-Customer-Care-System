package manageracc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Admindelete")
public class Admindelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id"); // Get admin ID from URL
        boolean isTrue = ManageDButil.Admindelete(id); // Delete from DB

        if (isTrue) {
            // Redirect to AdminViewServlet 
            response.sendRedirect("AdminViewServlet");
        } else {
            // If deletion fails, show an error message
            request.setAttribute("errorMessage", "Admin deletion failed.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("team.jsp");
            dispatcher.forward(request, response);
        }
	}

}
