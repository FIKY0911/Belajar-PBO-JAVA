package pert4.PraktekFunctionParameter; //tempat file java berada
import java.util.Scanner; //import library Scanner

public class KasirPenjualanSayuran { //nama class harus sesuai dengan nama file
    // Scanner untuk input
    static Scanner input = new Scanner(System.in);

    // Data sayur
    static String[] sayuran = {"Wortel", "Bayam", "Tomat", "Kubis"}; //nama sayuran
    static int[] harga = {15000, 5000, 12000, 8000}; //harga sayuran
    static int[] stok = {3, 5, 4, 2}; //stok sayuran

    // Data transaksi
    static String[] transaksiSayur = new String[10]; //menyimpan nama sayur yang dibeli
    static int[] transaksiJumlah = new int[10]; //menyimpan jumlah sayur yang dibeli
    static int[] transaksiTotal = new int[10]; //menyimpan total harga sayur yang dibeli
    static int transaksiIndex = 0; //index untuk transaksi

    // Method tampilkan menu sayur (hanya yang stoknya masih ada)
    static void tampilkanMenuSayur() { //menampilkan menu sayur
        System.out.println("\n=== DAFTAR MENU SAYURAN ==="); //judul menu
        if (stok[0] > 0) System.out.println("1. " + sayuran[0] + " - Rp" + harga[0] + " (Stok: " + stok[0] + ")"); //menampilkan menu sayur jika stok masih ada
        if (stok[1] > 0) System.out.println("2. " + sayuran[1] + " - Rp" + harga[1] + " (Stok: " + stok[1] + ")");
        if (stok[2] > 0) System.out.println("3. " + sayuran[2] + " - Rp" + harga[2] + " (Stok: " + stok[2] + ")");
        if (stok[3] > 0) System.out.println("4. " + sayuran[3] + " - Rp" + harga[3] + " (Stok: " + stok[3] + ")");
    }

    // Method hitung total
    static int hitungTotal(int harga, int jumlah) { //menghitung total harga
        return harga * jumlah; //mengembalikan total harga
    }

    // Method transaksi beli
    static void prosesTransaksi(int index) {
        System.out.print("Masukkan jumlah ikat: ");//meminta input jumlah ikat
        int jumlah = input.nextInt(); //membaca input jumlah ikat

        if (jumlah <= stok[index]) { //jika jumlah ikat yang dibeli lebih kecil atau sama dengan stok
            int total = hitungTotal(harga[index], jumlah); //menghitung total harga
            // update stok
            stok[index] = stok[index] - jumlah; //mengurangi stok

            // simpan transaksi
            transaksiSayur[transaksiIndex] = sayuran[index]; //menyimpan nama sayur yang dibeli
            transaksiJumlah[transaksiIndex] = jumlah; //menyimpan jumlah sayur yang dibeli
            transaksiTotal[transaksiIndex] = total; //menyimpan total harga sayur yang dibeli
            transaksiIndex = transaksiIndex + 1; //menambah index transaksi

            System.out.println("\n===== STRUK PEMBELIAN ====="); //judul struk pembelian
            System.out.println("Sayur   : " + sayuran[index]); //menampilkan nama sayur yang dibeli 
            System.out.println("Jumlah  : " + jumlah + " ikat"); //menampilkan jumlah sayur yang dibeli
            System.out.println("Total   : Rp" + total); //menampilkan total harga sayur yang dibeli
            System.out.println("==========================="); //garis pembatas
        } else {
            System.out.println("⚠️ Stok tidak cukup! Sisa stok: " + stok[index]); //menampilkan pesan jika stok tidak cukup
        }
    }

