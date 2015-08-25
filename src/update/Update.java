package update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import model.Model;

/**
 * Servlet implementation class Register
 */
public class Update extends HttpServlet
{
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		session.setAttribute("msg","");
		
		String uname = session.getAttribute("usernameLogin").toString();
		//String pass = request.getParameter("pass");
		//String repass = request.getParameter("repass");
		//String customerid = request.getParameter("customerid");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		//String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		//String nation = request.getParameter("nation");
		String state = request.getParameter("state");
		String district = request.getParameter("district");
		String addr = request.getParameter("addr");
		String pincode = request.getParameter("pincode");
		String distributer= request.getParameter("distributer");
		//String aadharno = request.getParameter("aadharno");
		String mobileno = request.getParameter("mobileno");
		String stdcode = request.getParameter("stdcode");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		
		if(fname.equals(null)||fname.equals("")||lname.equals(null)||lname.equals("")||state.equals(null)||state.equals("")||district.equals(null)||district.equals("")||distributer.equals(null)||distributer.equals("")||pincode.equals(null)||pincode.equals("")||addr.equals(null)||addr.equals("")||mobileno.equals(null)||mobileno.equals("")||stdcode.equals(null)||stdcode.equals("")||telephone.equals(null)||telephone.equals(""))

		{
			session.setAttribute("msg","All Fields are mandatory");
			getServletContext().getRequestDispatcher("/Update.jsp").forward(request, response);
		}
		/*else if(!pass.equals(repass))
		{
			session.setAttribute("msg","Password and Reenter passwords must be same");
			getServletContext().getRequestDispatcher("/Update.jsp").forward(request, response);
		}*/
		else
		{
			Model m = new Model();
			m.setUname(uname);
//			m.setPass(pass);
//			m.setRepass(repass);
			m.setFname(fname);
			m.setLname(lname);
			m.setAddr(addr);
//			m.setGender(gender);
			m.setDistributer(distributer);
			m.setDistrict(district);
			m.setDob(dob);
			m.setEmail(email);
			m.setPincode(pincode);
			m.setState(state);
			m.setMobileno(mobileno);
//			m.setNationality(nation);
//			m.setAadharno(aadharno);
			m.setTelephone(telephone);
			m.setStdcode(stdcode);
			
			//
			String sql = "update REGISTER set(FIRSTNAME,LASTNAME,DOB,STATE,DISTRICT,ADDRESS,PINCODE,DISTRIBUTER,MOBILENO,STDCODE,TELEPHONE,EMAIL)=(?,?,?,?,?,?,?,?,?,?,?,?) where USERNAME=?";
			
			int i=Dao.update(m,sql);
			if(i>0)
			{
				System.out.println("Success");
				
				session.setAttribute("username",uname);
				getServletContext().getRequestDispatcher("/UpdateSuccess.jsp").forward(request, response);
			}
			
		}
		
	}

}
