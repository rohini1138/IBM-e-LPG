package bookcylinder;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookConfirmed extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookConfirmed() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		getServletContext().getRequestDispatcher("/userMain.jsp").forward(request, response);
	}

}
