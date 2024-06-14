<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="bf" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <script type="text/javascript" src="Javascript/LoginValidate.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
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
        }
        .login-form input[type="text"],
        .login-form input[type="number"],
        .login-form input[type="date"],
        .login-form input[type="radio"],
        .login-form textarea {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .login-form input[type="radio"] {
            width: auto;
        }
        .login-form label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }
        .login-form .account-type {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
        }
        .login-form .account-type label {
            margin: 0;
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
    <h2>Login Form</h2>
    <bf:form action="createaccount" modelAttribute="acc" onsubmit="return LoginValidate(this)" enctype="multipart/form-data">
        <label>Customer Name</label>
        <input type="text" name="custName" /><span id="errName"/>
        
        <label >Bank Name</label>
        <bf:input type="text" path="BankName" readonly="true"/>
        
        <label >Aadhaar Number</label>
        <input type="number"  name="aadhaarNumber"/>  <span id="errAadhaar"/>
        
        <label >Phone Number</label>
        <input type="number" name="mobileNumber" /><span id="errPhoneNumber"/>
        
        <label >PAN Number</label>
        <bf:input type="text"  path="pan"  /><span id="errPan"/>
        
        <label >Address</label>
           <bf:input type="text"  path="address"/> <span id="errAddress"/> 
           
        <label >PanCard</label>
           <bf:input type="file"     path="panCard"  /> 
            
        <label >Aadhaar Card</label>
           <bf:input type="file"  path="aadhar" />
           
        <label >Minimum Amount </label>
           <bf:input type="text"  path="Amount" placeholder="Minimum amount 500" /> <span id="errAmount"/>
           
        <label >Date of Birth</label>
        <bf:input type="datetime-local"  path="dob" /> <span id="errDob"/>
        
        
        <div class="account-type">
            <label for="account">Account Type</label>
             <label>
                <input type="radio" name="accountType" value="current" required> Current
            </label>
            <label>
                <input type="radio" name="accountType" value="savings" required> Savings
            </label>
        </div>
        
        <button type="submit">Submit</button>
    </bf:form>
</div>

</body>
</html>
