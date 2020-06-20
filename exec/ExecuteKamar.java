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
import Crud_OOP.entity.Kamar;
/**
 *
 * @author userPC
 */
public class ExecuteKamar {
    public List<Kamar> getKamar(){
        List<Kamar> listKamar = new ArrayList<>();
        String queary = "Select * from kamar inner join jeniskamar on jeniskamar.idjeniskamar = kamar.idjeniskamar";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(queary);
            while(rs.next()){
                Kamar kamar = new Kamar();
                kamar.setHarga(rs.getInt("hargakamar"));
                kamar.setIdjeniskamar(rs.getInt("idjeniskamar"));
                kamar.setIdkamar(rs.getInt("idkamar"));
                kamar.setIdtamu(rs.getInt("idtamu"));
                kamar.setIsi(rs.getInt("isikamar"));
                kamar.setKelas(rs.getString("kelaskamar"));
                kamar.setNokamar(rs.getString("nokamar"));
                kamar.setStatus(rs.getString("status"));
                listKamar.add(kamar);
            }
        } catch (SQLException e) {
            Logger.getLogger(ExecuteKamar.class.getName()).log(Level.SEVERE, null, e);
        }
        conMan.logOff();
        return listKamar;
    }
    
    public int insertkamar(Kamar _kamar){
        int hasil = 0;
        String query = "Insert into kamar(idkamar, nokamar, idtamu, idjeniskamar, status) value('"
                + _kamar.getIdkamar() + "','" + _kamar.getNokamar() + "','" + _kamar.getIdtamu() 
                + "','" + _kamar.getIdjeniskamar() + "','" + _kamar.getStatus() +"')";
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
    
    public int updateKamar(Kamar _kamar){
        int hasil = 0;
        String query = "update kamar set idtamu='" + _kamar.getIdtamu() + "',idjeniskamar='" 
                + _kamar.getIdjeniskamar() +"',nokamar='" + _kamar.getNokamar() + "',status='" 
                + _kamar.getStatus()+ "' where idkamar='"+ _kamar.getIdkamar()+"'";
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
    
    
    
    public int deleteKamar(String delIdP){
        int hasil = 0;
        String query = "delete from kamar where idkamar='"+ delIdP+"'";
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
