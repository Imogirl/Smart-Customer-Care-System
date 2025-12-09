package techacc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class techDBUtil {
	
	//retrieve tech support details method
	public static List<tech> loginuser(String uid, String psw)
	{
		// array list for return 
		ArrayList<tech> tech = new ArrayList<>();
		
		// Database connection details
		String url = "jdbc:mysql://localhost:3306/tech";
		String username = "root";
		String password = "Imasha@2002";
		
		try
		{
			//Driver load
			Class.forName("com.mysql.jdbc.Driver");
			
			//Set the connection
			Connection con = DriverManager.getConnection(url,username,password);
			
			
			Statement stmt = con.createStatement();
			
			
			String sql = "select * from techacc where username = '"+uid+"'and password = '"+psw+"'";
			
			
			ResultSet rs  = stmt.executeQuery(sql);

			
			if(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String phone = rs.getString(4);
				String user = rs.getString(5);
				String pass = rs.getString(6);
				
				// Creating tech object with user data
				tech t = new tech(id,name,address,phone,user,pass);
				
				// Adding tech object to the list
				tech.add(t);
			}
		}
		catch(Exception e)
		{
			// Printing exception if any error occurs
			e.printStackTrace();
		}
		
		// Returning the list of tech objects
		return tech;
	}
	
	// Method to insert a new FAQ into the database
	public static boolean insertfaqs(String name, String answer)
	{
		boolean isSuccess = false;
		
		
		String url = "jdbc:mysql://localhost:3306/tech";
		String username = "root";
		String password = "Imasha@2002";
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			
			Statement stmt = con.createStatement();
			
			
			String sql = "insert into faqs values (0,'"+name+"','"+answer+"')";
			
			
			System.out.println("SQL query: " + sql);
			
			
			int rs  = stmt.executeUpdate(sql);

			// If insertion is successful, setting isSuccess to true
			if(rs == 1)
			{
				isSuccess = true;
				System.out.println("FAQ inserted successfully.");
			}
		}
		catch(Exception e)
		{
			// Printing exception if any error occurs
			e.printStackTrace();
		}
		
		// Returning the FAQ was inserted successfully or not
		return isSuccess;
	}
	
	
	public static List<faqs> getFaqs()
	{
		ArrayList<faqs> faq = new ArrayList<>();
		
		
		String url = "jdbc:mysql://localhost:3306/userdb";
		String username = "root";
		String password = "Imasha@2002";
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			
			Statement stmt = con.createStatement();
			
			
			String sql = "select * from faqs";
			
			
			System.out.println("SQL query: " + sql);
			
			
			ResultSet rs  = stmt.executeQuery(sql);

			//Result and adding FAQs to the list
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				
				// Creating FAQ object and adding it to the list
				faqs f = new faqs(id,name,description);
				
				faq.add(f);
			}
		}
		catch(Exception e)
		{
			// Printing exception if any error occurs
			e.printStackTrace();
		}
		
		// Returning the list of FAQs
		return faq;
	}
	
	// Method to update an existing FAQ in the database
	public static boolean updatefaq(int id, String name, String description)
	{
		boolean isSuccess = false;
		
		
		String url = "jdbc:mysql://localhost:3306/userdb";
		String username = "root";
		String password = "Imasha@2002";
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			
			Statement stmt = con.createStatement();
			
			
			String sql = "update faqs set question = '"+name+"',answer = '"+description+"' where id = '"+id+"'";
			
			
			System.out.println("SQL query: " + sql);
			
			
			int rs = stmt.executeUpdate(sql);
			
			// If update is successful, setting isSuccess to true
			if(rs == 1)
			{
				isSuccess = true;
			}
		}
		catch(Exception e)
		{
			// Printing exception if any error occurs
			e.printStackTrace();
		}
		
		// Returning whether the FAQ was updated successfully or not
		System.out.println(isSuccess);
		return isSuccess;
	}
	
	
	public static boolean deletefaq(int id)
	{
		boolean isSuccess = false;
		
		
		String url = "jdbc:mysql://localhost:3306/userdb";
		String username = "root";
		String password = "Imasha@2002";
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			
			Statement stmt = con.createStatement();
			
			
			String sql = "delete from faqs where id = '"+id+"'";
			
			
			System.out.println("SQL query: " + sql);
			
			
			int rs = stmt.executeUpdate(sql);
			
			// If deletion is successful, setting isSuccess to true
			if(rs == 1)
			{
				isSuccess = true;
			}
		}
		catch(Exception e)
		{
			// Printing exception if any error occurs
			e.printStackTrace();
		}
		
		// Returning the FAQ was deleted successfully or not
		System.out.println(isSuccess);
		return isSuccess;
	}
	
	public static boolean updatetech(int id, String name, String address,String phone,String uname,String psw)
	{
		boolean isSuccess = false;
		
		
		String url = "jdbc:mysql://localhost:3306/tech";
		String username = "root";
		String password = "Imasha@2002";
		
		try
		{
			//Driver load
			Class.forName("com.mysql.jdbc.Driver");
			
			//Set the connection
			Connection con = DriverManager.getConnection(url,username,password);
			
			
			Statement stmt = con.createStatement();
			
			
			String sql = "update techacc set name = '"+name+"',address = '"+address+"' ,phone = '"+phone+"' , username = '"+uname+"' , password = '"+psw+"' where id = '"+id+"'";
			
			
			System.out.println("SQL query: " + sql);
			
			
			int rs = stmt.executeUpdate(sql);
			
			// If update is successful, setting isSuccess to true
			if(rs == 1)
			{
				isSuccess = true;
			}
		}
		catch(Exception e)
		{
			// Printing exception if any error occurs
			e.printStackTrace();
		}
		
		// Returning whether the FAQ was updated successfully or not
		System.out.println(isSuccess);
		return isSuccess;
	}
	
	public static List<Ticket> gettickets()
	{
		ArrayList<Ticket> ticket = new ArrayList<>();
		
		
		String url = "jdbc:mysql://localhost:3306/userdb";
		String username = "root";
		String password = "Imasha@2002";
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			
			Statement stmt = con.createStatement();
			
			
			String sql = "select * from ticket";
			
			
			System.out.println("SQL query: " + sql);
			
			
			ResultSet rs  = stmt.executeQuery(sql);

			//Result and adding FAQs to the list
			while(rs.next())
			{
				int id = rs.getInt(1);
				String userid = rs.getString(2);
				String subject = rs.getString(3);
				String description = rs.getString(4);
				String reply = rs.getString(5);
				
				// Creating FAQ object and adding it to the list
				Ticket t = new Ticket(id,userid,subject,description,reply);
				
				ticket.add(t);
			}
		}
		catch(Exception e)
		{
			// Printing exception if any error occurs
			e.printStackTrace();
		}
		
		// Returning the list of FAQs
		return ticket;
	}
	
	public static boolean updateticket(int id, String userid, String subject,String description,String reply)
	{
		boolean isSuccess = false;
		
		
		String url = "jdbc:mysql://localhost:3306/userdb";
		String username = "root";
		String password = "Imasha@2002";
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			
			Statement stmt = con.createStatement();
			
			
			String sql = "update ticket set userid = '"+userid+"',subject = '"+subject+"' ,description = '"+description+"' , status = '"+reply+"'  where id = '"+id+"'";
			
			
			System.out.println("SQL query: " + sql);
			
			
			int rs = stmt.executeUpdate(sql);
			
			// If update is successful, setting isSuccess to true
			if(rs == 1)
			{
				isSuccess = true;
			}
		}
		catch(Exception e)
		{
			// Printing exception if any error occurs
			e.printStackTrace();
		}
		
		// Returning whether the FAQ was updated successfully or not
		System.out.println(isSuccess);
		return isSuccess;
	}
	
}
