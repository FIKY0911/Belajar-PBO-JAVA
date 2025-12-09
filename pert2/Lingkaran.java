package pert2;
import java.util.Scanner;

public class Lingkaran {
    public static void main(String[] args) {
        // Deklarasi variabel
        double jariJari;
        double luas;

        // Membuat objek Scanner untuk input pengguna
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan jari-jari lingkaran: ");
        jariJari = input.nextDouble();

        // Ekspresi yang menggunakan metode matematika Math.pow() untuk menghitung pangkat
        // Luas = pi * r^2
        luas = Math.PI * Math.pow(jariJari, 2);

        // Menampilkan hasil
        System.out.println("Luas lingkaran dengan jari-jari " + jariJari + " adalah " + luas);
        
        // Menutup scanner
        input.close();
    }
}
