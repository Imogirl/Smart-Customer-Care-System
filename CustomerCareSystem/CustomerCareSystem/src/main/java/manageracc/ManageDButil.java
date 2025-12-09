package manageracc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import adminacc.adminacc;

public class ManageDButil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
    
	public static boolean validate(String username, String password) {
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from manage where username='"+username+"' and password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<manager> getManager(String userName) {
		
		ArrayList<manager> Manager = new ArrayList<>();
		
		try {
			
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from admin where username='"+userName+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String role = rs.getString(4);
				String status = rs.getString(5);
				String username = rs.getString(6);
				String password = rs.getString(7);
				
				
				manager M = new manager(id,name,email,role,status,username,password);
				Manager.add(M);
			}
			
		} catch (Exception e) {
			
		}
		
		return Manager;	
	}
    
    public static boolean insertAdmin(String name, String address, String phone, String username, String password) {
    	
    	boolean isSuccess = false;
    	
    	String url = "jdbc:mysql://localhost:3306/admindb";
		String user = "root";
		String psw = "Imasha@2002";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,user,psw);
			
			Statement stmt = con.createStatement();
    	    String sql = "insert into adminacc values (0,'"+name+"','"+address+"','"+phone+"','"+username+"','"+password+"')";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
 	
    return isSuccess;
    }
    
    public static boolean updateAdmin(String id, String name, String address, String phone, String username) {
        boolean isSuccess = false;
        String url = "jdbc:mysql://localhost:3306/admindb";
		String user = "root";
		String psw = "Imasha@2002";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,user,psw);
			
            String sql = "UPDATE adminacc SET name=?, address=?, phone=?, username=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, phone);
            stmt.setString(4, username);
            stmt.setString(5, id);

            int result = stmt.executeUpdate();
            if (result > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

 
    public static List<manager> getmanager(String Id) {
    	
    	int convertedID = Integer.parseInt(Id);
    	
    	ArrayList<manager> Man = new ArrayList<>();
    	
    	try {
    		
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from customer where id='"+convertedID+"'";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			int id = rs.getInt(1);
    			String name = rs.getString(2);
    			String email = rs.getString(3);
    			String role = rs.getString(4);
    			String status = rs.getString(5);
    			String username = rs.getString(6);
				String password = rs.getString(7);
    			
				manager c = new manager(id,name,email,role,status,username,password);
    			Man.add(c);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return Man;	
    }
    
    
    public static boolean Admindelete(String id) {
        boolean isSuccess = false;

        String url = "jdbc:mysql://localhost:3306/admindb";
		String user = "root";
		String psw = "Imasha@2002";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,user,psw);
			
			Statement stmt = con.createStatement();
            String sql = "DELETE FROM adminacc WHERE id = '"+id+"'";
           
            int result = stmt.executeUpdate(sql);

            if (result > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    
public static List<adminacc> getadmin() {
    	
    	
    	
    	ArrayList<adminacc> admin = new ArrayList<>();
    	String url = "jdbc:mysql://localhost:3306/admindb";
		String user = "root";
		String psw = "Imasha@2002";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,user,psw);
			
			Statement stmt = con.createStatement();
    		String sql = "select * from adminacc";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			int id = rs.getInt(1);
    			String name = rs.getString(2);
    			String address = rs.getString(3);
    			String phone = rs.getString(4);
    			String username = rs.getString(5);
    			String password = rs.getString(6);
    			
    			adminacc c = new adminacc(id,name,address,phone,username,password);
    			admin.add(c);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return admin;	
    }

}
