package pert1.java.Lingkaran;
import java.util.Scanner; // untuk input dari keyboard

public class KelilingLingkaran {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jari-jari lingkaran: ");
        double r = input.nextDouble();
        double keliling = 2 * Math.PI * r;
        System.out.println("Keliling lingkaran adalah: " + keliling);

        input.close();
    }
}
