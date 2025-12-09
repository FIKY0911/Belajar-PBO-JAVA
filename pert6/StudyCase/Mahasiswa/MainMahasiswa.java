package pert6.StudyCase.Mahasiswa;
import java.util.Scanner;

// Definisi kelas MainMahasiswa
public class MainMahasiswa {
    public static void main(String[] args) {

        // Membuat objek Scanner untuk input user
        Scanner input = new Scanner(System.in);

        // Meminta user untuk memasukkan nama
        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();

        // Meminta user untuk memasukkan NIM
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();

        // Meminta user untuk memasukkan IPK
        System.out.print("Masukkan IPK: ");
        double ipk = input.nextDouble();

        // Membuat objek Mahasiswa dengan data yang dimasukkan oleh user
        Mahasiswa mhs = new Mahasiswa(nama, nim, ipk);

        // Menampilkan data Mahasiswa
        System.out.println("\nData Mahasiswa:");
        System.out.println("Nama: " + mhs.getNama());
        System.out.println("NIM: " + mhs.getNim());
        System.out.println("IPK: " + mhs.getIpk());

        // Menutup objek Scanner
        input.close();
    }
}
