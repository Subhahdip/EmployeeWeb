/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Employee;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class EmployeeService {

    public static EmployeeService employeeService = null;

    public static EmployeeService getInstance() {
        if (employeeService == null) {
            return new EmployeeService();
        } else {
            return employeeService;
        }
    }

    public ArrayList getAllEmployees() {

        ArrayList empList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employeedb.employees emp inner join employeedb.roles role on emp.roleId=role.roleId inner join employeedb.departments dpt on emp.departmentId=dpt.departmentId ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeID"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhone(rs.getString("phone"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setcarAllowance(rs.getString("carAllowance"));

                empList.add(emp);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Number of employees = " + empList.size());
        return empList;
    }

    public  boolean InsertEmployee(Employee emp) {
      boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "INSERT INTO employeedb.employees (firstName, lastName,phone,address,gender,age,basicSalary,carAllowance,departmentId,roleId)"
                    + " VALUES (?, ?, ?,?,?,?,?,?,?,?)";

            
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhone());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setString(5, emp.getGender());
            preparedStatement.setString(6, emp.getAge());
            preparedStatement.setString(7,emp.getBasicSalary());
            preparedStatement.setString(8, emp.getcarAllowance());
           //reparedStatement.setString(9, emp.getDepartmentId());
           //reparedStatement.setString(10, emp.getRoleId());
             preparedStatement.setString(9, emp.getDepartmentId());
              preparedStatement.setString(10, emp.getRoleId());
           System.out.println("preparedstatement :" +preparedStatement);
              int row = preparedStatement.executeUpdate();

            if(row==1)
            {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
       public  ArrayList searchEmployee(Employee emp) {
        ArrayList empList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employees e join departments d join roles r where e.departmentId = d.departmentId and e.roleId = r.roleId "
                    + "having firstName like ? and lastName like ? and phone like ? and gender like ? and departmentName like ? and roleName like ?";

            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, emp.getFirstName() + "%");
            preparedStatement.setString(2, emp.getLastName() + "%");
            preparedStatement.setString(3, emp.getPhone() + "%");
            preparedStatement.setString(4, emp.getGender() + "%");
            preparedStatement.setString(5,emp.getDepartmentName()+ "%");
            preparedStatement.setString(6, emp.getRoleName() + "%");
            
            System.out.print(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Employee empp = new Employee();
                empp.setAddress(rs.getString("address"));
                empp.setEmployeeId(rs.getString("employeeID"));
                empp.setFirstName(rs.getString("firstName"));
                empp.setLastName(rs.getString("lastName"));
                empp.setPhone(rs.getString("phone"));
                empp.setGender(rs.getString("gender"));
                empp.setAge(rs.getString("age"));
                empp.setDepartmentName(rs.getString("departmentName"));
                empp.setRoleName(rs.getString("roleName"));
                empp.setBasicSalary(rs.getString("basicSalary"));
                empp.setcarAllowance(rs.getString("carAllowance"));

                empList.add(empp);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       System.out.println("Number of employees = " + empList.size());
        return empList;
//To change body of generated methods, choose Tools | Templates.

    }
       
       
     public  Employee getEmployee(String employeeId) {

        Employee emp = new Employee();

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employees e, departments d, roles r "
                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId and  e.employeeID =?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, employeeId);

            ResultSet rs = preparedStatement.executeQuery();
             System.out.println("preparedstatement :" +preparedStatement);
            

            while (rs.next()) {

                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeID"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhone(rs.getString("phone"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setcarAllowance(rs.getString("carAllowance"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return emp;

    }
   
   
   
      public  boolean updateEmployee(Employee emp) {

        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE employeedb.employees\n"
                    + "SET firstName = ? , lastName = ? , phone = ? , address = ? ,\n"
                    + "gender = ? , age = ? , basicSalary = ?,carAllowance = ?, departmentId=?,roleId=?\n"
                    + "WHERE employeeID = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhone());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setString(5, emp.getGender());
            preparedStatement.setString(6, emp.getAge());
            preparedStatement.setString(7, emp.getBasicSalary());
            preparedStatement.setString(8, emp.getcarAllowance());
            preparedStatement.setString(9, emp.getDepartmentId());
            preparedStatement.setString(10, emp.getRoleId());
            
            
                       
            preparedStatement.setString(11,emp.getEmployeeId());
            
            int row = preparedStatement.executeUpdate();

            if(row==1)
            {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
