<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign In</title>
    <link rel="stylesheet" href="css/login.css">
    <script src="js/login.js"></script>
    
</head>
<body>

<div class="login-container">
    <div class="login-card">
        <h2>Welcome 👋</h2>
        <p>Please log in to your account</p>
        
        <form action="signin" method="post">
            <label for="uid">Username</label>
            <input type="text" name="uid" id="uid" required>

            <label for="psw">Password</label>
            <input type="password" name="psw" id="psw" required>

            <input type="submit" value="Sign In">
        </form>

        <div class="footer">
            <p>Don't have an account? <a href="Register.jsp">Register here</a></p>
        </div>
    </div>
</div>

</body>
</html>