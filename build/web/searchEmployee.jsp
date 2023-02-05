<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>        
        <title>Employee Management Web Application</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/product/">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/product.css" rel="stylesheet">
    </head>
    <body>



        <jsp:include page="menu.jsp"></jsp:include>





            <form action="Search" method="post">
                <div class="row">
                    <div class="col">
                        <input type="text" class="form-control" placeholder="First name" name="firstName">
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" placeholder="Last name" name="lastName">
                    </div>

                    <div class="col">
                        <input type="text" class="form-control" placeholder="Gender" name="gender">
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" placeholder="Phone" name="phone">
                    </div>
                    <div class="col">
                        <select name="departmentName" class="form-select" id="departmentName" >
                            <option value="">Select a Department</option>
                        <c:forEach var="dept" items="${DeptList}">
                            <option value= ${dept.getDepartmentName()} >  ${dept.getDepartmentName()}  </option>
                        </c:forEach>

                    </select>
                </div>
                <div class="col">

                    <select name="roleName" class="form-select" id="roleName" >
                        <option value="">Select a role</option>
                        <c:forEach var="role" items="${RoleList}">
                            <option value= ${role.getRoleName()}>  ${role.getRoleName()}  </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col">
                    <button type="submit" class="btn btn-primary" >Search</button>
                </div>

        </form>
        <%if (session.getAttribute("EmpList") != null) {%>

        <table class="table table-bordered table-hover">
            <tr>
                <td>
                    Employee Id
                </td>
                <td>
                    First Name
                </td>
                <td>
                    Last Name
                </td>
                <td>
                    Address
                </td>
                <td>
                    Phone
                </td>
                <td>
                    Gender
                </td>
                <td>
                    Age
                </td>
                <td>
                    Department
                </td>
                <td>
                    Role
                </td>
                <td>
                    Basic Salary
                </td>
                <td>
                    Car Allowance
                </td>
                <td>
                    Action
                </td>

            </tr>

            <c:forEach var="emp" items="${EmpList}">


                <tr>
                    <td>
                        ${emp.getEmployeeId()}
                    </td>
                    <td>
                        ${emp.getFirstName()}
                    </td>
                    <td>
                        ${emp.getLastName()}
                    </td>
                    <td>
                        ${emp.getAddress()}
                    </td>
                    <td>
                        ${emp.getPhone()}
                    </td>
                    <td>
                        ${emp.getGender()}
                    </td>
                    <td>
                        ${emp.getAge()}
                    </td>
                    <td>
                        ${emp.getDepartmentName()}
                    </td>
                    <td>
                        ${emp.getRoleName()}
                    </td>
                    <td>
                        ${emp.getBasicSalary()}
                    </td>
                    <td>
                        ${emp.getcarAllowance()}
                    </td>
                    <td> 

                        <a href=EditEmployee?employeeId= ${emp.getEmployeeId()}>
                            Edit
                        </a>



                    </td>
                </tr>


            </c:forEach>


        </table>
        <%}%>


    </div>

</body>
</html>