package pert3;
import java.util.Scanner;

public class ProgramDiskon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input total belanja
        System.out.print("Masukkan total belanja: Rp ");
        double totalBelanja = input.nextDouble();

        double diskon = 0;   // variabel untuk menyimpan diskon
        double totalBayar;   // variabel untuk total bayar setelah diskon

        // Aturan diskon dengan if-else
        if (totalBelanja >= 50000) {
            diskon = 0.20; // 20% diskon
        } else if (totalBelanja >= 25000) {
            diskon = 0.10; // 10% diskon
        } else if (totalBelanja >= 100000) {
            diskon = 0.05; // 5% diskon
        } else {
            diskon = 0;    // tidak ada diskon
        }

        // Hitung total yang harus dibayar
        totalBayar = totalBelanja - (totalBelanja * diskon);

        // Tampilkan hasil
        System.out.println("\n=== STRUK PEMBELIAN ===");
        System.out.println("Total Belanja : Rp " + totalBelanja);
        System.out.println("Diskon        : " + (diskon * 100) + "%");
        System.out.println("Total Bayar   : Rp " + totalBayar);

        input.close();
    }
}

