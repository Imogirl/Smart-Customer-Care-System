<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	
    if (request.getAttribute("allannouncement") == null || request.getAttribute("allfaqs") == null) {
        response.sendRedirect("StudentDisplayServlet");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Care - Higher Education</title>
    <link rel="stylesheet" href="css/customercarehome.css">
    <link rel="stylesheet" href="css/headfoot.css">
    <script src="js/ticket.js"></script>
    
</head>
<body>

<header class="main-header">
    <div class="logo">🎓 <b>W I N T E R F E L L</b> - Higher Education</div>
    <nav>
        <ul class="nav-links">
            <li><a href="customercarehome.jsp">Home</a></li>
            <li><a href="useracc.jsp">Profile</a></li>
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


        <section class="ticket-section-from">
        <h2>Raise A Ticket</h2>
        <form action="ticketinsert" method="post" class="ticket-section">
        
            <input type="text" name="id" placeholder="Your Student ID" required>
            <input type="text" name="subject" placeholder="Subject" required>
            <textarea name="description" placeholder="Describe your issue..." required></textarea>
            
            <button type="submit">Submit Ticket</button>
            
        </form>
    </section>
    
    <section class="ticket-section">
        <h2>Latest Announcements</h2>
        
        <c:if test="${empty allannouncement}">
    		<c:redirect url="sDisplayServlet" />
		</c:if>
        
        <c:forEach var = "a" items = "${allannouncement}">
        
        	
        <div class="announcement">
            <h4>📢 ${a.title}</h4>
            <p>${a.description}</p>
            
        </div>
        
        </c:forEach>
    </section>

    
    <section class="faq-section">
        <h2>Frequently Asked Questions</h2>
        
         <c:forEach var = "f" items = "${allfaqs}">
        <div class="faq">
            <h4>❓ ${f.question}</h4>
            <p>${f.answer}</p>
        </div>
        </c:forEach>
        
    </section>

</div>

<footer class="main-footer">
    <p>&copy; 2025 <b>W I N T E R F E L L</b> - Higher Education Support System | All rights reserved.</p>
</footer>


</body>
</html>