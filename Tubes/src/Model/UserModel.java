/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Connect.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author sulistiana
 */
public class UserModel {
   
    private String username;
    private String password;
    private String jabatan;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String login() {
        String sql = "SELECT jabatan FROM user WHERE username = ? && password = ?";
        Connection conn = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jabatan = rs.getString("jabatan");
            } else {
                jabatan = "";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return jabatan;
    }
}
