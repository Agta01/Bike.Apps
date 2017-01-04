/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EmployeeModel;
import View.Employees;
import java.sql.SQLException;
/**
 *
 * @author sulistiana
 */
public class EmployeeController {
    private final EmployeeModel empModel = new EmployeeModel();
    
    public void insertEmployee(Employees Employees) throws SQLException{
        empModel.setEmp_name(Employees.getEmp_name1().getText());
        empModel.setEmp_status(Employees.getEmp_status1().getText());
        
        if (empModel.insertEmployee()) {
            System.out.println("Data Berhasil ditambahkan");
        }else{
            System.out.println("Data gagal ditambahkan");
        }
    }
}
