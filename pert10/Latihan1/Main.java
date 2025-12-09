package pert10.Latihan1;

public class Main {
    public static void main(String[] args) {

        // Latihan 1
        Printer p1 = new InkjetPrinter();
        Printer p2 = new LaserPrinter();

        p1.print(); // Overriding → inkjet
        p2.print(); // Overriding → laser

        System.out.println("\n=== Latihan 2: Tambah DotMatrixPrinter ===");

        // Menaruh semua printer ke dalam array/list
        Printer[] printers = {
            new InkjetPrinter(),
            new LaserPrinter(),
            new DotMatrixPrinter() // class baru, tapi tidak perlu ubah kode lama
        };

        for (Printer p : printers) {
            p.print();
        }
    }
}
