<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Ticket</title>
    <link rel="stylesheet" href="css/updatefaq.css"> 
</head>
<body>

<%
    
    String id = request.getParameter("id");
    String userid = request.getParameter("userid");
    String subject = request.getParameter("subject");
    String description = request.getParameter("description");
    String reply = request.getParameter("reply");
%>

<div class="form-wrapper">
    <h1>Reply Ticket</h1>

    <!-- Form to submit updated FAQ data -->
    <form action="replyticket" method="post">
        <!-- ID field -->
        <label for="id">Ticket ID:</label>
        <input type="text" id="id" name="id" value="<%= id %>" readonly><br>

        <!-- Question input -->
        <label for="name">User ID:</label>
        <input type="text" id="name" name="userid" value="<%= userid %>" readonly><br>

		<label for="name">Subject:</label>
        <input type="text" id="name" name="subject" value="<%= subject %>" readonly><br>
        
        <!-- Answer textarea -->
        <label for="description">Answer:</label>
        <textarea id="description" name="description" readonly><%= description %> </textarea><br>
        
        <label for="name">Reply:</label>
        <input type="text" id="name" name="reply" value="<%= reply %>" ><br>

        <!-- Submit button -->
        <button type="submit">Reply</button>
    </form>
</div>

</body>
</html>
