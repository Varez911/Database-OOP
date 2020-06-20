/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud_OOP.exec;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Crud_OOP.db.ConnectionManager;
import Crud_OOP.entity.Transaksi;
/**
 *
 * @author userPC
 */
public class ExecuteTransaksi {
    public List<Transaksi> getTransaksi(){
        List<Transaksi> listTransaksi = new ArrayList<>();
        String query = "select * from transaksi";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Transaksi transaksi = new Transaksi();
                transaksi.setIdtransaksi(rs.getInt("idtransaksi"));
                transaksi.setIdkamar(rs.getInt("idkamar"));
                transaksi.setIdpelanggan(rs.getInt("idpelanggan"));
                transaksi.setTotalharga(rs.getInt("totalharga"));
                transaksi.setCheckin(rs.getString("tanggalCheckin"));
                transaksi.setCheckout(rs.getString("tanggalCheckout"));
                transaksi.setTnglTransaksi(rs.getString("tanggalpemesanan"));
                listTransaksi.add(transaksi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return listTransaksi;
    }    
    
    public int insertTransaksi(Transaksi _transaksi){
        int hasil = 0;
        String query = "Insert into transaksi(idtransaksi, idkamar, idpelanggan, "
                + "totalharga, tanggalpemesanan, tanggalCheckin, tanggalCheckout) "
                + "value('" + _transaksi.getIdtransaksi()+ "','" + _transaksi.getIdkamar() 
                + "','" + _transaksi.getIdpelanggan() + "','" + _transaksi.getTotalharga()
                + "','" + _transaksi.getTnglTransaksi() + "','" + _transaksi.getCheckin()
                + "','" + _transaksi.getCheckout() +"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    public int updateTransaksi(Transaksi _transaksi){
        int hasil = 0;
        String query = "update transaksi set idkamar='" + _transaksi.getIdkamar()+ "',idpelanggan='" 
                + _transaksi.getIdpelanggan()+"',totalharga='" + _transaksi.getTotalharga()
                + "', tanggalpemesanan='" + _transaksi.getTnglTransaksi() + "',tanggalCheckin='" 
                + _transaksi.getCheckin() + "',tanggalCheckout='" + _transaksi.getCheckout()
                +"' where idjeniskamar='"+ _transaksi.getIdtransaksi()+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    public int deleteTransaksi(String delIdP){
        int hasil = 0;
        String query = "delete from transaksi where idtransaksi='"+ delIdP+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
}
