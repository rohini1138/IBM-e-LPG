package register;

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
public class Register extends HttpServlet
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
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		//String customerid = request.getParameter("customerid");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		//String nation = request.getParameter("nation");
		String state = request.getParameter("state");
		String district = request.getParameter("district");
		String addr = request.getParameter("addr");
		String pincode = request.getParameter("pincode");
		String distributer= request.getParameter("distributer");
		String aadharno = request.getParameter("aadharno");
		String mobileno = request.getParameter("mobileno");
		String stdcode = request.getParameter("stdcode");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		
		if(uname.equals(null)||uname.equals("")||pass.equals(null)||pass.equals("")||fname.equals(null)||fname.equals("")||lname.equals(null)||lname.equals("")||gender.equals(null)||gender.equals("")||dob.equals(null)||dob.equals("")||state.equals(null)||state.equals("")||district.equals(null)||district.equals("")||distributer.equals(null)||distributer.equals("")||pincode.equals(null)||pincode.equals("")||addr.equals(null)||addr.equals("")||aadharno.equals(null)||aadharno.equals("")||mobileno.equals(null)||mobileno.equals("")||stdcode.equals(null)||stdcode.equals("")||telephone.equals(null)||telephone.equals("")||email.equals(null)||email.equals("")||question.equals(null)||question.equals("")||answer.equals(null)||answer.equals(""))

		{
			session.setAttribute("msg","All Fields are mandatory");
			getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
		}
		else if(!pass.equals(repass))
		{
			session.setAttribute("msg","Password and Reenter passwords must be same");
			getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
		}
		else
		{
			Model m = new Model();
			m.setUname(uname);
			m.setPass(pass);
//			m.setRepass(repass);
			m.setFname(fname);
			m.setLname(lname);
			m.setAddr(addr);
			m.setGender(gender);
			m.setDistributer(distributer);
			m.setDistrict(district);
			m.setDob(dob);
			m.setEmail(email);
			m.setPincode(pincode);
			m.setState(state);
			m.setMobileno(mobileno);
//			m.setNationality(nation);
			m.setAadharno(aadharno);
			m.setTelephone(telephone);
			m.setStdcode(stdcode);
			m.setQuestion(question);
			m.setAnswer(answer);
			
			//String sql = "insert into REGISTERATION values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			String sql = "insert into REGISTER (USERNAME,PASSWORD,FIRSTNAME,LASTNAME,GENDER,DOB,STATE,DISTRICT,ADDRESS,PINCODE,DISTRIBUTER,AADHARNO,MOBILENO,STDCODE,TELEPHONE,EMAIL,QUESTION,ANSWER) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			int i=Dao.register(m,sql);
			if(i>0)
			{
				System.out.println("Success");
				
				session.setAttribute("usernameRegister",uname);
				session.setAttribute("password",pass);
				session.setAttribute("fname",fname);
				session.setAttribute("lname",lname);
				session.setAttribute("gender",gender);
				session.setAttribute("dob",dob);
				session.setAttribute("state",state);
				session.setAttribute("district",district);
				session.setAttribute("addr",addr);
				session.setAttribute("pincode",pincode);
				session.setAttribute("distributer",distributer);
				session.setAttribute("aadharno",aadharno);
				session.setAttribute("mobileno",mobileno);
				session.setAttribute("stdcode",stdcode);
				session.setAttribute("telephone",telephone);
				session.setAttribute("email",email);
				session.setAttribute("question",question);
				session.setAttribute("answer",answer);
				
				getServletContext().getRequestDispatcher("/RegisterSuccess.jsp").forward(request, response);
			}
			
		}
		
	}

}
