import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public static int insertCashier(String username, String password, String firstname, String lastname) throws Exception
	{
		String sql = "insert Into Cashier Values(?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, firstname);
			pstmt.setString(4, lastname);

			int executeUpdate = pstmt.executeUpdate();
			return executeUpdate;
		} finally 
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (conn!=null)
				conn.close();
		}
	}
	
	public static List<Cashier> displayAllCashiers() throws Exception
	{
		List<Cashier> result = new ArrayList<Cashier>();
		ResultSet rs=null;
		try {
			String sql = "select * from cashier";
			Statement stmt = getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String username = rs.getString("username");
				String lastname = rs.getString("lastname");
				String firstname = rs.getString("firstname");
				
				Cashier c = new Cashier();
				c.setUsername(username);
				c.setLastname(lastname);
				c.setFirstname(firstname);
				
				result.add(c);
			}
			return result;
		} 
		finally 
		{
		if (rs!=null) {
			rs.close(); //will be executed always
		}
		if (conn!=null)
			conn.close();
		}
	}
	
	public static int removeCashierbyUsername(String username) throws SQLException, Exception{
		String sql = "delete From cashier where username = ?";
		PreparedStatement pstmt=null;
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, username);		
			int executeUpdate = pstmt.executeUpdate();
			return executeUpdate;
		}catch (Exception e){
			return 0;
		}
		finally 
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (conn!=null)
				conn.close();
		}
	}
	
	public static int updateCashierLastname(String username, String newLastName) throws Exception
	{
		String sql = "update Cashier set lastname = '"+ newLastName +"' where username = " +"'"+ username+"'";
		Statement stmt=null;
		try {
			Connection cnn = getConnection();
			stmt = cnn.createStatement();
			int executeUpdate = stmt.executeUpdate(sql);
			return executeUpdate;
		} finally {
			if (stmt!=null){
		stmt.close();
			}
			if (conn!=null)
				conn.close();
		}
	}
	
	public static int insertShow(String title, String genre, String distribution, Date date, int noTickets) throws Exception
	{
		String sql = "insert Into teatru.show Values(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, genre);
			pstmt.setString(3, distribution);
			pstmt.setDate(4, date);
			pstmt.setInt(5, noTickets);

			int executeUpdate = pstmt.executeUpdate();
			return executeUpdate;
		} finally 
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (conn!=null)
				conn.close();
		}
	}
	
	public static List<Show> displayAllShows() throws Exception
	{
		List<Show> result = new ArrayList<Show>();
		ResultSet rs=null;
		try {
			String sql = "select * from teatru.show";
			Statement stmt = getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String title = rs.getString("title");
				String genre = rs.getString("genre");
				String distribution = rs.getString("distribution");
				Date date = rs.getDate("date");
				int notickets = rs.getInt("noTickets");
				
				Show c = new Show();
				c.setTitle(title);
				c.setGenre(genre);
				c.setDistribution(distribution);
				c.setDate(date);
				c.setNoTickets(notickets);
				
				result.add(c);
			}
			return result;
		} 
		finally 
		{
		if (rs!=null) {
			rs.close(); //will be executed always
		}
		if (conn!=null)
			conn.close();
		}
	}
	
	public static int removeShowByTitle(String title) throws SQLException, Exception{
		String sql = "delete From teatru.show where title = ?";
		PreparedStatement pstmt=null;
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, title);		
			int executeUpdate = pstmt.executeUpdate();
			return executeUpdate;
		}catch (Exception e){
			return 0;
		}
		finally 
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (conn!=null)
				conn.close();
		}
	}
	
	public static int updateShowDate(String title, String newDate) throws Exception
	{
		String sql = "update teatru.show set date = '"+ newDate +"' where title = " +"'"+ title+"'";
		Statement stmt=null;
		try {
			Connection cnn = getConnection();
			stmt = cnn.createStatement();
			int executeUpdate = stmt.executeUpdate(sql);
			return executeUpdate;
		} finally {
			if (stmt!=null){
		stmt.close();
			}
			if (conn!=null)
				conn.close();
		}
	}
	
	
	}