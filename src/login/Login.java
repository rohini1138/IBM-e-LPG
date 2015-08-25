package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import model.Model;


public class Login extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		HttpSession session  = request.getSession();
		
		if(uname.equals(null)||uname.equals("")||pass.equals(null)||pass.equals(""))
		{
			session.setAttribute("msg","all fields are mandatory");
			getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		
		}
		else
		{
			Model m = new Model();
			m.setUname(uname);
			m.setPass(pass);
			
			String sql = "select * from LOGIN where USERNAME=? and PASSWORD=?";
			
			ResultSet rs = Dao.loginUser(m,sql);
			
			try {
				while (rs.next())
				{
					session.setAttribute("usernameLogin",uname);
					session.setAttribute("pass",pass);
					getServletContext().getRequestDispatcher("/userMain.jsp").forward(request, response);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
