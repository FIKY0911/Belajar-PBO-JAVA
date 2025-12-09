package pert7.ProjectAkhir.KasirPenjualanSayuran;

// 🔹 Class Sayur dengan Enkapsulasi
public class Sayur {
    private String nama;
    private int harga;
    private int stok;
    private double diskon; // contoh: 0.1 = 10%

    // Konstruktor
    public Sayur(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.diskon = 0.0;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return (int) (harga - (harga * diskon));
    }

    public int getHargaAsli() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public double getDiskon() {
        return diskon;
    }

    // Method untuk mengurangi stok setelah pembelian
    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
    }
}
