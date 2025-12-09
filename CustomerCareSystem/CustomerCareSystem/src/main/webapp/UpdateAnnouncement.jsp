<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Announcement</title>
    <link rel="stylesheet" href="css/updateannouncement.css">
    <link rel="stylesheet" href="css/headfoot.css">
    <script src="js/updateannouncement.js"></script>
    
</head>
<body>

<header class="main-header">
    <div class="logo">🎓 <b>W I N T E R F E L L</b> - Higher Education [ Admin Panel ]</div>
    <nav>
        <ul class="nav-links">
            <li><a href="customercare.jsp">Admin Dashboard</a></li>
            <li><a href="adminacc.jsp">Profile</a></li>
        </ul>
    </nav>
</header>
<!-- java code -->
<%
	String id = request.getParameter("id");
	String title = request.getParameter("title");
	String description = request.getParameter("description");

%>
<div class="container">
    <h2>✏️ Update Announcement</h2>
    
    <form action="UpdateAnnouncement" method="post">
        
        <input type="hidden" name="id" value="<%= id %>" />
<br>
        <label>Title:</label>
        <input type="text" name="title" value="<%= title %>"/>
<br>
<br>
        <label>Description:</label>
        <textarea name="description"><%= description %></textarea>

        <button type="submit" class="update-btn">💾 Save Changes</button>
    </form>
</div>

<footer class="main-footer">
    <p>&copy; 2025 <b>W I N T E R F E L L</b> - Higher Education Support System | All rights reserved.</p>
</footer>
</body>
</html>
