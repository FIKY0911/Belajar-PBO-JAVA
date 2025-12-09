package pert1.java.Luas;
import java.util.Scanner; // untuk input dari keyboard

public class LuasPersegiPanjang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan panjang persegi panjang: ");
        double panjang = input.nextDouble();
        System.out.print("Masukkan lebar persegi panjang: ");
        double lebar = input.nextDouble();
        double luas = panjang * lebar;
        System.out.println("Luas persegi panjang adalah: " + luas);

        input.close();
    }
}
