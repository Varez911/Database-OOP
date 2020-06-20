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
import Crud_OOP.exec.ExecuteStaff;

import java.util.Scanner;
import Crud_OOP.entity.Pelanggan;
import Crud_OOP.entity.Staff;
import Crud_OOP.entity.Transaksi;
import java.text.ParseException;
import java.util.List;
/**
 *
 * @author userPC
 */
public class MainExecuteProjek {

    private static boolean KELUAR = false;
    private static ExecutePelanggan execPelangggan;
    private static ExecuteTransaksi execTransaksi;
    private static ExecuteKamar execKamar;
    private static ExecuteJenisKamar execJenis;
    private static ExecuteStaff execStaff;
    
    public static void main(String[] args) {
        String a,b,c,d,e,f,g,h;
        int a1,b2,c3,d4,e5,f6,g7,h8,i9;
        while(!KELUAR){
            System.out.println("**********************************************");
            System.out.println("*1. Tampil data Pelanggan                    *");
            System.out.println("*2. Tampil data Kamar                        *");
            System.out.println("*3. Tampil data Jenis Kamar                  *");
            System.out.println("*4. Tampil data Staff                        *");
            System.out.println("*5. Tampil data Transaksi                    *");
            System.out.println("*6. Ubah data Pelanggan                      *");
            System.out.println("*7. Ubah data Kamar                          *");
            System.out.println("*8. Ubah data Jenis Kamar                    *");
            System.out.println("*9. Ubah data Staff                          *");
            System.out.println("*10. Ubah data Transaksi                      *");            
            System.out.println("*11. Hapus data Pelanggan                     *");
            System.out.println("*12. Hapus data Kamar                         *");
            System.out.println("*13. Hapus data Jenis Kamar                   *");
            System.out.println("*14. Hapus data Staff                         *");
            System.out.println("*15. Hapus data Transaksi                     *");
            System.out.println("*99. Keluar Aplikasi                         *");
            System.out.println("**********************************************");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan pilihan Anda : ");
            int pilih = scanner.nextInt();
            switch(pilih){
                case 1 :{
                            System.out.println("Anda memilih Tampil Data");
                            List<Pelanggan> listPelanggan= execPelangggan.getPlngn();
                            System.out.println("===========================================");
                            for(Pelanggan pelanggan : listPelanggan){
                                System.out.println(pelanggan.toString());
                            }
                            System.out.println("===========================================");
                            break;
                        }
                case 2 : {
                            System.out.println("Anda memilih Tampil Data");
                            List<Kamar> listObject= execKamar.getKamar();
                            System.out.println("===========================================");
                            for(Kamar pelanggan : listObject){
                                System.out.println(pelanggan.toString());
                            }
                            System.out.println("===========================================");
                            break;
                }
                case 3 : {
                            System.out.println("Anda memilih Tampil Data");
                            List<JenisKamar> listJenis= execJenis.getJenisKamar();
                            System.out.println("===========================================");
                            for(JenisKamar jenis : listJenis){
                                System.out.println(jenis.toString());
                            }
                            System.out.println("===========================================");
                            break;
                }
                case 4 : {
                    System.out.println("Anda memilih Tampil Data");
                            List<Staff> listPelanggan= execStaff.getStaff();
                            System.out.println("===========================================");
                            for(Staff staff : listPelanggan){
                                System.out.println(staff.toString());
                            }
                            System.out.println("===========================================");
                            break;
                }
                case 5 : {
                    System.out.println("Anda memilih Tampil Data");
                            List<Transaksi> listPelanggan= execTransaksi.getTransaksi();
                            System.out.println("===========================================");
                            for(Transaksi transaksi : listPelanggan){
                                System.out.println(transaksi.toString());
                            }
                            System.out.println("===========================================");
                            break;
                }
                
                case 6 :{
                            System.out.println("Anda memilih Ubah Data Pelanggan");
                            scanner = new Scanner(System.in);
                            System.out.println("Masukkan id pelanggan: ");
                            a1 = scanner.nextInt();
                            System.out.println("Masukkan nama pelanggan: ");
                            a = scanner.nextLine();
                            System.out.println("Masukkan alamat pelanggan: ");
                            b = scanner.nextLine();
                            System.out.println("Masukkan no KTP: ");
                            b2 = scanner.nextInt();
                            Pelanggan newPelanggan = new Pelanggan(a, b, a1, b2);
                            int hasil = execPelangggan.updatePelanggan(newPelanggan);
                            System.out.println("Data tersimpan = " + hasil);                            
                            break;
                        }
                case 7 :{
                            System.out.println("Anda memilih Ubah Data Kamar");
                            scanner = new Scanner(System.in);
                            System.out.println("Masukkan id kamar: ");
                            a1 = scanner.nextInt();
                            System.out.println("Masukkan id tamu: ");
                            b2 = scanner.nextInt();
                            System.out.println("Masukkan id jenis kamar: ");
                            c3 = scanner.nextInt();
                            System.out.println("Masukkan harga kamar: ");
                            d4 = scanner.nextInt();
                            System.out.println("Masukan no kamar: ");
                            a = scanner.nextLine();
                            System.out.println("Masukan status kamar: ");
                            b = scanner.nextLine();
                            Kamar kamar = new Kamar(b2, a1, c3, a, b);
                            int hasil = execKamar.updateKamar(kamar);
                            System.out.println("Data tersimpan = " + hasil);                            
                            break;
                        }
                case 8 :{
                            System.out.println("Anda memilih Ubah Data Jenis Kamar");
                            scanner = new Scanner(System.in);
                            System.out.println("Masukkan id Jenis Kamar: ");
                            a1 = scanner.nextInt();
                            System.out.println("Masukkan harga Kamar: ");
                            b2 = scanner.nextInt();
                            System.out.println("Masukkan Isi kamar: ");
                            c3 = scanner.nextInt();
                            System.out.println("Masukkan Kelas kamar: ");
                            a = scanner.nextLine();
                            JenisKamar jenis = new JenisKamar(a1, b2, c3, a);
                            int hasil = execJenis.updateJenis(jenis);
                            System.out.println("Data tersimpan = " + hasil);                            
                            break;
                        }
                case 9 :{
                            System.out.println("Anda memilih Ubah Data Staff");
                            scanner = new Scanner(System.in);
                            System.out.println("Masukkan id Staff: ");
                            a1 = scanner.nextInt();
                            System.out.println("Masukkan nama Staff: ");
                            a = scanner.nextLine();
                            Staff staff = new Staff(a1, a);
                            int hasil = execStaff.updateJenis(staff);
                            System.out.println("Data tersimpan = " + hasil);                            
                            break;
                        }
                case 10 :{
                            System.out.println("Anda memilih Ubah Data Transaksi");
                            scanner = new Scanner(System.in);
                            System.out.println("Masukkan id Transaksi: ");
                            a1 = scanner.nextInt();
                            System.out.println("Masukkan id pelanggan: ");
                            b2 = scanner.nextInt();
                            System.out.println("Masukkan id Kamar: ");
                            c3 = scanner.nextInt();
                            System.out.println("Masukkan id Total Harga: ");
                            d4 = scanner.nextInt();
                            System.out.println("Masukkan tanggal Transaksi: ");
                            a = scanner.nextLine();
                            System.out.println("Masukkan tanggal Checkin: ");
                            b = scanner.nextLine();
                            System.out.println("Masukkan tanggal Checkout: ");
                            c = scanner.nextLine();
                            Transaksi trans = new Transaksi(a1, b2, c3, d4, b, c, a);
                            int hasil = execTransaksi.updateTransaksi(trans);
                            System.out.println("Data tersimpan = " + hasil);                            
                            break;
                        }
                case 11 :{
                            System.out.println("Anda memilih hapus data Pelanggan");
                            scanner = new Scanner(System.in);
                            System.out.print("Masukkan id yang akan dihapus: ");
                            a = scanner.nextLine();
                            int hasil = execPelangggan.deletePelanggan(a);
                            System.out.println("Data terhapus = " + hasil);
                            break;
                        }
                case 12 :{
                            System.out.println("Anda memilih hapus data Kamar");
                            scanner = new Scanner(System.in);
                            System.out.print("Masukkan id yang akan dihapus: ");
                            a = scanner.nextLine();
                            int hasil = execKamar.deleteKamar(a);
                            System.out.println("Data terhapus = " + hasil);
                            break;
                        }
                case 13 :{
                            System.out.println("Anda memilih hapus data Jenis Kamar");
                            scanner = new Scanner(System.in);
                            System.out.print("Masukkan id yang akan dihapus: ");
                            a = scanner.nextLine();
                            int hasil = execJenis.deleteJenis(a);
                            System.out.println("Data terhapus = " + hasil);
                            break;
                        }
                case 14 :{
                            System.out.println("Anda memilih hapus data Staff");
                            scanner = new Scanner(System.in);
                            System.out.print("Masukkan id yang akan dihapus: ");
                            a = scanner.nextLine();
                            int hasil = execStaff.deleteStaff(a);
                            System.out.println("Data terhapus = " + hasil);
                            break;
                        }
                case 15 :{
                            System.out.println("Anda memilih hapus data Transaksi");
                            scanner = new Scanner(System.in);
                            System.out.print("Masukkan id yang akan dihapus: ");
                            a = scanner.nextLine();
                            int hasil = execTransaksi.deleteTransaksi(a);
                            System.out.println("Data terhapus = " + hasil);
                            break;
                        }
                case 99 :{
                            System.out.println("Anda keluar Aplikasi!!!");
                            KELUAR = true;
                            break;
                        }
            }
        }


    }
    
}
