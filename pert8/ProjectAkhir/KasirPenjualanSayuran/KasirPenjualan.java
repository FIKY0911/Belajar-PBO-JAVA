package pert8.ProjectAkhir.KasirPenjualanSayuran;

import java.util.ArrayList; // Digunakan untuk menyimpan daftar sayur dan transaksi secara dinamis
import java.util.Scanner;   // Digunakan untuk membaca input dari pengguna

// ───────────────────────────────────────
// KELAS TURUNAN: Didefinisikan di sini karena tidak perlu file terpisah
// Semua kelas turunan mewarisi sifat dari kelas Sayur (inheritance)
// ───────────────────────────────────────

// Kelas SayurDaun: mewarisi semua atribut dan method dari kelas Sayur
class SayurDaun extends Sayur {
    // Konstruktor kelas SayurDaun
    // Memanggil konstruktor kelas induk (Sayur) menggunakan 'super'
    public SayurDaun(String nama, int harga, int stok) {
        super(nama, harga, stok, "Sayur Daun"); // Kirim jenis "Sayur Daun" ke kelas induk
    }
}

// Kelas SayurAkar: kelas turunan untuk sayuran jenis akar
class SayurAkar extends Sayur {
    public SayurAkar(String nama, int harga, int stok) {
        super(nama, harga, stok, "Sayur Akar");
    }
}

// Kelas SayurBuah: kelas turunan untuk sayuran yang berbentuk buah
class SayurBuah extends Sayur {
    public SayurBuah(String nama, int harga, int stok) {
        super(nama, harga, stok, "Sayur Buah");
    }
}

// ───────────────────────────────────────
// KELAS UTAMA APLIKASI KASIR
// ───────────────────────────────────────
public class KasirPenjualan {

    // Objek Scanner untuk menerima input dari keyboard
    static Scanner input = new Scanner(System.in);

    // Daftar semua sayur (bisa berisi Sayur, SayurDaun, SayurAkar, dll.)
    static ArrayList<Sayur> daftarSayur = new ArrayList<>();

    // Variabel untuk menyimpan riwayat transaksi
    static ArrayList<String> transaksiSayur = new ArrayList<>();   // Nama sayur yang dibeli
    static ArrayList<Integer> transaksiJumlah = new ArrayList<>(); // Jumlah yang dibeli
    static ArrayList<Integer> transaksiTotal = new ArrayList<>();  // Total harga per transaksi

    /**
     * Method ini dijalankan saat program pertama kali dijalankan.
     * Berfungsi untuk mengisi daftar sayur awal menggunakan kelas turunan (inheritance).
     */
    public static void initAwal() {
        daftarSayur.add(new SayurAkar("Wortel", 15000, 3));     // Menambahkan wortel sebagai SayurAkar
        daftarSayur.add(new SayurDaun("Bayam", 5000, 6));       // Menambahkan bayam sebagai SayurDaun
        daftarSayur.add(new SayurBuah("Tomat", 12000, 4));      // Menambahkan tomat sebagai SayurBuah
        daftarSayur.add(new SayurDaun("Kangkung", 4000, 8));    // Kangkung juga termasuk sayur daun
    }

    /**
     * Menampilkan daftar sayur yang tersedia di layar.
     * Hanya menampilkan sayur yang stoknya masih ada.
     */
    static void tampilkanMenuSayur() {
        System.out.println("\n=== DAFTAR MENU SAYURAN ===");
        int no = 1; // Nomor urut di menu
        boolean adaStok = false; // Penanda apakah ada sayur yang masih tersedia

        // Perulangan untuk setiap sayur dalam daftar
        for (Sayur s : daftarSayur) {
            if (s.getStok() > 0) { // Cek apakah stok masih ada
                adaStok = true;
                // Jika ada diskon, tampilkan persentase diskon
                String diskonStr = s.getDiskon() > 0 ?
                    " (Diskon: " + (int) (s.getDiskon() * 100) + "%)" : "";
                // Tampilkan: nomor, jenis, nama, harga akhir, dan stok
                // Hanya tampilkan harga setelah diskon (satu harga saja)
                System.out.println(no + ". [" + s.getJenis() + "] " + s.getNama() +
                        " - Rp" + s.getHarga() + " (Stok: " + s.getStok() + ")" + diskonStr);
            }
            no++;
        }

        // Jika semua sayur habis stok
        if (!adaStok) {
            System.out.println("Sayangnya, semua sayur sedang kosong stok. 🥺");
        }
    }

    /**
     * Method untuk menambahkan sayur baru berdasarkan input pengguna.
     * Pengguna bisa memilih jenis sayur, lalu sistem membuat objek sesuai jenisnya.
     */
    static void tambahSayurBaru() {
        System.out.println("\n=== TAMBAH SAYUR BARU ===");
        System.out.print("Nama sayur: ");
        String nama = input.next();
        System.out.print("Harga per ikat: ");
        int harga = input.nextInt();
        System.out.print("Stok awal: ");
        int stok = input.nextInt();

        // Tampilkan pilihan jenis sayur
        System.out.println("Pilih jenis sayur:");
        System.out.println("1. Sayur Daun");
        System.out.println("2. Sayur Akar");
        System.out.println("3. Sayur Buah");
        System.out.print("Pilihan (1/2/3): ");
        int jenis = input.nextInt();

        Sayur sayurBaru; // Variabel untuk menyimpan objek sayur baru

        // Gunakan switch untuk membuat objek berdasarkan pilihan jenis
        // Ini adalah contoh penerapan INHERITANCE: objek berbeda tapi disimpan dalam tipe Sayur
        switch (jenis) {
            case 1 -> sayurBaru = new SayurDaun(nama, harga, stok);
            case 2 -> sayurBaru = new SayurAkar(nama, harga, stok);
            case 3 -> sayurBaru = new SayurBuah(nama, harga, stok);
            default -> {
                System.out.println("Jenis tidak dikenali. Digunakan sebagai Sayur umum.");
                sayurBaru = new Sayur(nama, harga, stok);
            }
        }

        // Tanyakan apakah ingin memberi diskon
        System.out.print("Tambah diskon? (y/n): ");
        if (input.next().equalsIgnoreCase("y")) {
            System.out.print("Besar diskon (0.2 = 20%): ");
            double diskon = input.nextDouble();
            sayurBaru.setDiskon(diskon);
        }

        // Tambahkan ke daftar
        daftarSayur.add(sayurBaru);
        System.out.println("✅ Sayur '" + nama + "' (" + sayurBaru.getJenis() + ") berhasil ditambahkan!");
    }

