package pert6.StudyCase.RekeningBank;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk input user
        Scanner input = new Scanner(System.in);

        // Meminta user untuk memasukkan nomor rekening
        System.out.print("Masukkan norek: ");
        String norek = input.nextLine();

        // Meminta user untuk memasukkan saldo
        System.out.print("Masukkan saldo: ");
        double saldo = input.nextDouble();

        // Membuat objek DataBank dengan data yang dimasukkan oleh user
        DataBank data = new DataBank(norek, saldo);

        // Mengatur saldo (meskipun sudah diatur di konstruktor, ini adalah contoh penggunaan setter)
        data.setSaldo(saldo);

        // Menampilkan hasil nomor rekening dan saldo
        System.out.println("Hasil norek dan saldo");
        System.out.println("Norek anda: " + data.getNorek());
        System.out.println("Saldo anda: " + data.getSaldo());

        // Menutup objek Scanner
        input.close();
    }
}
