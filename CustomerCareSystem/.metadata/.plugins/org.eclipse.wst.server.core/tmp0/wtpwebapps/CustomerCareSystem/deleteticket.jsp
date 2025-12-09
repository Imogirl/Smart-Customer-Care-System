<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Delete Ticket</title>
		<link rel="stylesheet" href="css/deleteticket.css">
		<link rel="stylesheet" href="css/headfoot.css">
</head>
<body>
	<%
		String userid = request.getParameter("id");
		String uid = request.getParameter("userid");
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

	<div class="confirmation-container">
    <h2>Are You Sure You Want to Delete This Ticket?</h2>
    <form action="deleteticket" method="post">
        <input type="hidden" name="id" value="<%=userid%>">
        <input type="hidden" name="userid" value="<%=uid%>">
        <input type="submit" name="submit" value="Confirm">
    </form>
</div>
		
		<!-- Footer -->
<footer class="main-footer">
    <p>&copy; 2025 <b>W I N T E R F E L L</b> - Higher Education Support System | All rights reserved.</p>
</footer>
</body>
</html>