package adminlogin;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;
import dao.Dao;

public class AdminLoginServ extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
	
		if(uname.equals(null)||uname==""||pass.equals(null)||pass=="")
		{
			String msg1="All fields are mendatory....!!!!!";
			request.setAttribute("msg", msg1);
			getServletContext().getRequestDispatcher("/AdminLogin.jsp").forward(request, response);
	
		}
		else
		{
			String sql="select * from admin where username=? and password=?";
			Model m = new Model();
			m.setUname(uname);
			m.setPass(pass);
			try 
			{
				ResultSet rs1=Dao.loginUser(m,sql);
		
		
				while(rs1.next())
				{
					HttpSession session=request.getSession();
					session.setAttribute("uname", uname);
					session.setAttribute("pass", pass);
				
					getServletContext().getRequestDispatcher("/AdminMain.jsp").forward(request, response);
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
	}

}