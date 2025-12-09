<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
<head>
	
    <meta charset="UTF-8">
    <title>Tech Supporter Profile</title>
    <link rel="stylesheet" href="css/techacc.css">
    <link rel="stylesheet" href="css/headfoot.css">
</head>
<body>

<!-- Header -->
<header class="main-header">
    <div class="logo">🎓 <b>W I N T E R F E L L</b> - Higher Education [Tech Profile]</div>
    <nav>
        <ul class="nav-links">
            <li><a href="techdashboard.jsp">Dashboard</a></li>
            <li><a href="techacc.jsp">Profile</a></li>
        </ul>
    </nav>
</header>

<h1>Tech Supporter Profiles</h1>

<div class="profile-container">
	<!-- Use for deta reading -->
    <c:forEach var="tech" items="${tech}">
        <div class="profile-card">
            <div class="profile-avatar">👤</div>
            <h2>${tech.name}</h2>
            <p><i class="fas fa-map-marker-alt"></i><strong> Address:</strong> ${tech.address}</p>
            <p><i class="fas fa-phone"></i><strong> Phone:</strong> ${tech.phone}</p>
            <p><i class="fas fa-user"></i><strong> Username:</strong> ${tech.username}</p>

            <div class="button-group">
                <!-- Generate URL to pass profile data to update page -->
                <c:url value="updatetech.jsp" var="techupdate">
                    <c:param name="id" value="${tech.id}" />
                    <c:param name="name" value="${tech.name}" />
                    <c:param name="address" value="${tech.address}" />
                    <c:param name="phone" value="${tech.phone}" />
                    <c:param name="uname" value="${tech.username}" />
                    <c:param name="psw" value="${tech.password}" />
                </c:url>

                <!-- Update and Logout buttons -->
                <a href="${techupdate}" class="contact-btn">Edit Profile</a>
                <a href="userlogout" class="logout-btn">Logout</a>
            </div>
        </div>
    </c:forEach>
</div>

<!-- Footer -->
<footer class="main-footer">
    <p>&copy; 2025 <b>W I N T E R F E L L</b> - Higher Education Support System | All rights reserved.</p>
</footer>

</body>
</html>
