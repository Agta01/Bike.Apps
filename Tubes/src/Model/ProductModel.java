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
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author sulistiana
 */
public class ProductModel {

    String id;
    String name;
    String stock;
    String price;
    private Connection conn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
    
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean insert() {
        boolean toReturn = false;
        try {

            String sql = "INSERT INTO product(id, prod_name, prod_stock, prod_price)" + " VALUES (?, ?, ?, ?)";
            Connection conn = ConnectDB.getInstance().getConnection();
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);
                pst.setString(2, name);
                pst.setString(3, stock);
                pst.setString(4, price);

                // execute the preparedstatement
                pst.execute();

                conn.close();
                toReturn = true;
            }

        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }

        return toReturn;
    }
    
    public boolean updateProduct () {
        boolean toReturn = false;
        try {
            
            String sql = "UPDATE product "
                    +"id, "
                    +"prod_name, "
                    +"prod_stock"
                    +"prod_price"
                    +"WHERE id = ?";
            Connection conn = ConnectDB.getInstance().getConnection();
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);
                pst.setString(2, name);
                pst.setString(3, stock);
                pst.setString(4, price);

                // execute the preparedstatement
                pst.execute();

                conn.close();
                toReturn = true;
            }
            
        } catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        return toReturn;
    }
    
    public ArrayList<ProductModel> selectProduct(){
        ArrayList<ProductModel> productList = new ArrayList<>();
        String query = "SELECT * FROM product";
        
//        KONEKSI
        conn = ConnectDB.getInstance().getConnection();
        
        if (conn != null) {
           try{
               PreparedStatement pst = conn.prepareStatement(query);
               
               ResultSet rs;
               rs = pst.executeQuery();
               
               while (rs.next()) {
                    ProductModel product = new ProductModel();
                    product.setId(rs.getString("id"));
                    product.setName(rs.getString("prod_name"));
                    product.setStock(rs.getString("prod_stock"));
                    product.setPrice(rs.getString("prod_price"));
                }
                conn.close();
                return productList;
           }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        return null;
    } 

}
