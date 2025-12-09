package pert2.ModulPraktikum;
import java.util.Scanner;

public class Pertemua2_trigonometri {
    public static void main(String[] args){
        Scanner kbd = new Scanner(System.in); //Untuk inputan pada keyboard

        double x, derajat; //deklarasi untuk x, dan derajat
        System.out.print("x = "); //inputan user
        x = kbd.nextDouble(); //Menampung inputan

        System.out.print("Sudut (dalam derajat) = ");
        derajat = kbd.nextDouble();

        // Mengonversi nilai sudut dari derajat ke radian.
        // Metode Math.toRadians() diperlukan karena sebagian besar fungsi trigonometri di Java
        // seperti Math.tan(), Math.sin(), dan Math.cos()
        // menggunakan radian sebagai unit pengukuran.
        double radian = Math.toRadians(derajat);
        // Menghitung nilai y menggunakan ekspresi matematika y = x * tan(sudut).
        // Sudut dalam ekspresi ini harus dalam satuan radian, sesuai dengan output dari baris kode sebelumnya.
        double y = x * Math.tan(radian);

        System.out.printf("Tinggi menara = %.2f\n", y); //Untuk mengeluarkan hasilnya
    }
    
}
