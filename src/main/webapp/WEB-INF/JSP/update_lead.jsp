<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h2>Lead | Update</h2>
    
     <form action="updatelead" method="post">
     <pre>
     <input type = "hidden" name ="id" value="${lead.id}"/>
      First Name <input type= "text" name ="firstName" value ="${lead.firstName}"/>
      last Name<input type="text" name ="lastName"value ="${lead.lastName}"/>
      email<input type="text" name="email"value ="${lead.email}"/>
      mobile<input type="text" name="mobile"value ="${lead.mobile}"/>
      <input type="submit" value="save"/>
      </pre>
      
     </form>
</body>
</html>