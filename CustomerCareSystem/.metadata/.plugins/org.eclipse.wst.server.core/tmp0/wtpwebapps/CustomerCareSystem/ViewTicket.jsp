<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Tickets</title>
    <link rel="stylesheet" href="css/viewticket.css">
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

<div class="ticket-container">
    <h2>Your Support Tickets</h2>
    
 	<c:if test = "${empty ticket}">
   		<c:redirect url = "allticket"/>
  	</c:if>
 
   
   <c:forEach var="t" items="${ticket}">
    <div class="ticket-entry">
        <p><span>Subject:</span> ${t.subject}</p>
        <p><span>Description:</span> ${t.description}</p>
        <p><span>Status:</span> ${t.status}</p>

        <c:url value="updateticket.jsp" var="updateticket">
            <c:param name="id" value="${t.id}"/>
            <c:param name="userid" value="${t.userid}"/>
            <c:param name="subject" value="${t.subject}"/>
            <c:param name="description" value="${t.description}"/>
            <c:param name="status" value="${t.status}"/>
        </c:url>

        <a href="${updateticket}" class="update-btn">Update</a>

        <c:url value="deleteticket.jsp" var="deleteticket">
            <c:param name="id" value="${t.id}"/>
            <c:param name="userid" value="${t.userid}"/>
            <c:param name="subject" value="${t.subject}"/>
            <c:param name="description" value="${t.description}"/>
            <c:param name="status" value="${t.status}"/>
        </c:url>

        <a href="${deleteticket}" class="delete-btn">Delete</a>
    </div>
</c:forEach>

</div>

<!-- Footer -->
<footer class="main-footer">
    <p>&copy; 2025 <b>W I N T E R F E L L</b> - Higher Education Support System | All rights reserved.</p>
</footer>
</body>
</html>
