package pert1.java.OperasiMTK;
import java.util.Scanner;

public class pertambahan {
    public static void main(String[] args){
        Scanner input = new Scanner (System.in);
        System.out.print("Masukkan Angka pertama: ");
        double satu = input.nextDouble();
        System.out.print("Masukkan Angka Kedua: ");
        double dua = input.nextDouble();
        double hasil = (satu > dua) ? (satu + dua) : (dua + satu);
        System.out.println("Hasilnya adalah: " + hasil);

        input.close();
    }
}
