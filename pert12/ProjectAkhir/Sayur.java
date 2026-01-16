package pert12.ProjectAkhir;

//Encapsulation
public class Sayur {

    // Protected attributes (hanya bisa diakses dalam package dan subclass/ tidak dapat diakses pada kasir dan main)
    protected String nama;
    protected int harga;
    protected int stok;
    protected double diskon;
    protected String jenis;

    // Constructor ()
    public Sayur(String nama, int harga, int stok, String jenis) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.diskon = 0.0;
        this.jenis = jenis;
    }

    public Sayur(String nama, int harga, int stok) {
        this(nama, harga, stok, "Sayur");
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return (int) (harga * (1 - diskon));
    }

    public int getHargaAsli() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public double getDiskon() {
        return diskon;
    }

    public String getJenis() {
        return jenis;
    }

    public void setDiskon(double diskon) {
        if (diskon >= 0 && diskon <= 1) {
            this.diskon = diskon;
        } else {
            System.out.println("Nilai diskon harus 0.0 - 1.0");
        }
    }

    public void kurangStok(int jumlah) {
        if (jumlah <= stok) {
            stok -= jumlah;
        } else {
            System.out.println("Stok tidak cukup!");
        }
    }
}
