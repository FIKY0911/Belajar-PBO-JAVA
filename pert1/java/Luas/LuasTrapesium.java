package pert1.java.Luas;
import java.util.Scanner;

public class LuasTrapesium {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Alas A: ");
        double a = input.nextDouble();
        System.out.print("Masukkan Alas B: ");
        double b = input.nextDouble();
        System.out.print("Masukkan Tingginya: ");
        double tinggi = input.nextDouble();

        double hasil = 0.5 * (a + b) * tinggi;

        System.out.println("Hasil Luas Trapesium: " + hasil);
        input.close();
    }

}
