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

    int id;
    String name;
    int stock;
    int price;
    private Connection conn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean insert() {
        boolean toReturn = false;
        try {

            String sql = "INSERT INTO product(id, prod_name, prod_stock, prod_price)" + " VALUES (?, ?, ?, ?)";
            Connection conn = ConnectDB.getInstance().getConnection();
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                pst.setString(2, name);
                pst.setInt(3, stock);
                pst.setInt(4, price);

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
    
    public boolean updateProduct (ProductModel pm) {
        boolean toReturn = false;
        try {
          
            String sql = "UPDATE product SET "
                    +"prod_name = ?, "
                    +"prod_stock = ?, "
                    +"prod_price = ? "
                    +"WHERE id = ? ";
            Connection conn = ConnectDB.getInstance().getConnection();
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                
                pst.setString(1, name);
                pst.setInt(2, stock);
                pst.setInt(3, price);
                pst.setInt(4, id);

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
    
    public ArrayList<ProductModel> showProduct(String search){
        ArrayList<ProductModel> productList = new ArrayList<>();
        String query = "SELECT * FROM product";
        if (!search.isEmpty()) {
            query = query + " WHERE product.id LIKE '%" + search +
                    "%' OR product.prod_name LIKE '%" + search +
                    "%' OR product.prod_stock LIKE '%" + search +
                    "%' OR product.prod_price LIKE '%" + search + "%'";
        }
        
        conn = ConnectDB.getInstance().getConnection();
        PreparedStatement pst;
        ResultSet rs;
        
        if (conn != null) {
            try{
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery();
            
                while (rs.next()){
                    ProductModel product = new ProductModel();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("prod_name"));
                    product.setStock(rs.getInt("prod_stock"));
                    product.setPrice(rs.getInt("prod_price"));
                    productList.add(product);
                }
                
                conn.close();
                return productList;
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
           
        }  
        return null;
    } 
    
    public boolean deleteProduct(){
        boolean toReturn=false;
        
        try{
            String query = "DELETE FROM product WHERE id = ? ";
            
            conn = ConnectDB.getInstance().getConnection();
            
            if (conn != null) {
                PreparedStatement pst;
                
                pst = conn.prepareStatement(query);
                pst.setInt(1, id);
                pst.execute();
                conn.close();
                toReturn = true;
                
            }
        }catch(SQLException e){
            System.out.println("Error= "+e.getMessage());
        }
        
        return toReturn;
    }

}
