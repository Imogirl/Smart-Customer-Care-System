<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Profile</title>
    <link rel="stylesheet" href="css/updateadmin.css">
    <link rel="stylesheet" href="css/headfoot.css">
</head>
<body>

<header class="main-header">
    <div class="logo">🎓 <b>W I N T E R F E L L</b> - Update Profile</div>
</header>

<main class="dashboard-container">
    <section class="profile-section">
        <div class="card">
            <h2>Update Admin Profile</h2>

            <c:forEach var="admin" items="${adminDetails}">
            
            <form action="adminupdate" method="post">
                <input type="hidden" name="id" value="${admin.id}" />

                <label>Name:</label>
                <input type="text" name="name" value="${admin.name}" required />

                <label>Address:</label>
                <input type="text" name="address" value="${admin.address}" required />

                <label>Phone:</label>
                <input type="text" name="phone" value="${admin.phone}" required maxlength="10"/>

                <label>Username:</label>
                <input type="text" name="username" value="${admin.username}" required />

                <label>Password:</label>
                <input type="password" name="password" value="${admin.password}" required />

               <div class="button-group">
                    <button type="submit" class="btn update-btn">Save Changes</button>
                    <a href="adminacc.jsp" class="btn back-btn">Cancel</a>
                </div>
            </form>
            
            </c:forEach>

        </div>
    </section>
</main>

<footer class="main-footer">
    <p>&copy; 2025 <b>W I N T E R F E L L</b> - Higher Education Support System | All rights reserved.</p>
</footer>

</body>
</html>
