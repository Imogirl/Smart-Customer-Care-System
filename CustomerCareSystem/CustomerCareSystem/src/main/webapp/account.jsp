<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <c:forEach var="Man" items="${ManDetails}">
	
	 ${Man.id}
	 ${Man.name} 
	 ${Man.email}
	 ${Man.role} 
	 ${Man.status}  
	
  </c:forEach>	
	
  	

</body>
</html>