/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ProductController;
import View.Warehouse;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Igun Wiguna
 */
public class Warehouse extends javax.swing.JFrame {

    private final ProductController productController = new ProductController();
//    private final WarehouseInsert warehouseInsert = new WarehouseInsert(this, true);
    /**
     * Creates new form Warehouse
     */
    public Warehouse() {
        initComponents();
        productController.populateTable(warehouseTable);   
    }
    
    public JTable getProductTable(){
       
        return warehouseTable;
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        warehouseTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        changeBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JudulText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        warehouseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Teh Pucuk", "3", "50000"},
                {"2", "Teh Mecin", "4", null}
            },
            new String [] {
                "No", "Nama Barang", "Jumlah Barang", "Harga Barang"
            }
        ));
        jScrollPane1.setViewportView(warehouseTable);

        addBtn.setText("Tambah");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Hapus");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        changeBtn.setText("Ubah");
        changeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Pencarian");

        JudulText.setFont(new java.awt.Font("Tekton Pro", 1, 36)); // NOI18N
        JudulText.setText("Dashboard Gudang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JudulText, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(changeBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteBtn)))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(JudulText)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(deleteBtn)
                    .addComponent(changeBtn))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void changeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBtnActionPerformed
        // TODO add your handling code here:
        WarehouseUpdate warehouseUpdate= new WarehouseUpdate();
        
        if (warehouseTable.getSelectedRowCount()== 0) {
            JOptionPane.showMessageDialog(this, "Pilih salah satu baris tabel");     
        } else {
            productController.updateShow(warehouseTable);
            Warehouse wi = new Warehouse();
            wi.setVisible(true); 
//            productController.populateTable(warehouseTable);  
        }
        
        
    }//GEN-LAST:event_changeBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        WarehouseInsert wi = new WarehouseInsert();
        wi.setVisible(true);  
        this.dispose();
 
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        
         WarehouseUpdate warehouseUpdate= new WarehouseUpdate();
        
        if (warehouseTable.getSelectedRowCount()== 0) {
            JOptionPane.showMessageDialog(this, "Pilih salah satu baris tabel");     
        } else {
            productController.hapusProduct(warehouseTable);
            productController.populateTable(warehouseTable);  
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Warehouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Warehouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Warehouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Warehouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Warehouse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JudulText;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton changeBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    private javax.swing.JTable warehouseTable;
    // End of variables declaration//GEN-END:variables

    private WarehouseInsert WarehouseInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}