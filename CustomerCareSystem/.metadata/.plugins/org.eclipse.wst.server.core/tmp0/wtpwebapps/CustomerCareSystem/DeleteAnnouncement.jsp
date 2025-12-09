<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Announcement</title>
    <link rel="stylesheet" href="css/deleteannouncement.css">
</head>
<body>

<%
	String id = request.getParameter("did");
	String title = request.getParameter("title");
	String description = request.getParameter("description");
%>
    <div class="confirm-box">
        <h2>⚠️ Confirm Deletion</h2>
        <p>Are you sure you want to delete this announcement?</p>

        <form action="DeleteAnnouncement" method="post">
            <input type="hidden" name="id" value="<%= request.getParameter("did") %>">
            <div class="buttons">
                <input type="submit" name="submit" value="Confirm" class="btn confirm">
                <a href="javascript:history.back()" class="btn cancel">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>
