<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	if(request.getAttribute("allfaq") == null || request.getAttribute("allticket") == null)
	{
		response.sendRedirect("ViewFaqsServlet");
		return;
	}

 %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Technical Supporter Dashboard</title>
    <link rel="stylesheet" href="css/techdashboard.css"> 
    <link rel="stylesheet" href="css/headfoot.css">
    <script src="js/addfaqs.js"></script>

</head>
<body>
<!-- Header -->
<header class="main-header">
    <div class="logo">🎓 <b>W I N T E R F E L L</b> - Higher Education [Tech Panel]</div>
    <nav>
        <ul class="nav-links">
            <li><a href="techdashboard.jsp">Dashboard</a></li>
            <li><a href=techacc.jsp>Profile</a></li>
        </ul>
    </nav>
</header>

    <div class="dashboard-container">
      

        <main>
            <!-- FAQ Management Section -->
            <section id="viewFaqs">
                <h2>Manage FAQs</h2>

                <!-- Form to insert a new FAQ -->
                <div class="faq-form">
                    <form action="insertfaqs" method="post">
                        <input type="text" name="name" placeholder="Enter question" required>
                        <textarea name="answer" placeholder="Enter answer" required></textarea>
                        <button type="submit">Add FAQ</button>
                    </form>
                </div>

                <!-- Table to show all FAQs -->
                <table class="faq-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Question</th>
                            <th>Answer</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>

                   
                    <c:if test="${empty allfaq}">
                        <c:redirect url="getfaqs"/>
                    </c:if>

                    
                    <c:forEach var="faq" items="${allfaq}">
                        <tr>
                            <td>${faq.id}</td>
                            <td>${faq.name}</td>
                            <td>${faq.description}</td>
                            <td>
                                <!-- Create update link with parameters -->
                                <c:url value="updatefaq.jsp" var="updatefaq">
                                    <c:param name="id" value="${faq.id}"/>
                                    <c:param name="name" value="${faq.name}"/>
                                    <c:param name="description" value="${faq.description}"/>
                                </c:url>
                                <a href="${updatefaq}">Update</a>

                                <!-- Create delete link with parameters -->
                                <c:url value="deletefaq.jsp" var="deletefaq">
                                    <c:param name="id" value="${faq.id}"/>
                                    <c:param name="name" value="${faq.name}"/>
                                    <c:param name="description" value="${faq.description}"/>
                                </c:url>
                                <a href="${deletefaq}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </section>

            <!-- Raised Ticket Section -->
            <section id="raiseTicket">
                <h2>Raised Tickets</h2>

                <!-- Table to show list of raised tickets -->
                <table class="ticket-table">
                    <thead>
                        <tr>
                            <th>Ticket ID</th>
                            <th>User</th>
                            <th>Subject</th>
                            <th>Issue</th>
                            <th>Reply</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Retrive for the deta-->
                        <c:forEach var="ticket" items="${allticket}">
                            <tr>
                                <td>${ticket.id}</td>
                                <td>${ticket.uid}</td>
                                <td>${ticket.subject}</td>
                                <td>${ticket.description}</td>
                                <td>${ticket.reply}</td>
                                <td>
                                <!-- Create update link with parameters -->
                                <c:url value="replyticket.jsp" var="updateticket">
                                    <c:param name="id" value="${ticket.id}"/>
                                    <c:param name="userid" value="${ticket.uid}"/>
                                    <c:param name="subject" value="${ticket.subject}"/>
                                    <c:param name="description" value="${ticket.description}"/>
                                    <c:param name="reply" value="${ticket.reply}"/>
                                </c:url>
                                <a href="${updateticket}">Reply</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>
        </main>
    </div>
    
    <!-- Footer -->
<footer class="main-footer">
    <p>&copy; 2025 <b>W I N T E R F E L L</b> - Higher Education Support System | All rights reserved.</p>
</footer>
</body>
</html>
