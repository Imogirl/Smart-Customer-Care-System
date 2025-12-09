<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f0f8ff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .success-box {
            background-color: #d4edda;
            color: #155724;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            text-align: center;
        }
        .success-box h2 {
            margin-bottom: 15px;
        }
        .success-box button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 25px;
            font-size: 16px;
            border-radius: 8px;
            cursor: pointer;
            transition: 0.3s ease;
        }
        .success-box button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<div class="success-box">
    <h2>✔ Successfully Added!</h2>
    <p>Your data has been saved to the system.</p>
    <form action="customercare.jsp" method="post">
        <button type="submit">OK</button>
    </form>
</div>

</body>
</html>
