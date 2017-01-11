/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author sulistiana
 */
public class DataCashier {
    
    int id,stok, jumlah;
    double harga, total;
    String namaBarang;

    public DataCashier(int id, int stok, int jumlah, double harga, String namaBarang, double total) {
        this.id = id;
        this.stok = stok;
        this.jumlah = jumlah;
        this.harga = harga;
        this.namaBarang = namaBarang;
        this.total = total;
    }

    public DataCashier() {
    }

     public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    
    
}
