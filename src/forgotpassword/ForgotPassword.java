package forgotpassword;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;
import dao.Dao;

/**
 * Servlet implementation class ForgotServlet
 */
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	String uname=request.getParameter("uname");	
	String question=request.getParameter("question");	
	String answer=request.getParameter("answer");
	
	HttpSession session = request.getSession();
	
	if(uname.equals(null)||uname==""||question.equals(null)||question==""||answer.equals(null)||answer=="")
	{
		String msg1="All fields are mendatory....!!!!!";
		request.setAttribute("msg", msg1);
		getServletContext().getRequestDispatcher("/ForgotPassword.jsp").forward(request, response);

	}
	else
	{
		Model m=new Model();
		
		m.setUname(uname);
		m.setQuestion(question);
		m.setAnswer(answer);
		String sql="select * from REGISTER where USERNAME=? and QUESTION=? and ANSWER=?";
		boolean st=Dao.forgetPassword(m,sql);
		
		if(st)
		{
			session.setAttribute("uname", uname);

			String msg1="Please enter new Password";
			request.setAttribute("msg", msg1);
			getServletContext().getRequestDispatcher("/ForgotPasswordReset.jsp").forward(request, response);

		}
		else
		{
			String msg1="User Does Not exist.... Please Try Again";
			request.setAttribute("msg", msg1);
			getServletContext().getRequestDispatcher("/ForgotPassword.jsp").forward(request, response);
		}
		
	}
	}

}
