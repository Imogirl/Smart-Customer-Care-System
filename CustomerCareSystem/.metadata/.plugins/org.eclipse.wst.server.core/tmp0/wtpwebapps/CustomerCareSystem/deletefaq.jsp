<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Confirmation</title>
    <!-- Linking the external CSS file for styling -->
    <link rel="stylesheet" type="text/css" href="css/deletefaq.css">
</head>
<body>
    <div class="container">
        <div class="card">
            <!-- Warning message for delete confirmation -->
            <h2 class="warning">⚠️ Warning!</h2>
            <p>Are you sure you want to delete this item?</p>
            <div class="buttons">
                <!-- Form to confirm deletion, submits to the deletefaqs servlet -->
                <form action="deletefaqs" method="post">
                    <!-- Hidden input to send the item ID from the request parameter -->
                    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
                    <!-- Submit button to confirm deletion -->
                    <button type="submit" class="btn confirm">Yes, Delete</button>
                </form>
                <!-- Cancel button that take user back to the previous page -->
                <a href="javascript:history.back()" class="btn cancel">Cancel</a>
            </div>
        </div>
    </div>
</body>
</html>
