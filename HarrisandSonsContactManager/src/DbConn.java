import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.TableModel;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;

/** This class connects the application to the database */
public class DbConn {
	/** This strings are used as the connection credentials */
	String connString = "jdbc:mysql://it212db.c4zu499kghzi.us-east-1.rds.amazonaws.com/HarrisandSonsContactsDb";
	String username = "admin";
	String password = "Heemiola123!";
	java.sql.Connection conn = null;
	
	/** This method is used to connect to the SQL database using the credentials specified above */
	public DbConn() {
		try {
			conn = DriverManager.getConnection(connString,username,password);
			System.out.println("Connected!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Not Connected!");
		}
	}
	
	/** This method is used to populate the table_PersonalContacts
	 * calling the selectAllPersonal() store procedure from SQL database */
	public ResultSet GetAllPersonal() {
		ResultSet rs = null;
		String sql = "{CALL selectAllPersonal()}";
		try {
			java.sql.CallableStatement cst = conn.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;	
	}
	
	/** This method is used to Update selected entry by the PersonalContact class and calls the updatePersonal() store procedure from SQL database 
	 * using the parameters passed to the method*/
	public void UpdatePersonal(String Fname, String Lname, String Email, String Address1, String Address2, String PostCode, String City, String TelNumber, int id) {
		ResultSet rs = null;
		String sql = "{CALL updatePersonal(?,?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst = conn.prepareCall(sql);		
			cst.setInt(1, id);
			cst.setString(2, Fname);
			cst.setString(3, Lname);
			cst.setString(4, Email);
			cst.setString(5, Address1);
			cst.setString(6, Address2);
			cst.setString(7, PostCode);
			cst.setString(8, City);
			cst.setString(9, TelNumber);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** This method is used to Insert new entry by the PersonalContact class and calls the insertPersonal() store procedure 
	 * using the parameters passed to the method
	 * */
	public void InsertPersonal(String Fname, String Lname, String Email, String Address1, String Address2, String PostCode, String City, String TelNumber) {
		ResultSet rs = null;
		String sql = "{CALL insertPersonal(?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst = conn.prepareCall(sql);					
			cst.setString(1, Fname);
			cst.setString(2, Lname);
			cst.setString(3, Email);
			cst.setString(4, Address1);
			cst.setString(5, Address2);
			cst.setString(6, PostCode);
			cst.setString(7, City);
			cst.setString(8, TelNumber);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** This method is used for deleting the entry by the PersonalContact class and calls the deletePersonal() procedure
	 * 
	 * using the @param id
	 */
	public void DeletePersonal(int id) {
		ResultSet rs = null;
		String sql = "{CALL deletePersonal(?)}";
		try {
			java.sql.CallableStatement cst = conn.prepareCall(sql);
			cst.setInt(1, id);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	/** This method is used to populate the table_BusinessContacts
	 * calling the selectAllBusiness() store procedure from SQL database */
	public ResultSet GetAllBusiness() {
		ResultSet rs = null;
		String sql = "{CALL selectAllBusiness()}";
		try {
			java.sql.CallableStatement cst = conn.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;	
	}
	
	/** This method is used to Update selected entry by the PersonalContact class and calls the updateBusiness() store procedure from SQL database 
	 * using the parameters passed to the method*/
	public void UpdateBusiness(String Fname, String Lname, String Email, String Address1, String Address2, String PostCode, String City, String TelNumber, int id) {
		ResultSet rs = null;
		String sql = "{CALL updateBusiness(?,?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst = conn.prepareCall(sql);		
			cst.setInt(1, id);
			cst.setString(2, Fname);
			cst.setString(3, Lname);
			cst.setString(4, Email);
			cst.setString(5, Address1);
			cst.setString(6, Address2);
			cst.setString(7, PostCode);
			cst.setString(8, City);
			cst.setString(9, TelNumber);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** This method is used to Insert new entry by the PersonalContact class 
	 * and calls the insertBusiness() store procedure 
	 * using the parameters passed to the method
	 * */
	public void InsertBusiness (String Fname, String Lname, String Email, String Address1, String Address2, String PostCode, String City, String TelNumber) {
		ResultSet rs = null;
		String sql = "{CALL insertBusiness(?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst = conn.prepareCall(sql);					
			cst.setString(1, Fname);
			cst.setString(2, Lname);
			cst.setString(3, Email);
			cst.setString(4, Address1);
			cst.setString(5, Address2);
			cst.setString(6, PostCode);
			cst.setString(7, City);
			cst.setString(8, TelNumber);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** This method is used for deleting the entry by the PersonalContact 
	 * class and calls the deleteBusiness() procedure 
	 * using the @param id
	 */
	public void DeleteBusiness (int id) {
		ResultSet rs = null;
		String sql = "{CALL deleteBusiness(?)}";
		try {
			java.sql.CallableStatement cst = conn.prepareCall(sql);
			cst.setInt(1, id);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
	}	
}
