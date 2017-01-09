/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ProductModel;
import View.Warehouse;
import View.WarehouseInsert;
import View.WarehouseUpdate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sulistiana
 */
public class ProductController {

    private static ProductModel productModel = new ProductModel();

    public static void tambahAnggota(WarehouseInsert warehouseInsert) {
        int stock = Integer.parseInt(warehouseInsert.getInputJumlah().getText());
        int price = Integer.parseInt(warehouseInsert.getInputHarga().getText());

        productModel.setName(warehouseInsert.getInputNama().getText());
        productModel.setStock(stock);
        productModel.setPrice(price);

        if (productModel.insert()) {
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan !");
            warehouseInsert.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data !");
        }
    }

    public void updateShow(JTable table) {
//        productModel.setName(table.getInputNama().getText());
//        productModel.setStock(warehouseInsert.getInputJumlah().getText());
//        productModel.setPrice(warehouseInsert.getInputHarga().getText());

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        WarehouseUpdate wu = new WarehouseUpdate();

        int row = table.getSelectedRow();
        wu.getIdLabel().setText(table.getValueAt(row, 0).toString());
        wu.getInputNama().setText(table.getValueAt(row, 1).toString());
        wu.getInputJumlah().setText(table.getValueAt(row, 2).toString());
        wu.getInputHarga().setText(table.getValueAt(row, 3).toString());

        wu.setVisible(true);
//        if (.updateProduct()) {
//            JOptionPane.showMessageDialog(null, "Data berhasil di ubah !");
//            warehouseInsert.dispose();
//        } else {
//            JOptionPane.showMessageDialog(null, "Gagal mengubah data !");
//        }
    }

    public void updateChange(WarehouseUpdate warehouseUpdate) {
        int id = Integer.parseInt(warehouseUpdate.getIdLabel().getText());
        int stock = Integer.parseInt(warehouseUpdate.getInputJumlah().getText());
        int price = Integer.parseInt(warehouseUpdate.getInputHarga().getText());
        productModel = new ProductModel();

        productModel.setId(id);
        productModel.setName(warehouseUpdate.getInputNama().getText());
        productModel.setStock(stock);
        productModel.setPrice(price);

        System.out.println(id);
        productModel.updateProduct(productModel);

    }

    public void hapusProduct(JTable table) {

        Warehouse warehouse = new Warehouse();
        int option = JOptionPane.showConfirmDialog(warehouse, "Anda yakin akan menghapus product ini?");

        if (option == JOptionPane.OK_OPTION) {
            int row = table.getSelectedRow();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            productModel.setId(Integer.parseInt(table.getValueAt(row, 0).toString()));

            if (productModel.deleteProduct()) {
                JOptionPane.showMessageDialog(null, "Product berhasil dihapus !");
//                anggotaDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Menghapus Product !");
            }
            
        }

    }

    public boolean populateTable(JTable warehouseTable) {
        ProductModel product = new ProductModel();
        ArrayList<ProductModel> productList = product.showProduct();
        DefaultTableModel defaultTableModel = (DefaultTableModel) warehouseTable.getModel();

        defaultTableModel.setRowCount(0);

        for (ProductModel products : productList) {
            defaultTableModel.addRow(
                    new Object[]{
                        products.getId(),
                        products.getName(),
                        products.getStock(),
                        products.getPrice()
                    }
            );
        }

        warehouseTable.setModel(defaultTableModel);
        return defaultTableModel.getRowCount() != 0;
    }
}