    // Method lihat transaksi
    static void tampilkanTransaksi() {
        System.out.println("\n=== DAFTAR TRANSAKSI ==="); //judul daftar transaksi
        if (transaksiIndex == 0) { //jika belum ada transaksi
            System.out.println("Belum ada transaksi."); //menampilkan pesan belum ada transaksi
        } else {
            int i = 0; //index untuk menampilkan transaksi
            // menampilkan transaksi 4 per 4
            if (i < transaksiIndex) { //menampilkan transaksi jika index masih kurang dari index transaksi
                System.out.println((i+1) + ". " + transaksiSayur[i] + " - "
                    + transaksiJumlah[i] + " ikat - Rp" + transaksiTotal[i]); //menampilkan transaksi
            }
            if (i+1 < transaksiIndex) { //menampilkan transaksi jika index + 1 masih kurang dari index transaksi
                System.out.println((i+2) + ". " + transaksiSayur[i+1] + " - " 
                    + transaksiJumlah[i+1] + " ikat - Rp" + transaksiTotal[i+1]); //menampilkan transaksi
            }
            if (i+2 < transaksiIndex) { //menampilkan transaksi jika index + 2 masih kurang dari index transaksi
                System.out.println((i+3) + ". " + transaksiSayur[i+2] + " - " 
                    + transaksiJumlah[i+2] + " ikat - Rp" + transaksiTotal[i+2]); //menampilkan transaksi
            }
            if (i+3 < transaksiIndex) { //menampilkan transaksi jika index + 3 masih kurang dari index transaksi
                System.out.println((i+4) + ". " + transaksiSayur[i+3] + " - " 
                    + transaksiJumlah[i+3] + " ikat - Rp" + transaksiTotal[i+3]);
            }
        }
    }

    // Menu utama
    static void mainMenu() { //menu utama
        System.out.println("\n=== SISTEM KASIR SAYURAN ==="); //judul sistem kasir
        System.out.println("1. Lihat Menu Sayuran"); //menampilkan menu utama
        System.out.println("2. Beli Sayur"); //menampilkan menu utama
        System.out.println("3. Lihat Transaksi"); //menampilkan menu utama
        System.out.println("4. Keluar"); //menampilkan menu utama

        System.out.print("\nPilih menu: "); //meminta input pilihan menu
        int pilihan = input.nextInt(); //membaca input pilihan menu

        switch (pilihan) { //percabangan switch case
            case 1:
                tampilkanMenuSayur(); //menampilkan menu sayur
                mainMenu(); //kembali ke menu utama
                break; //menghentikan eksekusi case
            case 2:
                tampilkanMenuSayur(); //menampilkan menu sayur
                System.out.print("Pilih sayur: "); //meminta input pilihan sayur
                int beli = input.nextInt(); //membaca input pilihan sayur
                // proses beli
                if (beli == 1 && stok[0] > 0) prosesTransaksi(0); //jika pilihan 1 dan stok masih ada, proses transaksi
                else if (beli == 2 && stok[1] > 0) prosesTransaksi(1); //jika pilihan 2 dan stok masih ada, proses transaksi
                else if (beli == 3 && stok[2] > 0) prosesTransaksi(2); //jika pilihan 3 dan stok masih ada, proses transaksi
                else if (beli == 4 && stok[3] > 0) prosesTransaksi(3); //jika pilihan 4 dan stok masih ada, proses transaksi
                else System.out.println("⚠️ Pilihan tidak valid atau stok habis!"); //menampilkan pesan jika pilihan tidak valid atau stok habis
                mainMenu(); //kembali ke menu utama
                break;
            case 3:
                tampilkanTransaksi(); //menampilkan transaksi
                mainMenu(); //kembali ke menu utama
                break;
            case 4:
                System.out.println("Terima kasih sudah menggunakan kasir 😊"); //menampilkan pesan terima kasih
                break;
            default:
                System.out.println("⚠️ Pilihan tidak valid!"); //menampilkan pesan jika pilihan tidak valid
                mainMenu();
        }
    }

    public static void main(String[] args) { //method utama
        mainMenu(); //memanggil method mainMenu
    }
}
