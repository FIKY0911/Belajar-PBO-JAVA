package pert3;
import java.util.Scanner;

public class GanjilGenap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input bilangan
        System.out.print("Masukkan sebuah bilangan: ");
        int angka = input.nextInt();

        // Mengecek bilangan dengan if-else
        if (angka % 2 == 0) {
            System.out.println("Bilangan " + angka + " adalah GENAP.");
        } else {
            System.out.println("Bilangan " + angka + " adalah GANJIL.");
        }

        input.close();
    }
}

