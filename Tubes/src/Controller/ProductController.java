/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataCashier;
import Model.ProductModel;
import View.CashierView;
import View.Warehouse;
import View.WarehouseInsert;
import View.WarehouseUpdate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sulistiana
 */
public class ProductController {

    private static ProductModel productModel = new ProductModel();

    ArrayList<DataCashier> listDataCashier;

    public ProductController() {
        listDataCashier = new ArrayList();
    }

    public void insertData(int kodeBarang, int stok, int jumlah,
            double harga, String namaBarang, double total) {
        DataCashier dataCashier = new DataCashier(kodeBarang, stok, jumlah, harga, namaBarang, total);

        listDataCashier.add(dataCashier);
    }

    public ArrayList<DataCashier> getAll() {
        return listDataCashier;
    }

    public void deleteData(int index) { //method untuk menghapus data di ArrayList berdasarkan index Arraynya
        listDataCashier.remove(index);
    }

    public void deleteDataAll(JTable table2) {
        
        listDataCashier.removeAll(listDataCashier);
        getTable2(table2);
        
    }

    public static void tambahProduct(WarehouseInsert warehouseInsert) {
        Warehouse warehose = new Warehouse();
        String name = warehouseInsert.getInputNama().getText();
        String stock = warehouseInsert.getInputJumlah().getText();
        String harga = warehouseInsert.getInputHarga().getText();
        if (!name.isEmpty()) {
            if (!stock.isEmpty()) {
                if (stock.matches("^\\d+$")) {
                    if (Integer.parseInt(stock) != 0) {
                        if (!harga.isEmpty()) {
                            if (harga.matches("^\\d+$")) {
                                if (Integer.parseInt(harga) != 0) {

                                    int stockParse = Integer.parseInt(warehouseInsert.getInputJumlah().getText());
                                    int priceParse = Integer.parseInt(warehouseInsert.getInputHarga().getText());

                                    productModel.setName(name);
                                    productModel.setStock(stockParse);
                                    productModel.setPrice(priceParse);

                                    if (productModel.insert()) {
                                        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");

                                        warehouseInsert.dispose();

                                        Warehouse wi = new Warehouse();
                                        wi.setVisible(true);

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Gagal menyimpan data !");

                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "Harga tidak boleh 0");
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "harga harus angka");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "harga tidak boleh kosong");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Stok tidak boleh 0");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Stock harus angka");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Stok tidak boleh kosong");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
        }

    }

    public void updateShow(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        WarehouseUpdate wu = new WarehouseUpdate();

        int row = table.getSelectedRow();
        wu.getIdLabel().setText(table.getValueAt(row, 1).toString());
        wu.getInputNama().setText(table.getValueAt(row, 2).toString());
        wu.getInputJumlah().setText(table.getValueAt(row, 3).toString());
        wu.getInputHarga().setText(table.getValueAt(row, 4).toString());

        wu.setVisible(true);
    }

//    data cashier
    public boolean selectedProduct(JTable table, JTable table2, JTextField qty) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        DefaultTableModel dtm2 = (DefaultTableModel) table2.getModel();

        CashierView cashierView = new CashierView();

        int row = table.getSelectedRow();
        
        String[] product = new String[5];

        int kodeBarang = Integer.parseInt(table.getValueAt(row, 1).toString());
        String namaBarang = table.getValueAt(row, 2).toString();
        int stok = Integer.parseInt(table.getValueAt(row, 3).toString());
        double harga = Double.parseDouble(table.getValueAt(row, 4).toString());
        int jumlah = Integer.parseInt(qty.getText());

        double total = harga * jumlah;

        insertData(kodeBarang, stok, jumlah, harga, namaBarang, total);


        int i = 1;

        dtm2.setRowCount(0);

        for (DataCashier dataCashier : getAll()) {
            dtm2.addRow(
                    new Object[]{
                        i++,
                        dataCashier.getId(),
                        dataCashier.getNamaBarang(),
                        dataCashier.getHarga(),
                        dataCashier.getJumlah(),
                        dataCashier.getTotal()
                    }
            );
        }

        table2.setModel(dtm2);
        return dtm2.getRowCount() != 0;

    }
    
    public void selectedDataCashier(JTable table2) {
        int row = table2.getSelectedRow();
        int index = Integer.parseInt(table2.getValueAt(row, 0).toString());
        deleteData(index-1);  
        getTable2(table2);
    }
    
    public boolean getTable2(JTable table2){
        DefaultTableModel dtm2 = (DefaultTableModel) table2.getModel();
        dtm2.setRowCount(0);
        
        int i=1;
        for (DataCashier dataCashier : getAll()) {
            dtm2.addRow(
                    new Object[]{
                        i++,
                        dataCashier.getId(),
                        dataCashier.getNamaBarang(),
                        dataCashier.getHarga(),
                        dataCashier.getJumlah(),
                        dataCashier.getTotal()
                    }
            );
        }
        table2.setModel(dtm2);
        return dtm2.getRowCount() != 0;   
    }
    
    public void dataProductInList(){
        
        int i=0;
        
        for (DataCashier dataCashier : getAll()) {
            System.out.println("Nama Barang ["+i+"]"+dataCashier.getNamaBarang());
            i++;
            System.out.println("");
        }
        
    }

    public void updateChange(WarehouseUpdate warehouseUpdate) {
        productModel = new ProductModel();

        String name = warehouseUpdate.getInputNama().getText();
        String stock = warehouseUpdate.getInputJumlah().getText();
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
                            productModel.updateProduct(productModel);
                            
                            if (productModel.updateProduct(productModel)) {
                                        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");

                                        warehouseUpdate.dispose();

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
