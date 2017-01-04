/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ProductModel;
import View.WarehouseInsert;
import javax.swing.JOptionPane;

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
}
