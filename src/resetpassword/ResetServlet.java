package resetpassword;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;
import dao.Dao;

public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pass1=request.getParameter("pass1");	
		String pass2=request.getParameter("pass2");	
		HttpSession session = request.getSession();
		
		if(pass1.equals(null)||pass1==""||pass2.equals(null)||pass2=="")
		{
			String msg1="All fields are mendatory....!!!!!";
			request.setAttribute("msg", msg1);
			getServletContext().getRequestDispatcher("/Reset.jsp").forward(request, response);

		}
		else
		{
			String uname=(String)session.getAttribute("uname");
			Model m=new Model();
			
			m.setPass1(pass1);
			m.setUname(uname);
			
			String sql="update register set password=? where username=?";
			boolean st=Dao.ResetForgetPass(m,sql);
			
			if(st)
			{
				String msg1="Password Changed Successfully.. Login with your new Password";
				request.setAttribute("msg", msg1);
				getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);

			}
			else
			{
				String msg1="Password Not Changed";
				request.setAttribute("msg", msg1);
				getServletContext().getRequestDispatcher("/ForgotPassword.jsp").forward(request, response);
			}
			
		}
	}

}
