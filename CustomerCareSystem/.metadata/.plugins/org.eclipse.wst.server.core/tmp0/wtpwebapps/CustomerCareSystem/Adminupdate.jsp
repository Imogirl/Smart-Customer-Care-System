<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Admin</title>
</head>
<body style=" margin: 0; padding: 0; height: 100vh; display: flex; justify-content: center; align-items: center; background: linear-gradient(135deg, #2c3e50, #4ca1af); font-family: Arial, sans-serif;">

    <form action="update" method="post" style="background-color: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); width: 350px; font-family: Arial, sans-serif;">

        <input type="hidden" name="id" value="${param.id}" />

        <label style="font-weight: bold;">Name:</label>
        <input type="text" name="name" value="${param.name}" required style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;"><br>

        <label style="font-weight: bold;">Address:</label>
        <input type="text" name="address" value="${param.address}" required style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;"><br>

        <label style="font-weight: bold;">Phone:</label>
        <input type="text" name="phone" value="${param.phone}" required style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;"><br>

        <label style="font-weight: bold;">Username:</label>
        <input type="text" name="username" value="${param.username}" required style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;"><br>

        <input type="submit" value="Update" style="margin-top: 10px; width: 100%; height: 40px; background-color: #007bff; color: white; border: none; border-radius: 5px; cursor: pointer;">

    </form>

</body>

</html>
