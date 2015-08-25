package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DistributerLoginServlet
 */
public class DistributerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("distributername",request.getParameter("distributername"));
		session.setAttribute("distributerdistrict",request.getParameter("distributerdistrict"));
		session.setAttribute("count",getCount(request.getParameter("distributername")));
		
			getServletContext().getRequestDispatcher("/DistributerMain.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	public int  getCount(String distributer)
	{
		int count = 0;
		
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("forname");
			Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/ELPG","Administrator","password");
			System.out.println("conn");
			String firstsql = "select * from booking where distributer = ?";
			PreparedStatement ps= con.prepareStatement(firstsql);
			ps.setString(1,distributer);
			System.out.println("PS");
			ResultSet rs = ps.executeQuery();
			System.out.println("RS");
			while(rs.next())
			{
				count++;
			}
			System.out.println("Servlet:"+count);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return count;
	
	}

}
