package pert2;
import java.util.Scanner;

public class PencatatKeuangan {

    // Variabel untuk menyimpan saldo total
    private static double saldo = 0.0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        System.out.println("--- Aplikasi Pencatat Keuangan Interaktif ---");
        
        // Meminta pendapatan awal dari pengguna
        System.out.print("Masukkan saldo awal Anda: ");
        saldo = input.nextDouble();

        // Loop untuk menampilkan menu dan memproses pilihan pengguna
        do {
            tampilkanMenu();
            pilihan = input.nextInt();
            input.nextLine(); // Untuk membersihkan buffer

            if (pilihan == 1) {
                System.out.print("Masukkan jumlah pendapatan: ");
                double jumlah = input.nextDouble();
                tambahPendapatan(jumlah);
            } else if (pilihan == 2) {
                System.out.print("Masukkan jumlah pengeluaran: ");
                double jumlah = input.nextDouble();
                input.nextLine(); // membersihkan buffer
                System.out.print("Masukkan kategori pengeluaran: ");
                String kategori = input.nextLine();
                catatPengeluaran(jumlah, kategori);
            } else if (pilihan == 3) {
                tampilkanSaldo();
            } else if (pilihan == 0) {
                System.out.println("Terima kasih telah menggunakan aplikasi ini.");
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        input.close();
    }

    // Metode untuk menampilkan menu pilihan
    public static void tampilkanMenu() {
        System.out.println("\n----------------------------------------");
        System.out.println("Pilih operasi:");
        System.out.println("1. Tambah Pendapatan");
        System.out.println("2. Catat Pengeluaran");
        System.out.println("3. Tampilkan Saldo");
        System.out.println("0. Keluar");
        System.out.print("Pilihan Anda: ");
    }

    // Metode untuk menambah pendapatan ke saldo
    public static void tambahPendapatan(double jumlah) {
        saldo += jumlah;
        System.out.println("Pendapatan sebesar " + jumlah + " telah ditambahkan.");
    }

    // Metode untuk mencatat pengeluaran dan memperbarui saldo
    public static void catatPengeluaran(double jumlah, String kategori) {
        if (jumlah > saldo) {
            System.out.println("Saldo tidak mencukupi untuk pengeluaran ini.");
        } else {
            saldo -= jumlah;
            System.out.println("Pengeluaran sebesar " + jumlah + " untuk kategori '" + kategori + "' telah dicatat.");
        }
    }

    // Metode untuk menampilkan saldo saat ini
    public static void tampilkanSaldo() {
        System.out.println("\nSisa saldo Anda saat ini: " + saldo);
    }
}
