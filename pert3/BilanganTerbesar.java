package pert3;
import java.util.Scanner;

public class BilanganTerbesar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input dua bilangan
        System.out.print("Masukkan bilangan pertama: ");
        int a = input.nextInt();

        System.out.print("Masukkan bilangan kedua: ");
        int b = input.nextInt();

        // Menentukan bilangan terbesar dengan if-else
        if (a > b) {
            System.out.println("Bilangan terbesar adalah: " + a);
        } else if (b > a) {
            System.out.println("Bilangan terbesar adalah: " + b);
        } else {
            System.out.println("Kedua bilangan sama besar: " + a);
        }

        input.close();
    }
}

