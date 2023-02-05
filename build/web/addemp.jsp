
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Employee Management</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >

    <!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/5.0/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.0/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.0/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">


    

    
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
   
    <c:set var = "emp"  value="${Emp}"/>
<main class="form-signin">
    <form action="AddEmp" method="Post">
    <img class="mb-4" src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Please Add Employee</h1>
   

    
<div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="First Name" name="firstName">
      <label for="floatingInput">First Name</label>
    </div>
<div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Last Name" name="lastName">
      <label for="floatingInput">Last Name</label>
    </div>
<div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="phone" name="phone">
      <label for="floatingInput">phone</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="address" name="address">
      <label for="floatingInput">address</label>
    </div>
<div class="form-floating">
 <select name="gender" class="form-select" id="gender">
    <option value="" selected="selected">Select Gender </option>
    <option value="male">Male </option>
    <option value="female">Female </option>
    <option value="Other">Other </option>
  </select>
     
    </div>
<div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="age" name="age">
      <label for="floatingInput">age</label>
      </div>
      
       <div class="form-floating">
                   <select name="departmentId" class="form-select" id="departmentId">
                       <option value="" selected="selected">Select Department </option>
                   <option value="1">Ops</option>
                   <option value="2">Java</option>
                   <option value="3">Accounts</option>
                   <option value="4">MuleSoft</option>
                   <option value="5">Fullstack</option>
                   </select>                         
                </div>
                      
                <div class="form-floating">
                    <select name="roleId" class="form-select" id="roleId">
                        <option value="" selected="selected">Select Role </option>
                   <option value="1">Manager</option>
                   <option value="2">HR Manager</option>
                   <option value="3">Employee</option>
                   </select>
                </div>
      
      
<div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="basicSalary" name="basicSalary">
      <label for="floatingInput">Basic Salary</label>
    </div>
      
      <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="carAllaowance" name="carAllowance">
      <label for="floatingInput">car Allaowance</label>
    </div>

    
    <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
    
    
   
  </form>
</main>


    
  </body>
</html>