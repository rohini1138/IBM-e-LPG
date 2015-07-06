package warehouse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginWarehouse
 */
public class LoginWarehouse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginWarehouse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		if(uname.equals(null)||pass.equals(null)||uname.equals("")||pass.equals(""))
		{
			request.setAttribute("msg","All Fields are mandatory");
			getServletContext().getRequestDispatcher("/WarehouseLogin.jsp").forward(request, response);
		}
		else if(uname.equals("admin")||pass.equals("admin"))
		{
			request.setAttribute("msg","ONGC Login Succesful");
			getServletContext().getRequestDispatcher("/WarehouseMain.jsp").forward(request, response);			
		}
		else
		{
			request.setAttribute("msg","You Are not AUTHORIZED USER");
			getServletContext().getRequestDispatcher("/WarehouseLogin.jsp").forward(request, response);			
		}
	}

}