    /**
     * Memproses pembelian sayur berdasarkan indeks yang dipilih pengguna.
     * Memeriksa stok, mengurangi stok, dan menyimpan ke riwayat transaksi.
     */
    static void prosesTransaksi(int index) {
        Sayur s = daftarSayur.get(index); // Ambil objek sayur berdasarkan pilihan
        System.out.print("Masukkan jumlah ikat yang dibeli: ");
        int jumlah = input.nextInt();

        // Validasi jumlah
        if (jumlah <= 0) {
            System.out.println("⚠️ Jumlah harus lebih dari 0!");
            return;
        }

        // Cek apakah stok mencukupi
        if (jumlah <= s.getStok()) {
            int total = s.getHarga() * jumlah; // Hitung total harga (setelah diskon)
            s.kurangiStok(jumlah); // Kurangi stok

            // Simpan ke riwayat transaksi
            transaksiSayur.add(s.getNama());
            transaksiJumlah.add(jumlah);
            transaksiTotal.add(total);

            // Cetak struk pembelian
            System.out.println("\n===== STRUK PEMBELIAN =====");
            System.out.println("Jenis   : " + s.getJenis());   // Misal: Sayur Daun
            System.out.println("Sayur   : " + s.getNama());     // Misal: Bayam
            System.out.println("Jumlah  : " + jumlah + " ikat");
            // HARGA: tampilkan harga asli dan harga setelah diskon (opsional)
            // Jika tidak ingin tanda "→", cukup tampilkan harga akhir saja:
            System.out.println("Harga   : Rp" + s.getHarga()); // Hanya harga akhir
            if (s.getDiskon() > 0) {
                System.out.println("Diskon  : " + (int) (s.getDiskon() * 100) + "%");
            }
            System.out.println("Total   : Rp" + total);
            System.out.println("===========================");
        } else {
            System.out.println("⚠️ Stok tidak cukup! Sisa stok: " + s.getStok());
        }
    }

    /**
     * Menampilkan seluruh riwayat transaksi yang pernah dilakukan.
     */
    static void tampilkanTransaksi() {
        System.out.println("\n=== RIWAYAT TRANSAKSI ===");
        if (transaksiSayur.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            // Tampilkan setiap transaksi dengan nomor urut
            for (int i = 0; i < transaksiSayur.size(); i++) {
                System.out.println((i + 1) + ". " + transaksiSayur.get(i) +
                        " (" + transaksiJumlah.get(i) + " ikat) → Rp" + transaksiTotal.get(i));
            }
        }
    }

    /**
     * Menampilkan menu utama dan menangani pilihan pengguna.
     * Menggunakan rekursi (panggil diri sendiri) untuk kembali ke menu setelah setiap aksi.
     */
    static void mainMenu() {
        System.out.println("\n=== SISTEM KASIR SAYURAN ===");
        System.out.println("1. Lihat Menu Sayuran");
        System.out.println("2. Beli Sayur");
        System.out.println("3. Lihat Transaksi");
        System.out.println("4. Tambah Sayur Baru");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1-5): ");
        int pilihan = input.nextInt();

        // Tangani pilihan pengguna
        switch (pilihan) {
            case 1 -> tampilkanMenuSayur(); // Tampilkan daftar sayur
            case 2 -> {
                tampilkanMenuSayur(); // Tampilkan dulu daftarnya
                System.out.print("Pilih nomor sayur: ");
                int pilih = input.nextInt();
                // Validasi pilihan
                if (pilih >= 1 && pilih <= daftarSayur.size()) {
                    Sayur s = daftarSayur.get(pilih - 1);
                    if (s.getStok() > 0) {
                        prosesTransaksi(pilih - 1); // Proses pembelian
                    } else {
                        System.out.println("⚠️ Sayur ini stoknya habis!");
                    }
                } else {
                    System.out.println("⚠️ Pilihan tidak valid!");
                }
            }
            case 3 -> tampilkanTransaksi(); // Lihat riwayat
            case 4 -> tambahSayurBaru();    // Tambah data sayur
            case 5 -> {
                System.out.println("Terima kasih telah menggunakan sistem kasir sayuran! 🌱");
                return; // Keluar dari program
            }
            default -> System.out.println("⚠️ Pilihan tidak valid! Silakan coba lagi.");
        }

        // Panggil menu lagi (rekursi)
        mainMenu();
    }

    /**
     * Method utama yang dijalankan pertama kali saat program dijalankan.
     * Menginisialisasi data awal, lalu memulai menu utama.
     */
    public static void main(String[] args) {
        initAwal();   // Isi daftar sayur awal
        mainMenu();   // Jalankan menu utama
    }
}
