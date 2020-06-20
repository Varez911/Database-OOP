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

import Crud_OOP.entity.Pelanggan;
import Crud_OOP.db.ConnectionManager;
/**
 *
 * @author userPC
 */
public class ExecutePelanggan {
    public List<Pelanggan> getPlngn(){
        List<Pelanggan> listPlngn = new ArrayList<>();
        String query = "select * from pelanggan";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setIdpelanggan(rs.getInt("idpelanggan"));
                pelanggan.setNamapelanggan(rs.getString("namapelanggan"));
                pelanggan.setAlamatpelanggan(rs.getString("alamatpelanggan"));
                pelanggan.setNoktp(rs.getInt("noktp"));
                listPlngn.add(pelanggan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return listPlngn;
    }
    
    public int insertPelanggan(Pelanggan _pelanggan){
        int hasil = 0;
        String query = "Insert into pelanggan(idpelanggan, namapelanggan, noktp, alamatpelanggan)"
                + "value('"+_pelanggan.getIdpelanggan()+"','"+_pelanggan.getNamapelanggan()+"','"
                +_pelanggan.getNoktp()+"','"+_pelanggan.getAlamatpelanggan()+"')";
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
    
    public int deletePelanggan(String delIdP){
        int hasil = 0;
        String query = "delete from pelanggan where idpelanggan='"+ delIdP+"'";
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
    
    public int updatePelanggan(Pelanggan _pelanggan){
        int hasil = 0;
        String query = "update pelanggan set namapelanggan='" + _pelanggan.getNamapelanggan() 
                + "',noktp='" + _pelanggan.getNoktp() +"',alamatpelanggan='" 
                + _pelanggan.getAlamatpelanggan()+"' where idpelanggan='"+ _pelanggan.getIdpelanggan()+"'";
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
