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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

    public static void tambahProduct(WarehouseInsert warehouseInsert) {
        Warehouse warehose = new Warehouse();
        String name = warehouseInsert.getInputNama().getText();
        String stock = warehouseInsert.getInputJumlah().getText();
        String harga = warehouseInsert.getInputHarga().getText();
        if (!name.isEmpty()) {
            if (!stock.isEmpty()) {
                if (stock.matches("^\\d+$")) {
                    if (!harga.isEmpty()) {
                        if (harga.matches("^\\d+$")) {

                            int stockParse = Integer.parseInt(warehouseInsert.getInputJumlah().getText());
                            int priceParse = Integer.parseInt(warehouseInsert.getInputHarga().getText());

                            productModel.setName(name);
                            productModel.setStock(stockParse);
                            productModel.setPrice(priceParse);

                            if (productModel.insert()) {
                                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan !");
                                warehouseInsert.dispose();

                                Warehouse wi = new Warehouse();
                                wi.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Gagal menyimpan data !");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Harga Harus Angka");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Harga Tidak Boleh Kosong");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Jumlah Harus Angka");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Jumlah Tidak Boleh Kosong");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nama Tidak Boleh Kosong");
        }

    }

    public void updateShow(JTable table) {
//        productModel.setName(table.getInputNama().getText());
//        productModel.setStock(warehouseInsert.getInputJumlah().getText());
//        productModel.setPrice(warehouseInsert.getInputHarga().getText());

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        WarehouseUpdate wu = new WarehouseUpdate();

        int row = table.getSelectedRow();
        wu.getIdLabel().setText(table.getValueAt(row, 1).toString());
        wu.getInputNama().setText(table.getValueAt(row, 2).toString());
        wu.getInputJumlah().setText(table.getValueAt(row, 3).toString());
        wu.getInputHarga().setText(table.getValueAt(row, 4).toString());

        wu.setVisible(true);
//        if (.updateProduct()) {
//            JOptionPane.showMessageDialog(null, "Data berhasil di ubah !");
//            warehouseInsert.dispose();
//        } else {
//            JOptionPane.showMessageDialog(null, "Gagal mengubah data !");
//        }
    }

    public void updateChange(WarehouseUpdate warehouseUpdate) {
        productModel = new ProductModel();

        String name = warehouseUpdate.getInputNama().getText();
        String stock = warehouseUpdate.getJumlah().getText();
        String harga = warehouseUpdate.getInputHarga().getText();

//        VALIDASI UPDATE
        if (!name.isEmpty()) {
            if (!stock.isEmpty()) {
                if (stock.matches("^\\d+$")) {
                    if (!harga.isEmpty()) {
                        if (harga.matches("^\\d+$")) {

                            int id = Integer.parseInt(warehouseUpdate.getIdLabel().getText());
                            int stockParse = Integer.parseInt(warehouseUpdate.getInputJumlah().getText());
                            int priceParse = Integer.parseInt(warehouseUpdate.getInputHarga().getText());

                            productModel.setId(id);
                            productModel.setName(name);
                            productModel.setStock(stockParse);
                            productModel.setPrice(priceParse);

                            System.out.println(id);
                            productModel.updateProduct(productModel);

                        } else {
                            JOptionPane.showMessageDialog(null, "Harga Harus Angka");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Harga Tidak Boleh Kosong");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Jumlah Harus Angka");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Jumlah Tidak Boleh Kosong");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nama Tidak Boleh Kosong");
        }
//        END VALIDASI UPDATE

    }

    public void hapusProduct(JTable table) {

        Warehouse warehouse = new Warehouse();
        int option = JOptionPane.showConfirmDialog(warehouse, "Anda yakin akan menghapus product ini?");

        if (option == JOptionPane.OK_OPTION) {
            int row = table.getSelectedRow();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            productModel.setId(Integer.parseInt(table.getValueAt(row, 1).toString()));

            if (productModel.deleteProduct()) {
                JOptionPane.showMessageDialog(null, "Product berhasil dihapus !");
//                anggotaDialog.dispose();   
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Menghapus Product !");
            }

        }

    }

    public void serchWarehouse() {
        try {

            ProductModel productModel = new ProductModel();

        } catch (Exception e) {
            System.out.println();
        }
    }

    public boolean populateTable(JTable jTable1, String search) {
        ProductModel product = new ProductModel();
        ArrayList<ProductModel> productList = product.showProduct(search);
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();

        int i = 1;

        defaultTableModel.setRowCount(0);

        for (ProductModel products : productList) {
            defaultTableModel.addRow(
                    new Object[]{
                        i++,
                        products.getId(),
                        products.getName(),
                        products.getStock(),
                        products.getPrice()
                    }
            );
        }

        jTable1.setModel(defaultTableModel);
        return defaultTableModel.getRowCount() != 0;
    }
}
