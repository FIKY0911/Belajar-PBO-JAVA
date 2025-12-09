package pert3;
import java.util.Scanner;

public class NamaHari {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input kode hari
        System.out.print("Masukkan kode hari (0-6): ");
        int kode = input.nextInt();

        // Menentukan nama hari dengan if bertingkat
        if (kode == 0) {
            System.out.println("Hari Minggu");
        } else if (kode == 1) {
            System.out.println("Hari Senin");
        } else if (kode == 2) {
            System.out.println("Hari Selasa");
        } else if (kode == 3) {
            System.out.println("Hari Rabu");
        } else if (kode == 4) {
            System.out.println("Hari Kamis");
        } else if (kode == 5) {
            System.out.println("Hari Jumat");
        } else if (kode == 6) {
            System.out.println("Hari Sabtu");
        } else {
            System.out.println("⚠️ Kode tidak valid! Masukkan angka 0-6.");
        }

        input.close();
    }
}

