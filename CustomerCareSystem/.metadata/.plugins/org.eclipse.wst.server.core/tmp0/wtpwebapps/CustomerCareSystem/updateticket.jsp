<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Ticket</title>
    <link rel="stylesheet" href="css/updateticket.css">
    <link rel="stylesheet" href="css/headfoot.css">
</head>
<body>

	<%
		String id = request.getParameter("id");
		String userid = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
	%>

<!-- Header -->
<header class="main-header">
    <div class="logo">🎓 <b>W I N T E R F E L L</b> - Higher Education</div>
    <nav>
        <ul class="nav-links">
            <li><a href="customercarehome.jsp">Home</a></li>
            <li><a href=useracc.jsp>Profile</a></li>
        </ul>
    </nav>
</header>
<div class="form-container">
    <h2>Update Ticket</h2>
    
    <form action="updateticket" method="post">
    
        <input type="hidden" name="id" value="<%= id%>"/>
        <input type="hidden" name="userid" value="<%= userid%>"/>

        <label for="subject">Subject:</label>
        <input type="text" id="subject" name="subject" value="<%= subject%>" required /><br>

        <label for="description">Description:</label>
        <textarea id="description" name="description" required><%= description%></textarea><br>

        <label for="status">Status:</label>
       	<textarea id="status" name="status" readonly><%= status %></textarea><br>

        <input type="submit" value="Update Ticket" class="submit-btn" />
    </form>
</div>

<!-- Footer -->
<footer class="main-footer">
    <p>&copy; 2025 <b>W I N T E R F E L L</b> - Higher Education Support System | All rights reserved.</p>
</footer>
</body>
</html>
