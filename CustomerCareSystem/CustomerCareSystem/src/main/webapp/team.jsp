<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  



<%
if (request.getAttribute("admin") == null){
    response.sendRedirect("AdminViewServlet");
    return;
}
%>  


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Team</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
    }

    body {
      font-family: Arial, sans-serif;
      background: #f4f7fa;
      display: flex;
    }
    .sidebar ul {
     list-style-type: none;
     padding: 0;
     margin: 0;
    }


    /* Sidebar */
    .sidebar {
      width: 240px;
      height: 100vh;
      background-color: #1f1f2e;
      color: white;
      padding: 20px;
      position: fixed;
      top: 0;
      left: 0;
    }

    .sidebar h2 {
      font-size: 1.5rem;
      margin-bottom: 2rem;
      margin-top: 23px;

    }

    .sidebar a {
      display: block;
      color: #cfd3e3;
      text-decoration: none;
      margin: 15px 0;
      padding:  0.5rem 1rem;
      border-radius: 8px;
      transition: 0.3s;
      font-size: 1.2rem;
    }

    .sidebar a:hover {
      background-color: #34495e;
    }

    /* Main content */
    .main-content {
      margin-left: 220px;
      padding: 30px;
      width: calc(100% - 220px);
    }

    table {
      width: 100%;
      border-collapse: collapse;
      background-color: #fff;
      box-shadow: 0 2px 10px rgba(0,0,0,0.05);
      border-radius: 10px;
      overflow: hidden;
      margin-top:50px;
    }

    th, td {
      padding: 12px 15px;
      text-align: left;
    }

    thead {
      background-color: #eef1f5;
    }

    th {
      font-weight: bold;
    }

    tbody tr {
      border-bottom: 1px solid #eee;
    }

    tbody tr:hover {
      background-color: #f9fbfc;
    }

    .status {
      display: inline-block;
      padding: 5px 10px;
      border-radius: 12px;
      font-size: 12px;
      background-color: #d4edda;
      color: #155724;
    }

    .role {
      font-size: 14px;
      color: #666;
    }
  </style>

</head>
<body style=" margin: 0; padding: 0; height: 100vh; display: flex; justify-content: center; align-items: center; background-color: #f2f2f2; font-family: Arial, sans-serif;">

  <div class="sidebar">
    <h2>P.D.Kalindu</h2>
      <ul>
          <li><a href="manage.jsp">🧾 Dashboard</a></li>
          <li><a href="team.jsp">👥 Team</a></li>
          <li><a href="reports.jsp">📈 Report</a></li>
          <li><a href="login.jsp" style="color: darkgray; margin-top: 25px; margin-left: ;">⏻ Logout</a></li>
      </ul>    
  </div>

  <div class="main-content">
    
    <br>
  


    <form action="insertadmin" method="post" style=" margin-top:20px; background-color: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); width: 350px; font-family: Arial, sans-serif;">
        <input type="hidden" name="id">
        
        <label style="font-weight: bold;">Name:</label>
        <input type="text" name="name" style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;"><br>

        <label style="font-weight: bold;">Address:</label>
        <input type="text" name="address" style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;"><br>

        <label style="font-weight: bold;">Phone:</label>
        <input type="text" name="phone" style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;"><br>

        <label style="font-weight: bold;">Username:</label>
        <input type="text" name="username" style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;"><br>

		<label style="font-weight: bold;">Password:</label>
        <input type="text" name="password" style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;"><br>

        <input type="submit" value="Add Member" style="margin-top: 10px; width: 100%; height: 40px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer;">
    </form>


  
    
    <c:forEach var="a" items ="${admin}">
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Address</th>
          <th>Phone</th>
          <th>Username</th>
          
        </tr>
      </thead>
      
      
      <tbody>  
       <tr>
        <td>${a.id}</td>
        <td>${a.name}</td>
        <td>${a.address}</td>
        <td>${a.phone}</td>
        <td>${a.username}</td>
        <td>
           
           <!--Update-->
              <a href="Adminupdate.jsp?id=${a.id}&name=${a.name}&address=${a.address}&phone=${a.phone}&username=${a.username}">
                  <button class="actions">Update</button>
              </a>
              

              <!--Delete-->
              <a href="Admindelete?id=${a.id}" class="action-btn" onclick="return confirm('Are you sure you want to delete this admin?');">Delete</a>

        </td>
      
       </tr>  
      
     </tbody>
        
      
    </table>
    </c:forEach>
     
   </div>
  
 
</body>
</html>
    