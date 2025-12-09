import java.util.Scanner;

public class Discond{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //sebagai pembaca input 

        System.out.print("Masukkan harga: "); //Memunculkan Tulisan untuk menginput di console
        double i = input.nextInt(); //Menampung nilai ke variable
        
        double Diskon = 0.0; //Diskon awal 0.0
        if(i >= 6000 && i <= 7000){ //Jika lebih sama dengan 6000 dan kurang sama dengan 7000 maka akan memunuclkan nilainya
            Diskon = 0.2 * i; // Mengalikan Diskon dengan inputan
            System.out.println("20%"); //Memunculkan Diskon yang didapat di console
        } else if (i >= 10000 && i <= 15000){//Jika lebih sama dengan 10000 dan kurang sama dengan 15000 maka akan memunuclkan nilainya
            Diskon = 0.15 * i;
            System.out.println("15%");
        } else if (i == 200000){ // maksimal harga yang berdiskon
            Diskon = 0.3 * i; //untuk mengalikan diskon dengan inputan user
            System.out.println("30%");
        } else{ //Jika selain pengkondisian diatas tidak ada maka akan memunculkann nilainya
            System.out.println("Maaf harga ini ada Discont"); //Memunculkan Tulisan di console saja tanpa menginputkan
        }
        
        double total = i - Diskon; //kemudian hasil dari perhitungan diskon diatas dikuran dengan inputan 
        System.out.println("Diskon yang didapat:" + " " + total); //Memunculkan Tulisan di console saja tanpa menginputkan dan memunculkan nilai diskonnya
        input.close(); // untuk menutup inputan
    }
}
