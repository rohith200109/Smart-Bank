<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="bf" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>

<body>
<div style="text-align: center;">
<bf:form action="checkBalance" modelAttribute="cb" >
Account Number : <input type="text" name="acNumber"> <br> <br>
Name : <input type="text" name="custName"> <br> <br>
Account Type : <input type="text" name="accountType"> <br> <br>
<input type="submit">

</bf:form>
   </div>
</body>
</html>