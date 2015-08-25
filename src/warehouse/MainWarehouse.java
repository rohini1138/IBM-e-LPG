package warehouse;

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

import model.Model;
import dao.Dao;

/**
 * Servlet implementation class MainWarehouse
 */
public class MainWarehouse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainWarehouse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
	    {
	    
	    String sql="select * from booking where distributer = ? ";
	    Class.forName("com.ibm.db2.jcc.DB2Driver");
	    Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/ELPG","Administrator","password");
	    System.out.println("Connected");
	    PreparedStatement ps=con.prepareStatement(sql);
	    ps.setString(1,"");
	    ResultSet rs=ps.executeQuery();
	    System.out.println("executeUpdate");
	    
	    
	    }
		catch(SQLException sqle)
		{
			
		} catch (ClassNotFoundException e) {
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

}
