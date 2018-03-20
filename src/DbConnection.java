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
	
	public static int getNoOfTicketByTitle (String title) throws SQLException, Exception
	{
		String sql = "Select noTickets from teatru.show where title = ?";
		PreparedStatement pstmt = null;
		int aux = 0;
		
		try 
		{
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, title);	
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				aux = rs.getInt("noTickets");
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
		return aux;
	}
	
	public static int updateNoTickets(String title) throws Exception
	{
		int aux = DbConnection.getNoOfTicketByTitle(title);
		int noTick = aux +1 ;
		String sql = "update teatru.show set noTickets = '"+ noTick +"' where title = " +"'"+ title+"'";
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
	
	public static int insertTicket(String title, int row, int col) throws Exception
	{
		String sql = "insert Into ticket Values(?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setInt(2, row);
			pstmt.setInt(3, col);

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
	
	
	public static boolean checkIfSeatTaken(String title, int row, int col) throws SQLException, Exception
	{
		String sql = "Select * From Ticket where showtitle = ? AND row = ? AND col = ?";
		PreparedStatement pstmt=null;
		boolean usernameExists = false;
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, title);	
			pstmt.setInt(2, row);	
			pstmt.setInt(3, col);	
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
	
	public static List<Ticket> displayAllTickets() throws Exception
	{
		List<Ticket> result = new ArrayList<Ticket>();
		ResultSet rs=null;
		try {
			String sql = "select * from ticket order by showtitle";
			Statement stmt = getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String showTitle = rs.getString("showTitle");
				int row = rs.getInt("row");
				int col = rs.getInt("col");
				
				Ticket c = new Ticket();
				c.setShowTitle(showTitle);;
				c.setRow(row);
				c.setCol(col);
				
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
	
	public static int removeTicketByShowNameAndSeatAndCol(String showtitle, int row, int col) throws SQLException, Exception{
		String sql = "delete From ticket where showtitle = ? AND row = ? AND col = ?";
		PreparedStatement pstmt=null;
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, showtitle);	
			pstmt.setInt(2, row);	
			pstmt.setInt(3, col);	
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
	
	public static int updateSeatRow(String showtitle, int newRow, int oldRow, int col) throws Exception
	{
		int aux = DbConnection.getNoOfTicketByTitle(showtitle);
		int noTick = aux +1 ;
		String sql = "update ticket set row = '"+ newRow +"' where showtitle = " +"'"+ showtitle+"' AND col = " + col + " AND row = " + oldRow;
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
	
	public static int updateSeatCol(String showtitle, int row, int newCol, int oldCol) throws Exception
	{
		int aux = DbConnection.getNoOfTicketByTitle(showtitle);
		int noTick = aux +1 ;
		String sql = "update ticket set col = '"+ newCol +"' where showtitle = " +"'"+ showtitle+"' AND row = " + row + " AND col = " + oldCol;
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
	
	public static int noOfTicketSoldForAShow(String showTitle) throws SQLException, Exception
	{
		String sql = "Select COUNT(showtitle) From ticket where showtitle = ?";
		PreparedStatement pstmt=null;
		List<String> sids = new ArrayList<String>();
		boolean usernameExists = false;
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, showTitle);	
			ResultSet rs = pstmt.executeQuery();
			
			
			
			while (rs.next()) {
		        sids.add(rs.getString(1));
		    }
			
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
		return Integer.parseInt(sids.get(0));
	}
}