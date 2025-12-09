<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
    <link rel="stylesheet" href="css/registerstyle.css">
</head>
<body>
<div class="form-container">
    <form action="register" method="post">
        <h2>Register</h2>

        <label for="name">Name</label>
        <input type="text" id="name" name="name" required>

        <label for="address">Address</label>
        <textarea id="address" name="address" required></textarea>

        <label for="phone">Phone</label>
        <input type="tel" id="phone" name="phone" required pattern="[0-9]{10}" title="Enter 10-digit number">

        <label for="stream">Stream</label>
       
        <select id="stream" name="stream" required>
            <option value="">Select Stream</option>
            <option value="Science">Science</option>
            <option value="Commerce">Commerce</option>
            <option value="Arts">Arts</option>
            <option value="Other">Other</option>
        </select>
        

        <label for="username">Username</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Register</button>
    </form>
</div>
</body>
</html>
