/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataCashier;
import java.util.ArrayList;

/**
 *
 * @author sulistiana
 */
public class InputDataCashire {
    
    ArrayList<DataCashier> listDataCashier;

    public InputDataCashire() {
        listDataCashier = new ArrayList();
    }

    public void insertData(int kodeBarang, int stok, int jumlah
    ,double harga, String namaBarang, double total){
        DataCashier dataCashier = new DataCashier(kodeBarang, stok,jumlah, harga, namaBarang, total);
       
        listDataCashier.add(dataCashier);
    }
    
    public ArrayList<DataCashier> getAll(){
        return listDataCashier;
    }
    
}
