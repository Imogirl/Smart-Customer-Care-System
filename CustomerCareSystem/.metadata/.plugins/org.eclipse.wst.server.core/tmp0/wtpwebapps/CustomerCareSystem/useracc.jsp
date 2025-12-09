<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <link rel="stylesheet" href="css/useracc.css">
    <link rel="stylesheet" href="css/headfoot.css">
</head>
<body>

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

<div class="profile-container">
    <c:forEach var="user" items="${userDetails}">
    
    <c:set var = "id" value = "${user.id }"/>
    <c:set var = "name" value = "${user.name }"/>
    <c:set var = "address" value = "${user.address }"/>
    <c:set var = "phone" value = "${user.phone }"/>
    <c:set var = "stream" value = "${user.stream }"/>
    <c:set var = "uname" value = "${user.username }"/>
    <c:set var = "psw" value = "${user.password }"/>
    
    
        <div class="profile-card">
            <div class="profile-image">
                <img src="uploads/default-avatar.png" alt="Profile Picture">
            </div>
            <div class="profile-info">
                <h2>${user.name}</h2>
                <p class="bio">Welcome to your personal space. You can manage your academic and contact info here.</p>

                <div class="info-list">
                    
                    <p><span>Address:</span> ${user.address}</p>
                    <p><span>Phone:</span> ${user.phone}</p>
                    <p><span>Stream:</span> ${user.stream}</p>
                    <p><span>Username:</span> ${user.username}</p>
                    
                </div>

                <div class="actions">
                
                <c:url value = "updateuser.jsp" var ="userupdate">
                
                	<c:param name="id" value = "${id}"></c:param>
                	<c:param name="name" value = "${name}"></c:param>
                	<c:param name="address" value = "${address}"></c:param>
                	<c:param name="phone" value = "${phone}"></c:param>
                	<c:param name="stream" value = "${stream}"></c:param>
                	<c:param name="uname" value = "${uname}"></c:param>
                	<c:param name="psw" value = "${psw}"></c:param>
                	
                </c:url>
                    <a href="${userupdate}" class="btn">Edit Profile</a>
                    <a href="allticket?userid=${id}" class="btn">View Raise Tickets</a>
                    <a href="userlogout" class="btn logout">Logout</a>
                </div>
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
