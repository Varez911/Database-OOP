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
import Crud_OOP.entity.JenisKamar;
/**
 *
 * @author userPC
 */
public class ExecuteJenisKamar {
    public List<JenisKamar> getJenisKamar(){
        List<JenisKamar> listJenis = new ArrayList<>();
        String queary = "Select * from jeniskamar";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(queary);
            while(rs.next()){
                JenisKamar jenis = new JenisKamar();
                jenis.setHargakamar(rs.getInt("hargakamar"));
                jenis.setIdjeniskamar(rs.getInt("idjeniskamar"));
                jenis.setIsikamar(rs.getInt("isikamar"));
                jenis.setKelaskamar(rs.getString("kelaskamar"));
                listJenis.add(jenis);
            }
        } catch (SQLException e) {
            Logger.getLogger(ExecuteKamar.class.getName()).log(Level.SEVERE, null, e);
        }
        conMan.logOff();
        return listJenis;
    }
    
    public int insertJenis(JenisKamar _jenis){
        int hasil = 0;
        String query = "Insert into jeniskamar(idjeniskamar, kelaskamar, hargakamar, "
                + "isikamar) value('" + _jenis.getIdjeniskamar() + "','" + _jenis.getKelaskamar() 
                + "','" + _jenis.getHargakamar() + "','" + _jenis.getIsikamar()
                +"')";
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
    
    public int updateJenis(JenisKamar _jenis){
        int hasil = 0;
        String query = "update jeniskamar set kelaskamar='" + _jenis.getKelaskamar() 
                + "',hargakamar='" + _jenis.getHargakamar() +"',isikamar='" + _jenis.getIsikamar() 
                + "' where idjeniskamar='"+ _jenis.getIdjeniskamar()+"'";
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
    
    public int deleteJenis(String delIdP){
        int hasil = 0;
        String query = "delete from jeniskamar where idjeniskamar='"+ delIdP+"'";
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
