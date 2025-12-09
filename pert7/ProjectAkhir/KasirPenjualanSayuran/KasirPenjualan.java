package pert7.ProjectAkhir.KasirPenjualanSayuran;
// 🔹 Menunjukkan bahwa file ini berada di dalam package (folder) pert5/ProjectAkhir
// 🔸 Struktur folder harus sesuai dengan nama package ini agar tidak error.

import java.util.ArrayList;
import java.util.Scanner;
// 🔹 Mengimpor kelas bawaan Java:
//    - Scanner: untuk menerima input dari pengguna.
//    - ArrayList: untuk menyimpan data dalam bentuk list yang bisa bertambah dinamis.

public class KasirPenjualan {
    // 🔹 Mendeklarasikan class utama bernama KasirPenjualan.
    //    Nama class harus sama persis dengan nama file (KasirPenjualan.java)

    static Scanner input = new Scanner(System.in);
    // 🔹 Membuat objek Scanner untuk membaca input dari keyboard.

    static ArrayList<Sayur> daftarSayur = new ArrayList<>();
    // 🔹 Menyimpan daftar sayur dalam bentuk objek (tipe Sayur).

    static ArrayList<String> transaksiSayur = new ArrayList<>();
    static ArrayList<Integer> transaksiJumlah = new ArrayList<>();
    static ArrayList<Integer> transaksiTotal = new ArrayList<>();
    // 🔹 Tiga ArrayList di atas menyimpan data transaksi:
    //    - Nama sayur yang dibeli
    //    - Jumlah yang dibeli
    //    - Total harga per transaksi

    // 🔹 Bagian static block: dieksekusi hanya sekali ketika program dijalankan
    static {
        // Menambahkan beberapa data sayur awal ke dalam daftar
        daftarSayur.add(new Sayur("Wortel", 15000, 3));
        daftarSayur.add(new Sayur("Bayam", 5000, 5));
        daftarSayur.add(new Sayur("Tomat", 12000, 4));
        daftarSayur.add(new Sayur("Kubis", 8000, 2));
    }

    // 🔹 Menampilkan daftar sayuran yang tersedia
    static void tampilkanMenuSayur() {
        System.out.println("\n=== DAFTAR MENU SAYURAN ===");
        int no = 1;
        for (Sayur s : daftarSayur) { // perulangan untuk menampilkan semua sayur
            if (s.getStok() > 0) { // hanya menampilkan sayur yang masih ada stok
                String diskonStr = s.getDiskon() > 0 ? 
                    " (Diskon: " + (int)(s.getDiskon()*100) + "%)" : "";
                System.out.println(no + ". " + s.getNama() + " - Rp" + s.getHarga() +
                        " (Stok: " + s.getStok() + ")" + diskonStr);
            }
            no++;
        }
    }

    // 🔹 Menambahkan sayur baru melalui input pengguna
    static void tambahSayurBaru() {
        System.out.println("\n=== TAMBAH SAYUR BARU ===");
        System.out.print("Masukkan nama sayur: ");
        String nama = input.next(); // input nama sayur

        System.out.print("Masukkan harga sayur: ");
        int harga = input.nextInt(); // input harga

        System.out.print("Masukkan stok sayur: ");
        int stok = input.nextInt(); // input stok

        // Membuat objek baru dari class Sayur
        Sayur sayurBaru = new Sayur(nama, harga, stok);

        // Menanyakan apakah ingin menambahkan diskon
        System.out.print("Apakah ingin menambahkan diskon? (y/n): ");
        String jawab = input.next();
        if (jawab.equalsIgnoreCase("y")) {
            System.out.print("Masukkan besar diskon (misal 0.2 untuk 20%): ");
            double diskon = input.nextDouble();
            sayurBaru.setDiskon(diskon); // set diskon pada sayur baru
        }

        daftarSayur.add(sayurBaru); // menambah sayur ke daftar
        System.out.println("✅ Sayur baru berhasil ditambahkan!");
    }

    // 🔹 Memproses pembelian sayur
    static void prosesTransaksi(int index) {
        Sayur s = daftarSayur.get(index); // ambil data sayur berdasarkan indeks
        System.out.print("Masukkan jumlah ikat: ");
        int jumlah = input.nextInt();

        if (jumlah <= s.getStok()) { // jika stok cukup
            int total = s.getHarga() * jumlah; // hitung total harga
            s.kurangiStok(jumlah); // kurangi stok di objek sayur

            // Simpan data transaksi ke dalam list
            transaksiSayur.add(s.getNama());
            transaksiJumlah.add(jumlah);
            transaksiTotal.add(total);

            // Cetak struk pembelian
            System.out.println("\n===== STRUK PEMBELIAN =====");
            System.out.println("Sayur   : " + s.getNama());
            System.out.println("Jumlah  : " + jumlah + " ikat");
            System.out.println("Harga   : Rp" + s.getHarga());
            if (s.getDiskon() > 0)
                System.out.println("Diskon  : " + (int)(s.getDiskon() * 100) + "%");
            System.out.println("Total   : Rp" + total);
            System.out.println("===========================");
        } else {
            // Jika stok tidak cukup
            System.out.println("⚠️ Stok tidak cukup! Sisa stok: " + s.getStok());
        }
    }

    // 🔹 Menampilkan semua transaksi yang telah dilakukan
    static void tampilkanTransaksi() {
        System.out.println("\n=== DAFTAR TRANSAKSI ===");
        if (transaksiSayur.isEmpty()) { // jika belum ada transaksi
            System.out.println("Belum ada transaksi.");
        } else {
            for (int i = 0; i < transaksiSayur.size(); i++) {
                // menampilkan detail setiap transaksi
                System.out.println((i + 1) + ". " + transaksiSayur.get(i) + " - " +
                        transaksiJumlah.get(i) + " ikat - Rp" + transaksiTotal.get(i));
            }
        }
    }

    // 🔹 Menu utama program
    static void mainMenu() {
        System.out.println("\n=== SISTEM KASIR SAYURAN ===");
        System.out.println("1. Lihat Menu Sayuran");
        System.out.println("2. Beli Sayur");
        System.out.println("3. Lihat Transaksi");
        System.out.println("4. Tambah Sayur Baru");
        System.out.println("5. Keluar");
        System.out.print("\nPilih menu: ");
        int pilihan = input.nextInt();

        // Gunakan switch expression untuk memilih menu
        switch (pilihan) {
            case 1 -> tampilkanMenuSayur(); // tampilkan daftar sayur
            case 2 -> {
                tampilkanMenuSayur(); // tampilkan daftar sayur terlebih dahulu
                System.out.print("Pilih sayur: ");
                int beli = input.nextInt();
                if (beli >= 1 && beli <= daftarSayur.size())
                    prosesTransaksi(beli - 1); // proses pembelian sayur
                else
                    System.out.println("⚠️ Pilihan tidak valid!");
            }
            case 3 -> tampilkanTransaksi(); // tampilkan transaksi
            case 4 -> tambahSayurBaru(); // tambah sayur baru
            case 5 -> {
                System.out.println("Terima kasih sudah menggunakan kasir ini!!");
                return; // keluar dari program
            }
            default -> System.out.println("⚠️ Pilihan tidak valid!");
        }

        // Setelah selesai, tampilkan menu lagi
        mainMenu();
    }

    // 🔹 Fungsi utama yang pertama kali dijalankan
    public static void main(String[] args) {
        mainMenu(); // memanggil menu utama
    }
}
