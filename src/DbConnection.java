import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	private static String driver = "org.gjt.mm.mysql.Driver";
	private static String preURL = "jdbc:mysql://";
	private static String host = "localhost";
	private static String port = "3306";
	private static String db = "teatru";
	private static String user = "root";
	private static String pass = "";
	private static Connection conn;
	static String connURL = preURL + host + ":" + port + "/" + db;
	
	public static Connection getConnection() throws Exception{
		  //Connect to the Database
		 
    	
    		if(conn != null && !conn.isClosed()) 
    		{
    			return conn;
    		}
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(connURL, user, pass);
			return conn;
			
			
	}
	
	public static boolean checkUserInAdmin(String username) throws SQLException, Exception
	{
		String sql = "Select * From Admin where username = ?";
		PreparedStatement pstmt=null;
		boolean usernameExists = false;
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, username);	
			ResultSet rs = pstmt.executeQuery();
			
			 usernameExists = rs.next();
			
		}catch (Exception e){
			
		}
		finally 
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (conn!=null)
				conn.close();
		}
		return usernameExists;
	}
	
	public static String givePasswordByUsernameAdmin (String username) throws SQLException, Exception
	{
		String sql = "Select password from admin where username = ?";
		PreparedStatement pstmt = null;
		String password= null;
		
		try 
		{
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, username);	
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				  password = rs.getString("Password");
				//  System.out.println(password + "\n");
				}
			
		}
		catch(Exception e)
		{}
		finally
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (conn!=null)
				conn.close();
		}
		return password;
	}
	
	public static boolean checkUserInCashier(String username) throws SQLException, Exception
	{
		String sql = "Select * From Cashier where username = ?";
		PreparedStatement pstmt=null;
		boolean usernameExists = false;
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, username);	
			ResultSet rs = pstmt.executeQuery();
			
			 usernameExists = rs.next();
			
		}catch (Exception e){
			
		}
		finally 
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (conn!=null)
				conn.close();
		}
		return usernameExists;
	}
	
	public static String givePasswordbyUsernameCashier (String username) throws SQLException, Exception
	{
		String sql = "Select password from cashier where username = ?";
		PreparedStatement pstmt = null;
		String password= null;
		
		try 
		{
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, username);	
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				  password = rs.getString("Password");
				//  System.out.println(password + "\n");
				}
			
		}
		catch(Exception e)
		{}
		finally
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (conn!=null)
				conn.close();
		}
		return password;
	}
	
	}