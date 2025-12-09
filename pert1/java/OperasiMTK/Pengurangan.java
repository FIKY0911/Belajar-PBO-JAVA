package pert1.java.OperasiMTK;

import java.util.Scanner;

public class Pengurangan {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Angka pertama: ");
        int pertama = input.nextInt();
        System.out.print("Masukkan Angka kedua: ");
        int kedua = input.nextInt();
        int hasil = pertama - kedua;
        System.out.println("Hasil" + " " + pertama + " " + "dengan" + " " + kedua + " " + "=" + " " + hasil);

        input.close();
    }
}
