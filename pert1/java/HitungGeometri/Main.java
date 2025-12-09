package pert1.java.HitungGeometri;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input lingkaran
        System.out.print("Masukkan jari-jari lingkaran: ");
        double r = input.nextDouble();

        // Input persegi panjang
        System.out.print("Masukkan panjang persegi panjang: ");
        double panjang = input.nextDouble();
        System.out.print("Masukkan lebar persegi panjang: ");
        double lebar = input.nextDouble();

        // Input segitiga
        System.out.print("Masukkan alas segitiga: ");
        double alas = input.nextDouble();
        System.out.print("Masukkan tinggi segitiga: ");
        double tinggi = input.nextDouble();

        // Hitung menggunakan kelas Geometri
        double kelilingLingkaran = HitungGeometri.hitungKelilingLingkaran(r);
        double luasPersegiPanjang = HitungGeometri.hitungLuasPersegiPanjang(panjang, lebar);
        double luasSegitiga = HitungGeometri.hitungLuasSegitiga(alas, tinggi);

        // Tampilkan hasil
        System.out.println("\n=== Hasil Perhitungan ===");
        System.out.printf("Keliling lingkaran: %.2f%n", kelilingLingkaran);
        System.out.printf("Luas persegi panjang: %.2f%n", luasPersegiPanjang);
        System.out.printf("Luas segitiga: %.2f%n", luasSegitiga);

        input.close();
    }
}