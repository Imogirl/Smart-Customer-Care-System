<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update FAQ</title>
    <link rel="stylesheet" href="css/updatefaq.css"> 
    <script src="js/updatefaqs.js"></script>
    
</head>
<body>

<%
	//Retrieve FAQ data sent from another page
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String description = request.getParameter("description");
%>
<!-- Form  -->
<div class="form-wrapper">
    <h1>Update FAQ</h1>

    <!-- Form to submit updated FAQ data -->
    <form action="updatefaqs" method="post">
        <!-- ID field -->
        <label for="id">FAQ ID:</label>
        <input type="text" id="id" name="id" value="<%= id %>" readonly><br>

        <!-- Question input -->
        <label for="name">Question:</label>
        <input type="text" id="name" name="name" value="<%= name %>" required><br>

        <!-- Answer textarea -->
        <label for="description">Answer:</label>
        <textarea id="description" name="description" required><%= description %></textarea><br>

        <!-- Submit button -->
        <button type="submit">Update FAQ</button>
    </form>
</div>

</body>
</html>
