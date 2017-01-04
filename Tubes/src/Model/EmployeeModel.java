/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Connect.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sulistiana
 */
public class EmployeeModel {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    String emp_name;
    String emp_status;

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_status() {
        return emp_status;
    }

    public void setEmp_status(String emp_status) {
        this.emp_status = emp_status;
    }
    
    public boolean insertEmployee() throws SQLException{
        boolean toReturn = false;
        
        try{
//            sql insert
            String query = "INSERT INTO employee (id, emp_name, emp_status "+"VALUE (?, ?, ?)";
            Connection conn = ConnectDB.getInstance().getConnection();
            
            if (conn != null) {
                // create the mysql insert preparedstatement
                PreparedStatement pst;
                pst = conn.prepareStatement(query);
                pst.setString(1, null);
                pst.setString(2, emp_name);
                pst.setString(3, emp_status);

                // execute the preparedstatement
                pst.execute();

                conn.close();
                toReturn = true;
            }
            
            
        }catch(SQLException e){
            System.out.println("error : " + e.getMessage());
        }
        
        return toReturn;
    }
}
