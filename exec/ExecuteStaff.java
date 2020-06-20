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
import Crud_OOP.entity.Staff;

/**
 *
 * @author userPC
 */
public class ExecuteStaff {
    public List<Staff> getStaff(){
        List<Staff> listStaff = new ArrayList<>();
        String query = "select * from staff";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                Staff staff = new Staff();
                staff.setIdstaff(rs.getInt("idstaff"));
                staff.setNamastaff(rs.getString("namastaff"));
                listStaff.add(staff);
            }
        } catch (SQLException e) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, e);
        }
        conMan.logOff();
        return listStaff;
    }
    
    public int insertStaff(Staff _staff){
        int hasil = 0;
        String query = "Insert into staff(idstaff, namastaff) value('"
                + _staff.getIdstaff()+ "','" + _staff.getNamastaff()+"')";
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
    
    public int updateJenis(Staff _staff){
        int hasil = 0;
        String query = "update staff set namastaff='" + _staff.getNamastaff() 
                + "' where idstaff='"+ _staff.getIdstaff()+"'";
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
    
    public int deleteStaff(String delIdP){
        int hasil = 0;
        String query = "delete from staff where idstaff='"+ delIdP+"'";
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
