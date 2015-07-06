package dao;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Model;

public class Dao
{
	
	
	public static Connection connect()
	{
		Connection con=null;
		
		String Driver ="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/ELPG";
		try 
		{
			Class.forName(Driver);
			con=DriverManager.getConnection(url, "Administrator", "password");
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

	public static int register(Model m, String sql) 
	{
		Connection con=null;
		int i = 0;
		try 
		{
			con = connect();
			PreparedStatement ps = con.prepareStatement(sql);

			//ps.setString(1, m.getcustomerid());
			ps.setString(1, m.getUname());
			ps.setString(2, m.getPass());
			ps.setString(3, m.getFname());
			ps.setString(4, m.getLname());
			ps.setString(5, m.getGender());
			ps.setString(6, m.getDob());
//			ps.setString(7, m.getNationality());
			ps.setString(7, m.getState());
			ps.setString(8, m.getDistrict());
			ps.setString(9, m.getAddr());
			ps.setString(10, m.getPincode());
			ps.setString(11, m.getDistributer());
			ps.setString(12, m.getAadharno());
			ps.setString(13, m.getMobileno());
			ps.setString(14, m.getStdcode());
			ps.setString(15, m.getTelephone());
			ps.setString(16, m.getEmail());
			ps.setString(17, m.getQuestion());
			ps.setString(18, m.getAnswer());
			
			i=ps.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return i;
		
		
	}

	public static ResultSet loginUser(Model m, String sql)
	{
		// TODO Auto-generated method stub
		Connection con=null;
		ResultSet rs = null;
		try 
		{
			con = connect();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, m.getUname());
			ps.setString(2, m.getPass());
				
			rs=ps.executeQuery();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
		
		
	}
	
	public static int update(Model m, String sql) 
	{
		Connection con=null;
		int i = 0;
		try 
		{
			con = connect();
			PreparedStatement ps = con.prepareStatement(sql);
//			String sql = "update REGISTER set(FIRSTNAME,LASTNAME,DOB,STATE,DISTRICT,ADDRESS,PINCODE,DISTRIBUTER,MOBILENO,STDCODE,TELEPHONE,EMAIL)=(?,?,?,?,?,?,?,?,?,?,?,?) where USERNAME=?";
			//ps.setString(1, m.getcustomerid());
			ps.setString(13, m.getUname());
//			ps.setString(1, m.getPass());
			ps.setString(1, m.getFname());
			ps.setString(2, m.getLname());
			ps.setString(3, m.getDob());
//			ps.setString(5, m.getGender());
//			ps.setString(7, m.getNationality());
			ps.setString(4, m.getState());
			ps.setString(5, m.getDistrict());
			ps.setString(6, m.getAddr());
			ps.setString(7, m.getPincode());
			ps.setString(8, m.getDistributer());
//			ps.setString(12, m.getAadharno());
			ps.setString(9, m.getMobileno());
			ps.setString(10, m.getStdcode());
			ps.setString(11, m.getTelephone());
			ps.setString(12, m.getEmail());
			
			i=ps.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return i;
		
		
	}	
	
	

	public static boolean forgetPassword(Model m, String sql) 
	{
		// TODO Auto-generated method stub
		boolean status=false;
		Connection con=connect();
		
		System.out.println("Connected in forgetPassword()");
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, m.getUname());
			ps.setString(2, m.getQuestion() );
			ps.setString(3, m.getAnswer());
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				status=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public static boolean resetPassword(Model m, String sql) {
		// TODO Auto-generated method stub
		boolean status=false;
		Connection con = connect();
		
		System.out.println("Connected in resetPassword()");
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, m.getNpass());
			ps.setString(2, m.getUname());
			
			int x=ps.executeUpdate();
			
			if(x!=0)
			{
				status=true;
			}
			else
			{
				status=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}
	
	public static boolean ResetForgetPass(Model m, String sql) 
	{
		boolean status=false;
		Connection con=connect();
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, m.getPass1());
			ps.setString(2, m.getUname());
			
			int i=ps.executeUpdate();
					
			if(i!=0)
			{
				status=true;
			}
			else
			{
				status=false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static boolean DeleteUser(Model m, String sql) {
		boolean status=false;
			Connection con=connect();
				
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					
					ps.setString(1, m.getS1());
					//ps.setString(2, m.getUname());
					
					int i=ps.executeUpdate();
							
					if(i!=0)
					{
						status=true;
					}
					else
					{
						status=false;
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return status;
	}

	public static boolean bookcylinder(String sql, Model m)
	{
		boolean status = false;
		Connection conn = Dao.connect();
		try 
		{
			String sql1 = "insert into booking(customerid,distributer,lotno,bookingdate,cylinderno,name) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,m.getCustomerid());
			ps.setString(2,m.getDistributer());
			ps.setInt(3,m.getLotno());
			ps.setString(4,m.getBookingdate());
			ps.setInt(5,m.getCylinderno());
			ps.setString(6,m.getFullname());
			int i = ps.executeUpdate();
			if(i!=0)
			{
				status=true;
			}
			else
			{
				
				status=true;
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public static void deletebooking()
	{
		System.out.println("HI");
	}
}