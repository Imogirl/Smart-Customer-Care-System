<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Profile</title>
    <link rel="stylesheet" href="css/adminstyle.css">
    <link rel="stylesheet" href="css/headfoot.css">
</head>
<body>


<header class="main-header">
    <div class="logo">🎓 <b>W I N T E R F E L L</b> - Higher Education [ Admin Panel ]</div>
    <nav>
        <ul class="nav-links">
            <li><a href="customercare.jsp">Admin Dashboard</a></li>
            <li><a href=adminacc.jsp>Profile</a></li>
        </ul>
    </nav>
</header>

<main class="dashboard-container">
    <section class="profile-section">
        <div class="card">
            <img src="images/profile.jpg" alt="Admin Profile" class="profile-pic">
            
            <!-- Data reading -->
            <c:forEach var="admin" items="${adminDetails}">
                <h2>${admin.name}</h2>
                
                <p><span>Address:</span> ${admin.address}</p>
                <p><span>Phone:</span> ${admin.phone}</p>
                <p><span>Username:</span> ${admin.username}</p>
                
            </c:forEach>
            
            <div class="button-group">
    			<form action="updateadmin.jsp" method="post" style="display: inline;">
        			<button type="submit" class="btn update-btn">Update Profile</button>
    			</form>

    			<form action="logout" method="post" style="display: inline;">
        			<button type="submit" class="btn logout-btn">Logout</button>
    			</form>
			</div>
        </div>
    </section>
</main>


<footer class="main-footer">
    <p>&copy; 2025 <b>W I N T E R F E L L</b> - Higher Education Support System | All rights reserved.</p>
</footer>

</body>
</html>