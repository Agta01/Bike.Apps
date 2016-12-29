/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Trias Fachrul Z
 */
public class ConnectDB {
    
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final String HOST = "localhost";
    private final String DB_NAME = "shop";
    private final String URL = "jdbc:mysql://" + HOST + "/" + DB_NAME;
    private Connection conn;
    private final String DRIVER = "com.mysql.jdbc.Driver";

    
    private static ConnectDB instance;

    public static ConnectDB getInstance() {
        if (instance == null) {
            instance = new ConnectDB();
        }
        return instance;
    }
    
    public Connection getConnection(){
       Connection con=null;
        try {
            Class.forName(DRIVER);
             try {
                 con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
             } catch (SQLException ex) {
                 Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
             }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;           
    }
    
    
}
