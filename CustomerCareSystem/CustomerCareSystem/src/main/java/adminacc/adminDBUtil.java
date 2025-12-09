package adminacc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class adminDBUtil {
	
	//retrieve admin details method
	public static List<adminacc> retrieveadmin(String user,String pass)
	{
		//array list for return
		ArrayList <adminacc> adminacc= new ArrayList<> ();
		
		
		//DB connection
		String url = "jdbc:mysql://localhost:3306/admindb";
		String username = "root";
		String psw = "Imasha@2002";
		
		try
		{
			//Driver load
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,psw);
			
			Statement stmt = con.createStatement();
			
			String sql = "select * from adminacc where username='"+user+"'and password='"+pass+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String phone = rs.getString(4);
				String uid = rs.getString(5);
				String password = rs.getString(6);
				
				adminacc a = new adminacc(id,name,address,phone,uid,password);
				adminacc.add(a);
			}
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	return adminacc;
	}
	
	public static boolean insertannouncement(String title,String description)
	{
		boolean issuccess= false;
		
		String url = "jdbc:mysql://localhost:3306/admindb";
		String username = "root";
		String psw = "Imasha@2002";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,psw);
			
			Statement stmt = con.createStatement();
			
			String sql = "insert into announcement values (0,'"+title+"','"+description+"')";
			
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
	
	
	public static boolean updateannouncement(String id,String title,String description)
	{
		boolean issuccess= false;
		
		String url = "jdbc:mysql://localhost:3306/admindb";
		String username = "root";
		String psw = "Imasha@2002";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,psw);
			
			Statement stmt = con.createStatement();
			
			String sql = "update announcement set title = '"+title+"', description = '"+description+"' where id = '"+id+"'";
			
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
		
		
	
	public static List<announcement> retrieveannouncement()
	{
		ArrayList <announcement> announcementList= new ArrayList<> ();
		
		String url = "jdbc:mysql://localhost:3306/admindb";
		String username = "root";
		String psw = "Imasha@2002";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,psw);
			
			Statement stmt = con.createStatement();
			
			String sql = "select * from announcement";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String description = rs.getString(3);
				
				announcement a = new announcement(id,title,description);
				announcementList.add(a);
			}
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	return announcementList;
	}
	
	
	public static boolean deleteannouncement(String id)
	{
		boolean issuccess= false;
		if (id == null || id.isEmpty()) {
	        return false;  // Return false if the ID is null or empty
	    }
		
		String url = "jdbc:mysql://localhost:3306/admindb";
		String username = "root";
		String psw = "Imasha@2002";
		
		int convtdid = Integer.parseInt(id);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,psw);
			
			Statement stmt = con.createStatement();
			
			String sql ="delete from announcement where id = '"+convtdid+"'";
			
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


public static boolean adminupdate(String id,String name,String address,String phone,String uname,String password)
{
	boolean issuccess= false;
	
	String url = "jdbc:mysql://localhost:3306/admindb";
	String username = "root";
	String psw = "Imasha@2002";
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,username,psw);
		
		Statement stmt = con.createStatement();
		
		String sql = "update adminacc set name ='"+name+"' , address = '"+address+"',phone = '"+phone+"',username = '"+uname+"',password = '"+password+"' where id = '"+id+"'";
		
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

	public static boolean deleteuser(int id)
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
		
		String sql ="delete from useracc where id = '"+id+"'";
		
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
}

