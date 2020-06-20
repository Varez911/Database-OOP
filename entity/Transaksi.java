/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud_OOP.entity;

import java.util.Date;

/**
 *
 * @author userPC
 */
public class Transaksi {
    private int idtransaksi, idpelanggan, idkamar, totalharga;
    private String Checkin, Checkout, tnglTransaksi;
    public Transaksi() {
    }

    public Transaksi(int idtransaksi, int idpelanggan, int idkamar, 
            int totalharga, String Checkin, String Checkout, String tnglTransaksi) {
        this.idtransaksi = idtransaksi;
        this.idpelanggan = idpelanggan;
        this.idkamar = idkamar;
        this.totalharga = totalharga;
        this.Checkin = Checkin;
        this.Checkout = Checkout;
        this.tnglTransaksi = tnglTransaksi;
    }
    
     
    public int getIdtransaksi() {
        return idtransaksi;
    }

    public void setIdtransaksi(int idtransaksi) {
        this.idtransaksi = idtransaksi;
    }

    public int getIdpelanggan() {
        return idpelanggan;
    }

    public void setIdpelanggan(int idpelanggan) {
        this.idpelanggan = idpelanggan;
    }

    public int getIdkamar() {
        return idkamar;
    }

    public void setIdkamar(int idkamar) {
        this.idkamar = idkamar;
    }

    public int getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(int totalharga) {
        this.totalharga = totalharga;
    }

    public String getCheckin() {
        return Checkin;
    }

    public void setCheckin(String Checkin) {
        this.Checkin = Checkin;
    }

    public String getCheckout() {
        return Checkout;
    }

    public void setCheckout(String Checkout) {
        this.Checkout = Checkout;
    }

    public String getTnglTransaksi() {
        return tnglTransaksi;
    }

    public void setTnglTransaksi(String tnglTransaksi) {
        this.tnglTransaksi = tnglTransaksi;
    }


    @Override
    public String toString() {
        return "Transaksi{" + "idtransaksi=" + idtransaksi + ", idpelanggan=" 
                + idpelanggan + ", idkamar=" + idkamar + ", totalharga=" + totalharga 
                + ", Checkin=" + Checkin + ", Checkout=" + Checkout + ", tnglTransaksi=" 
                + tnglTransaksi + '}';
    }
    
    
}
