<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="tf" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Login Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        .login-form h2 {
            margin-bottom: 20px;
            font-size: 24px;
            color: #333;
            text-align: center;
        }
        .login-form label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }
        .login-form input[type="text"],
        .login-form input[type="number"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .login-form button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .login-form button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="login-form">
    <h2> Recevier  Details </h2>
    <tf:form  action="reseverdetails"  modelAttribute="transfer">
        <label for="name">Name</label>
        <input type="text"  name="custName" />
        
        <label for="account">Account Number</label>
        <input type="number" name="acNumber"/>
        
        <label for="amount">Amount</label>
        <input type="number" name="Amount" />
        
        <label for="bank">Bank Name</label>
        <tf:input type="text" path="BankName" readonly="true"/>
        
        <button type="submit">Submit</button>
    </tf:form>
</div>

</body>
</html>
