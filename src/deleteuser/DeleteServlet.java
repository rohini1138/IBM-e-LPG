package deleteuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;
import dao.Dao;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1=request.getParameter("s1");	
		//String pass2=request.getParameter("pass2");	
		HttpSession session = request.getSession();
		
			String uname=(String)session.getAttribute("uname");
			Model m=new Model();
			
			m.setS1(s1);
		//	m.setUname(uname);
			
			String sql="delete from register where username=?";
			boolean st=Dao.DeleteUser(m,sql);
			
			if(st)
			{
				String msg1="Password Changed Successfully.. Login with your new Password";
				request.setAttribute("msg", msg1);
				getServletContext().getRequestDispatcher("/AdminMain.jsp").forward(request, response);

			}
			else
			{
				String msg1="Password Not Changed";
				request.setAttribute("msg", msg1);
				getServletContext().getRequestDispatcher("/AdminLogin.jsp").forward(request, response);
			}
			
			
	}

}
