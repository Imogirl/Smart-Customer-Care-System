package studentacc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class userDBUtil {
	
	public static boolean insertStudent(String name, String address, String phone, String stream, String user, String psw)
	{
		boolean isSuccess = false;
		
		//DB Connection
		
				String url = "jdbc:mysql://localhost:3306/userdb";
				String username = "root";
				String password = "Imasha@2002";
				
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
				
					Connection con = DriverManager.getConnection(url, username, password);
					
					Statement stmt = con.createStatement();
					
					String sql = "insert into useracc values (null,'"+name+"','"+address+"','"+phone+"','"+stream+"','"+user+"','"+psw+"')";
					
					System.out.println(sql);
					
					int rs = stmt.executeUpdate(sql);
					System.out.println("Rows affected: " + rs);

					if(rs > 0)
					{
						isSuccess = true;
					}
					else
					{
						isSuccess = false;
					}
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println(isSuccess);
				
				return isSuccess;
	}
	
	public static List<useracc> RetrieveUser(String user,String pass)
	{
		ArrayList<useracc> userarray = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/userdb";
		String username = "root";
		String password = "Imasha@2002";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			Statement stmt = con.createStatement();
			
			String sql = "select * from useracc where username = '"+user+"' and password = '"+pass+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String phone = rs.getString(4);
				String stream = rs.getString(5);
				String uid = rs.getString(6);
				String psw = rs.getString(7);
				
				useracc u = new useracc(id,name,address,phone,stream,uid,psw);
				
				userarray.add(u);
				
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userarray;
	}
	
	public static boolean insertticket(String id, String subject, String description)
	{
		boolean isSuccess = false;
		
		//DB Connection
		
				String url = "jdbc:mysql://localhost:3306/userdb";
				String username = "root";
				String password = "Imasha@2002";
				
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
				
					Connection con = DriverManager.getConnection(url, username, password);
					
					Statement stmt = con.createStatement();
					
					String sql = "insert into ticket (userid, subject, description) values ('"+id+"','"+subject+"','"+description+"')";
					
					int rs = stmt.executeUpdate(sql);
					
					if(rs == 1)
					{
						isSuccess = true;
					}
					else
					{
						isSuccess = false;
					}
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				return isSuccess;
	}
	
	public static List<useracc> getAllUsers() 
	{
        List<useracc> users = new ArrayList<>();
        
        String url = "jdbc:mysql://localhost:3306/userdb";
		String username = "root";
		String password = "Imasha@2002";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			Statement stmt = con.createStatement();
			
			String sql = "SELECT * FROM useracc";
			
			ResultSet rs = stmt.executeQuery(sql);

	        while (rs.next()) {
	            int id = rs.getInt(1);
	            String name = rs.getString(2);
	            String address = rs.getString(3);
	            String phone = rs.getString(4);
	            String stream = rs.getString(5);
	            String uname = rs.getString(6);
	            String psw = rs.getString(7);
	            

	            users.add(new useracc(id, name, address,phone,stream,uname,psw));
	        	
		}
		}
	    catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
        

        return users;
    }
	
	public static List<Ticket> RetrieveTickets(String userid)
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
			
			String sql = "select * from ticket where userid = '"+userid+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String uid = rs.getString(2);
				String subject = rs.getString(3);
				String description = rs.getString(4);
				String status = rs.getString(5);
				
				Ticket u = new Ticket(id,uid,subject,description,status);
				
				ticket.add(u);
				
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ticket;
	}
	
	public static boolean UpdateTicket(int id, String userid, String subject, String description, String status)
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
			
			String sql = "update ticket set subject = '"+subject+"', description = '"+description+"', status = '"+status+"' where id = '"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0)
			{
				isSuccess = true;
			}
			else
			{
				isSuccess = false;
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean DeleteTicket(String id)
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
			
			String sql = "delete from ticket where id = '"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0)
			{
				isSuccess = true;
			}
			else
			{
				isSuccess = false;
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	public static boolean updateuser(String id,String name,String address,String phone,String stream,String uname,String password)
	{
		boolean issuccess= false;
		
		String url = "jdbc:mysql://localhost:3306/userdb";
		String username = "root";
		String psw = "Imasha@2002";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,psw);
			
			Statement stmt = con.createStatement();
			
			String sql = "update useracc set name ='"+name+"' , address = '"+address+"',phone = '"+phone+"',stream = '"+stream+"',username = '"+uname+"',password = '"+password+"' where id = '"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs == 1)
			{
				issuccess = true;
			}
			else
			{
				issuccess = false;
			}
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return issuccess;
	}
	
	public static List<Faqs> getAllfaqs() 
	{
        List<Faqs> Faqs = new ArrayList<>();
        
        String url = "jdbc:mysql://localhost:3306/userdb";
		String username = "root";
		String password = "Imasha@2002";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			Statement stmt = con.createStatement();
			
			String sql = "SELECT * FROM faqs";
			
			ResultSet rs = stmt.executeQuery(sql);

	        while (rs.next()) {
	            int id = rs.getInt(1);
	            String quesition = rs.getString(2);
	            String answer = rs.getString(3);

	            Faqs.add(new Faqs(id, quesition, answer));
	        	
		}
		}
	    catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
        

        return Faqs;
    }

}
