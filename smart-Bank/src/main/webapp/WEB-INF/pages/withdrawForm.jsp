<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://www.springframework.org/tags/form"  prefix="df"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1> Cash Withdraw  Form </h1>
<df:form action="withdraw" modelAttribute="deposit" >
Account Number : <input type="text" name="acNumber"> <br> <br>
Name : <input type="text" name="custName"> <br> <br>
Account Type : <input type="text" name="accountType"> <br> <br>
Enter Amount:  <input type="text" name="Amount"> <br> <br>
<input type="submit">
</df:form>
</div>
</body>
</html>