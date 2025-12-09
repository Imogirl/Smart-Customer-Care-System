<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--java code-->
<%
	//check user and announcement data null or not
    if (request.getAttribute("allannouncement") == null || request.getAttribute("allUsers") == null) {
        response.sendRedirect("AnnouncementDisplayServlet");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Care - Higher Education</title>
    <link rel="stylesheet" href="css/customercare.css">
    <link rel="stylesheet" href="css/headfoot.css">
    <script src="js/announcement.js"></script>
    
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



<div class="container">


  
    <section class="knowledgebase-section">
        <h2>Knowledge Base</h2>
        <ul class="knowledge-list">
            <li><a href="docs/academic_calendar.pdf" target="_blank">📅 Academic Calendar 2024</a></li>
            <li><a href="docs/course_registration_guide.pdf" target="_blank">📘 Course Registration Guide</a></li>
            <li><a href="docs/exam_policy.pdf" target="_blank">📝 Exam Rules and Policies</a></li>
        </ul>
    </section>

    
     <section class="announcement-section-from">
        <h2>Add Announcement</h2>
        <form action="insert" method="post" class="announcement-form">
        
            <input type="text" name="title" placeholder="Announcement Title" required>
            <textarea name="description" rows="5" placeholder="Announcement Description...." required></textarea>
            
            <button type="submit">Upload Announcement</button>
            
        </form>
    </section>
    
    <section class="announcement-section">
        <h2>Latest Announcements</h2>

        
        <c:forEach var = "a" items = "${allannouncement}"><!-- key for array value -->
        <!-- data set for update and delete -->
        	<c:set  var = "id" value = "${a.id }"/>
        	<c:set  var = "title" value = "${a.title }"/>
        	<c:set  var = "description" value = "${a.description }"/>
        	
        <div class="announcement">
            <h4>📢 ${a.title}</h4>
            <p>${a.description}</p>
            
            <!-- update part -->
            	<c:url value = "UpdateAnnouncement.jsp" var = "updateAnnouncement">
            	
            		<c:param name = "id" value = "${id}"></c:param>
            		<c:param name = "title" value = "${title}"></c:param>
            		<c:param name = "description" value = "${description}"></c:param>
            		
            	</c:url>
            	<a href = "${updateAnnouncement}" class = "update-btn">Edit</a>	
            	
            <!-- delete part -->
            	<c:url value = "DeleteAnnouncement.jsp" var = "deleteAnnouncement">
            	
            		<c:param name = "did" value = "${id}"></c:param>
            		<c:param name = "title" value = "${title}"></c:param>
            		<c:param name = "description" value = "${description}"></c:param>
            		
            	</c:url>
            	<a href = "${deleteAnnouncement}" class = "delete-btn">Delete</a>
        </div>
        
        </c:forEach>
    </section>

  
    
       <section class="user-section">
    	<h2>Manage Users</h2>


    <c:forEach var="u" items="${allUsers}">
        <div class="user-card">
            <h4>${u.name}</h4>
            <p>User Name:${u.username }</p>
            <p>Address: ${u.address}</p>
           
            <a href="DeleteUser.jsp?id=${u.id}" class="delete-btn">Delete</a>
        </div>
    </c:forEach>
</section>

</div>

<footer class="main-footer">
    <p>&copy; 2025 <b>W I N T E R F E L L</b> - Higher Education Support System | All rights reserved.</p>
</footer>


</body>
</html>