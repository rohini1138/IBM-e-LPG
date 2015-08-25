package resetpassword;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import model.Model;

/**
 * Servlet implementation class ResetPassServ
 */
public class ResetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String msg="";
		
		String cpass=request.getParameter("cpass");
		String npass=request.getParameter("npass");
		String repass=request.getParameter("repass");
		
		HttpSession session=request.getSession();
		String pass=(String)session.getAttribute("pass");
		String uname=(String)session.getAttribute("usernameLogin");
		
		System.out.println(uname +"  "+ pass);
		if(!cpass.equals(pass))
		{
			String msg1 = "Current Password is Wrong..!!";
			request.setAttribute("msg", msg1);
			getServletContext().getRequestDispatcher("/ResetPassword.jsp").forward(request, response);
		}
		
		else if(!npass.equals(repass))
		{
			msg=" New Password and Re_Enter Password are not SAME..!!";
			request.setAttribute("msg1", msg);
			getServletContext().getRequestDispatcher("/ResetPassword.jsp").forward(request, response);
		}
		
		else
		{
			Model m = new Model();
			
			m.setNpass(npass);
			m.setUname(uname);
			
			String sql="update REGISTER set password=? where username=?";		
			boolean y=Dao.resetPassword(m,sql);
			
			if(y)
			{
				System.out.println("New Password is set!");
				msg="New Password is set..!!";
				request.setAttribute("msg", msg);
				getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);
			}
		}
	}

}
