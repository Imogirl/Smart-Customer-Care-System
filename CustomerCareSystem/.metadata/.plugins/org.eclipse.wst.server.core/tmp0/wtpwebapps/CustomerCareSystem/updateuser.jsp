<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Profile</title>
    <link rel="stylesheet" href="css/updateuser.css">
    <link rel="stylesheet" href="css/headfoot.css">
</head>
<body>

<header class="main-header">
    <div class="logo">🎓 <b>W I N T E R F E L L</b> - Update Profile</div>
</header>

<main class="dashboard-container">
    <section class="profile-section">
        <div class="card">
            <h2>Update User Profile</h2>

           <form action="updateuser" method="post">
                <input type="hidden" name="id" value="${param.id}" />

                <label>Name:</label>
                <input type="text" name="name" value="${param.name}" required />

                <label>Address:</label>
                <input type="text" name="address" value="${param.address}" required />

                <label>Phone:</label>
                <input type="text" name="phone" value="${param.phone}" required maxlength="10"/>

                <label for="stream">Stream</label>
                <select id="stream" name="stream" required>
                    <option value="">Select Stream</option>
                    <option value="Science" <c:if test="${param.stream == 'Science'}">selected</c:if>>Science</option>
                    <option value="Commerce" <c:if test="${param.stream == 'Commerce'}">selected</c:if>>Commerce</option>
                    <option value="Arts" <c:if test="${param.stream == 'Arts'}">selected</c:if>>Arts</option>
                    <option value="Other" <c:if test="${param.stream == 'Other'}">selected</c:if>>Other</option>
                </select>

                <label>Username:</label>
                <input type="text" name="username" value="${param.uname}" required />

                <label>Password:</label>
                <input type="password" name="password" value="${param.psw}" required />

                <div class="button-group">
                    <button type="submit" class="btn update-btn">Save Changes</button>
                    <a href="useracc.jsp" class="btn back-btn">Cancel</a>
                </div>
            </form>

        </div>
    </section>
</main>

<footer class="main-footer">
    <p>&copy; 2025 <b>W I N T E R F E L L</b> - Higher Education Support System | All rights reserved.</p>
</footer>

</body>
</html>