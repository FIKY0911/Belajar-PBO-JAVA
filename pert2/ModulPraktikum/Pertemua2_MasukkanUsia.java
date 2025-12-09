package pert2.ModulPraktikum;
import java.util.Scanner;

public class Pertemua2_MasukkanUsia {
    public static void main(String[] args){
        // tipe data dan variable
        int usia;

        //Scanner untuk membaca data masukkan
        Scanner kbd = new Scanner (System.in);

        //cetak perintah untuk data masukkan yang diminta
        System.out.print("Masukkan usia anda :");
        usia = kbd.nextInt(); //nextInt - membaca data bilangan bulat

        //proses dan mencetak hasil
        System.out.println("Terima kasih." + " Usia anda tahun depan : " + (usia + 1));
    }
}
