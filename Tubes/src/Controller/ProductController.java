/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ProductModel;
import View.WarehouseInsert;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import View.Warehouse;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sulistiana
 */
public class ProductController {

    private static ProductModel productModel = new ProductModel();

    public static void tambahAnggota(WarehouseInsert warehouseInsert) {
        productModel.setName(warehouseInsert.getInputNama().getText());
        productModel.setStock(warehouseInsert.getInputJumlah().getText());
        productModel.setPrice(warehouseInsert.getInputHarga().getText());

        if (productModel.insert()) {
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan !");
            warehouseInsert.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data !");
        }
    }
    
    public boolean populateTable(JTable jTable1){
        ProductModel product = new ProductModel();
        ArrayList<ProductModel> productList = product.showProduct();
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        
        defaultTableModel.setRowCount(0);
        
        productList.forEach((products) -> {
            defaultTableModel.addRow(
            
                    new Object[]{
                        products.getId(),
                        products.getName(),
                        products.getStock(),
                        products.getPrice()
                    }
                    
            );
        });
        
        jTable1.setModel(defaultTableModel);
        return defaultTableModel.getRowCount() != 0;
        
    }
    
}
