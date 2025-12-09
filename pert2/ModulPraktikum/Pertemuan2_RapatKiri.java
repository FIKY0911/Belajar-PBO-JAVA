package pert2.ModulPraktikum;
import java.util.Scanner;

public class Pertemuan2_RapatKiri {
    public static void main ( String[] args){
        String namaBarang = "Buku pemrograman Berorientasi Objek"; // Untuk memunculkan kalimat sebelum hasil

        int harga =  102000; //menampung ke variable
        //Untuk mengeluarkan input
        System.out.println("|" + namaBarang + "|" + harga + "|");
        System.out.printf(" %30s | %10d | \n", namaBarang,harga);
        System.out.printf(" %-30s | %10d | \n", namaBarang, harga);
    }
}


