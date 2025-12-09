package pert2;
import java.util.Scanner;

public class KasirSederhana {

    // Method untuk menampilkan menu
    static void tampilkanMenu(String[] menu, int[] harga) {
        System.out.println("\n=== Menu Makanan & Minuman ===");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i+1) + ". " + menu[i] + " - Rp" + harga[i]);
        }
        System.out.println("5. Keluar");
    }

    // Method untuk menghitung total harga
    static int hitungTotal(int harga, int jumlah) {
        return harga * jumlah; // ekspresi aritmatika
    }

    // Method untuk mencetak struk
    static void cetakStruk(String menu, int jumlah, int total) {
        System.out.println("\n=== STRUK PEMBELIAN ===");
        System.out.println("Pesanan : " + menu);
        System.out.println("Jumlah  : " + jumlah);
        System.out.println("Total   : Rp" + total);
        System.out.println("=======================");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Variabel & Tipe Data
        String[] menu = {"Nasi Goreng", "Mie Ayam", "Es Teh", "Kopi"};
        int[] harga = {15000, 12000, 5000, 7000};
        boolean lanjut = true;

        // Control Statement: while loop
        while (lanjut) { //di check duluu baru bisa jalan, kalau do while jalan dulu sekali baru jika kondisinya salah 
            tampilkanMenu(menu, harga);

            System.out.print("\nMasukkan nomor menu: ");
            int pilihan = input.nextInt(); // variabel pilihan

            // Control Statement: switch-case
            switch (pilihan) {
                case 1: case 2: case 3: case 4:
                    System.out.print("Masukkan jumlah: ");
                    int jumlah = input.nextInt(); // variabel jumlah

                    // Ekspresi
                    int total = hitungTotal(harga[pilihan-1], jumlah);

                    cetakStruk(menu[pilihan-1], jumlah, total);

                    // Control Statement: if-else
                    if (total >= 50000) {
                        System.out.println("🎁 Bonus: Es Teh Gratis!");
                    } else {
                        System.out.println("Terima kasih sudah belanja 😊");
                    }
                    break;

                case 5:
                    System.out.println("Program selesai. Sampai jumpa!");
                    lanjut = false; // keluar dari while loop
                    break;

                default:
                    System.out.println("⚠️ Pilihan tidak valid!");
                    break;
            }
        }

        input.close();
    }
}



