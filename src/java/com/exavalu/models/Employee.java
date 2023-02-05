/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.DepartmentService;
import com.exavalu.services.EmployeeService;
import com.exavalu.services.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class Employee extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String gender;
    private String age;
    private String departmentName;
    private String roleName;
    private String basicSalary;
    private String carAllowance;

    private String departmentId;
    private String roleId;

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
    }
//    public ArrayList getAllEmployees() throws Exception {
//        //String result = "FAILURE";
//
//        ArrayList emplist = EmployeeService.getInstance().getAllEmployees();
//
//
//        return emplist;
//    }

    public String insertEmployee() throws Exception {
        String result = "FAILURE";
//        ArrayList deptList = DepartmentService.getInstance().getAllDepartment();
//        ArrayList roleList = RoleService.getInstance().getAllRole();
//        sessionMap.put("DeptList", deptList);
//            sessionMap.put("RoleList", roleList);

        boolean success = EmployeeService.getInstance().InsertEmployee(this);

        if (success) {
            System.out.println("returning Success from InsertEmployee method");
            result = "SUCCESS";
            ArrayList emplist=EmployeeService.getInstance().getAllEmployees();
        
            sessionMap.put("EmpList", emplist);


       
        } else {
            System.out.println("returning Failure from InsertEmployee method");
        }

        return result;
    }

    public String searchEmployee() throws Exception {
        String result = "FAILURE";
        ArrayList empList = EmployeeService.getInstance().searchEmployee(this);
        ArrayList deptList = DepartmentService.getInstance().getAllDepartment();
        ArrayList roleList = RoleService.getInstance().getAllRole();
        System.out.println(empList.size());
        if (empList != null) {
            sessionMap.put("EmpList", empList);
            sessionMap.put("DeptList", deptList);
            sessionMap.put("RoleList", roleList);
            result = "SUCCESS";
        }

        return result;
    }
    
    public String editEmployee() throws Exception {
       
          String result = "SUCCESS";
         Employee emp = EmployeeService.getInstance().getEmployee(this.employeeId);
         System.out.println("Employee first name:" +emp.getFirstName());
         sessionMap.put("Emp",emp);

        return result;
         
        
    }
    
    public String updateService() throws Exception {
        String result = "FAILURE";

        boolean success = EmployeeService.getInstance().updateEmployee(this);

        if (success) {
            System.out.println("returning Success from updateemployee method");
             ArrayList emplist=EmployeeService.getInstance().getAllEmployees();
        
            sessionMap.put("EmpList", emplist);
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from updateemployee method");
        }

        return result;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getcarAllowance() {
        return carAllowance;
    }

    public void setcarAllowance(String carAllowance) {
        this.carAllowance = carAllowance;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the employeeId
     */
}
