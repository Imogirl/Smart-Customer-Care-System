<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete User</title>
    <link rel="stylesheet" href="css/deleteuser.css">
</head>
<body>

<%
    String id = request.getParameter("id");
%>

<div class="confirm-box">
    <h2>⚠️ Confirm User Deletion</h2>
    <p>Are you sure you want to delete this user account?</p>

    <form action="DeleteUserServlet" method="post">
        <input type="hidden" name="id" value="<%= id %>">
        <div class="buttons">
            <input type="submit" name="submit" value="Confirm" class="btn confirm">
            <a href="javascript:history.back()" class="btn cancel">Cancel</a>
        </div>
    </form>
</div>

</body>
</html>
