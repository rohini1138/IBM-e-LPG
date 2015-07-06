package bookcylinder;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;
import dao.Dao;

/**
 * Servlet implementation class BookCylinderServlet
 */
public class BookCylinderServlet extends HttpServlet {
	private static int i = 0;
	private static final long serialVersionUID = 1L;
	private static int j = 1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCylinderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Connection conn = null;
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("usernameLogin");
		String pass = request.getParameter("password");
		String bookingdate = request.getParameter("bookingdate");
		System.out.println(bookingdate);
		System.out.println("Entered pwd : " + pass);
		System.out.println(uname);
		try {
			conn = Dao.connect();
			System.out.println("conn");
			PreparedStatement ps = conn.prepareStatement("select * from register where username = ?");
			System.out.println("PS");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			System.out.println("Result Set");
			while(rs.next())
			{
				String dbpass = rs.getString(3);
				if(dbpass.equals(pass))
				{
					
					System.out.println("PASSWORD CORRECT");
					
					int customerid = rs.getInt(1);
					String distributer = rs.getString(12);
					String name = rs.getString(4)+" "+rs.getString(5);
					
					String sql = "insert into booking(customerid,distributer,lotno,bookingdate,cylinderno,name) values(?,?,?,?,?,?)";
					Model m = new Model();
					
					
					m.setCustomerid(customerid);
					m.setDistributer(rs.getString(12));
					m.setLotno(generatelotno());
					m.setCylinderno(generatecylinderno());
					m.setBookingdate(new Date().toString());
					m.setFullname(name);
					m.setTime(new Date().toString());
					boolean book = Dao.bookcylinder(sql,m);
		
					
					
					
					if(book)
					{
						System.out.println("Cylinder booked");
					}
					else
					{
						System.out.println("Error");
					}
					getServletContext().getRequestDispatcher("/BookingConfirmed.jsp").forward(request, response);
					
				}
				else
				{
					
					System.out.println("PASSWORD INCORRECT");
					request.setAttribute("msg","PASSWORD INCORRECT");
					getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public int generatecylinderno()
	{
		int random = 5000+(int) (Math.random()*(5000-0+1));
		return random;
	}
	
	public int generatelotno()
	{
		i=i+1;
		
		if(i%5==0)
		{
			j=j+1;
				return j;	
		}
		else
		{
			
			return j;
		}
		
		
	}

}
