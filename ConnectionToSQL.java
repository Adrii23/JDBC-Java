package ConnectToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConnectionToSQL implements ConnectionToDB {
	
	private Connection con;
	private List<String> names=new ArrayList<String>();
	private List<String> nrID=new ArrayList<String>();
	private List<Float> grades=new ArrayList<Float>();
	
	public void connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public void getDataFromDB() {
		try {
			connectToDB();
			PreparedStatement statement = con.prepareStatement("select * from students");
		
			//create a variable to execute query
			ResultSet result = statement.executeQuery();
			while(result.next())
				{
					System.out.println(result.getInt(1) + " " + result.getString(2) + " " + result.getString(3) + " " + result.getFloat(4));
					//getString returns the data
					//1 is the first field in the table etc
				
					names.add(result.getString(2));
					nrID.add(result.getString(3));
					grades.add(result.getFloat(4));
				}
			}
			catch(Exception e) {
			System.out.println(e);
			}	
	}
	
	public List<String> getNames() {
		return names;
	}
	
	public List<String> getNrID() {
		return nrID;
	}
	
	public List<Float> getGrades() {
		return grades;
	}
	
}