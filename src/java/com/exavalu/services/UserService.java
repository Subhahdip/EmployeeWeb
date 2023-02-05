/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;


import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class UserService {
    
    public static UserService userService = null;
    
    private UserService(){}
    
    public static UserService getInstance()
    {
        if(userService==null)
        {
            return new UserService();
        }
        else
        {
            return userService;
        }
    }
    
    public boolean doSignUp(User emp) {
        boolean success=false;
        
        Connection con=JDBCConnectionManager.getConnection();
         String sql = "INSERT INTO employeedb.users (emailAddress, password, firstName, lastName, status) VALUES (?, ?, ?, ?, ?);";

        try {
            //System.out.println("entering try block");
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, emp.getEmail());
            preparedStatement.setString(2, emp.getPassword());
            preparedStatement.setString(3, emp.getFirstName());
            preparedStatement.setString(4, emp.getLastName());
            preparedStatement.setInt(5, 1);
            

            preparedStatement.executeUpdate();
             System.out.println("LoginService :: "+preparedStatement);

           
                success=true;
            
            //con.close();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        return success;
}
}
    
    