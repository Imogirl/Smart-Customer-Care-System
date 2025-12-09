<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Profile</title>
    <link rel="stylesheet" href="css/updatetech.css">
    <link rel="stylesheet" href="css/headfoot.css">
</head>
<body>

<!-- Header section -->
<header class="main-header">
    <div class="logo">🎓 <b>W I N T E R F E L L</b> - Update Profile</div>
</header>

<!-- Main content -->
<main class="dashboard-container">
    <section class="profile-section">
        <div class="card">
            <h2>Update Tech Profile</h2>

<!-- Form to update tech supporter profile -->
 <form action="updatetech" method="post">
    <input type="hidden" name="id" value="${param.id}" />

	<!-- Input field for name -->
    <label>Name:</label>
    <input type="text" name="name" value="${param.name}" required />
 	<!-- Input field for address -->
    <label>Address:</label>
    <input type="text" name="address" value="${param.address}" required />
	<!-- Input field for phone number -->
    <label>Phone:</label>
    <input type="text" name="phone" value="${param.phone}" required maxlength="10"/>
	<!-- Input field for user name -->
    <label>Username:</label>
    <input type="text" name="username" value="${param.uname}" required />
	<!-- Input field for password -->
    <label>Password:</label>
    <input type="password" name="password" value="${param.psw}" required />
	<!-- Buttons for submitting or canceling -->
    <div class="button-group">
        <button type="submit">Save</button>
        <button type="button" onclick="history.back();">Cancel</button>
    </div>
</form>


        </div>
    </section>
</main>

<!-- Footer section -->
<footer class="main-footer">
    <p>&copy; 2025 <b>W I N T E R F E L L</b> - Higher Education Support System | All rights reserved.</p>
</footer>

</body>
</html>
