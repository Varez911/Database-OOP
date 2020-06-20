/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud_OOP.main;
import Crud_OOP.db.ConnectionManager;
import Crud_OOP.entity.JenisKamar;
import Crud_OOP.entity.Kamar;
import com.mysql.jdbc.Connection;

import Crud_OOP.exec.ExecutePelanggan;
import Crud_OOP.exec.ExecuteTransaksi;
import Crud_OOP.exec.ExecuteKamar;
import Crud_OOP.exec.ExecuteJenisKamar;

import Crud_OOP.entity.Pelanggan;
import Crud_OOP.entity.Transaksi;
import java.text.ParseException;


/**
 *
 * @author userPC
 */
public class MainTestDrive {

    /**
     * @param args the command line arguments
     */
    private static ExecutePelanggan execPelangggan;
    private static ExecuteTransaksi execTransaksi;
    private static ExecuteKamar execKamar;
    private static ExecuteJenisKamar execJenis;
    
    public static void main(String[] args) throws ParseException {
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();   
        System.out.println("Koneksi Anda : " + conn);
        System.out.println("");
        execPelangggan = new ExecutePelanggan();
        
        System.out.println("Anda memilih Tampil Data Pelanggan");
        List<Pelanggan> listPelanggan = execPelangggan.getPlngn();
        System.out.println("===========================================");
        for(Pelanggan pelanggan : listPelanggan){
            System.out.println(pelanggan.toString());
        }
        System.out.println("===========================================");
        
        System.out.println("Anda memilih Tampil Data Transaksi");
        execTransaksi = new ExecuteTransaksi();
        List<Transaksi> listTransaksi = execTransaksi.getTransaksi();
        System.out.println("===========================================");
        for(Transaksi transaksi : listTransaksi){
            System.out.println(transaksi.toString());
        }
        System.out.println("===========================================");
        
        System.out.println("Anda memilih Tampil Data Kamar");
        execKamar = new ExecuteKamar();
        List<Kamar> listKamar = execKamar.getKamar();
        System.out.println("===========================================");
        for(Kamar kamar : listKamar){
            System.out.println(kamar.toString());
        }
        System.out.println("===========================================");
        
        System.out.println("Anda memilih Tampil Data JenisKamar");
        execJenis = new ExecuteJenisKamar();
        List<JenisKamar> listJenis = execJenis.getJenisKamar();
        System.out.println("===========================================");
        for(JenisKamar jenis : listJenis){
            System.out.println(jenis.toString());
        }
        System.out.println("===========================================");
//        Pelanggan newPelanggan = new Pelanggan("Varez", "Sumedang", 12, 69420);
        JenisKamar _jenis = new JenisKamar(2, 60000, 3, "Exklusif");
        Kamar _kamar = new Kamar(1, 3, 2, "A103", "Tersedia");
//        Date myDate = new Date(622790105000L);
//System.out.println(myDate);
//System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(myDate));
//System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(myDate));
//System.out.println(myDate);
        String date1 = "2019-07-07";
        Transaksi transaksi = new Transaksi(2, 1, 2, 100000, date1, date1, date1);
        int hasil = execTransaksi.insertTransaksi(transaksi);
        System.out.println("Data tersimpan = " + hasil);   
    }
    
}