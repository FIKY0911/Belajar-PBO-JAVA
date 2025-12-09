package pert2.ModulPraktikum;
import java.util.Scanner;

public class Pertemuan2_Konversisuhu {
    public static void main (String[] args) {
        //deklarasi celcius dan reamur
        float celcius;
        double reamur;

        Scanner kbd = new Scanner (System.in); //Untuk mendapatkan inputan dari keyboard
        System.out.print("Suhu dalam celcius : "); // User dapat menginput disini
        celcius = kbd.nextFloat(); //Untuk menampung data inputan

        // reamur = 8.0 * celcius; //rumusnya
        reamur = 4.0/5.0 * celcius;

        System.out.println("Reaumur   = " + reamur); //Untuk hasilnya
    }   
}
