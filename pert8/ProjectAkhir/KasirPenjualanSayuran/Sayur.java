package pert8.ProjectAkhir.KasirPenjualanSayuran;

/**
 * Kelas induk (parent class) untuk semua jenis sayuran.
 * Kelas ini bersifat 'public' agar bisa diakses dari file lain (misal: KasirPenjualan.java).
 * Menggunakan prinsip ENKAPSULASI: data disembunyikan (protected), diakses lewat method publik.
 */
public class Sayur {

    // Atribut dilindungi (protected) agar bisa diakses oleh kelas turunan,
    // tapi tetap tidak bisa diakses langsung dari luar package.
    protected String nama;      // Nama sayur, contoh: "Bayam"
    protected int harga;        // Harga asli per ikat (sebelum diskon)
    protected int stok;         // Jumlah stok yang tersedia
    protected double diskon;    // Diskon dalam bentuk desimal (0.0 = 0%, 0.2 = 20%)
    protected String jenis;     // Jenis sayur, contoh: "Sayur Daun"

    /**
     * Konstruktor utama untuk membuat objek Sayur.
     * Digunakan oleh kelas turunan (SayurDaun, SayurAkar, dll.) saat memanggil 'super()'.
     * 
     * @param nama  Nama sayuran
     * @param harga Harga per ikat (tanpa diskon)
     * @param stok  Jumlah stok awal
     * @param jenis Jenis sayuran (misal: "Sayur Daun")
     */
    public Sayur(String nama, int harga, int stok, String jenis) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.diskon = 0.0;      // Default: tidak ada diskon
        this.jenis = jenis;     // Simpan jenis sayur
    }

    /**
     * Konstruktor alternatif (tanpa parameter jenis).
     * Digunakan saat membuat objek Sayur umum (bukan turunan).
     * Secara otomatis mengatur jenis menjadi "Sayur".
     * 
     * @param nama  Nama sayuran
     * @param harga Harga per ikat
     * @param stok  Jumlah stok awal
     */
    public Sayur(String nama, int harga, int stok) {
        this(nama, harga, stok, "Sayur"); // Memanggil konstruktor di atas
    }

    // ───────────────────────────────────────
    // METHOD GETTER: untuk MENGAMBIL nilai atribut
    // ───────────────────────────────────────

    /** Mengembalikan nama sayur */
    public String getNama() {
        return nama;
    }

    /**
     * Mengembalikan harga SETELAH diskon.
     * Contoh: harga = 10000, diskon = 0.2 → hasil = 8000.
     * Digunakan di menu dan struk untuk menampilkan harga yang harus dibayar.
     */
    public int getHarga() {
        return (int) (harga - (harga * diskon));
    }

//    /** Mengembalikan harga ASLI (sebelum diskon) */
//    public int getHargaAsli() {
//        return harga;
//    }

    /** Mengembalikan jumlah stok yang tersisa */
    public int getStok() {
        return stok;
    }

    /** Mengembalikan nilai diskon (dalam desimal, misal: 0.2) */
    public double getDiskon() {
        return diskon;
    }

    /** Mengembalikan jenis sayur (misal: "Sayur Daun") */
    public String getJenis() {
        return jenis;
    }

    // ───────────────────────────────────────
    // METHOD SETTER: untuk MENGATUR nilai atribut
    // ───────────────────────────────────────

//    /** Mengatur ulang jumlah stok */
//    public void setStok(int stok) {
//        this.stok = stok;
//    }

    /**
     * Mengatur nilai diskon.
     * Validasi: diskon harus antara 0.0 (0%) hingga 1.0 (100%).
     * 
     * @param diskon Nilai diskon dalam desimal (misal: 0.15 untuk 15%)
     */
    public void setDiskon(double diskon) {
        if (diskon >= 0 && diskon <= 1) {
            this.diskon = diskon;
        }
        // Jika nilai di luar rentang, diskon tidak diubah (aman dari input salah)
    }

    /**
     * Mengurangi stok setelah sayur dibeli.
     * Dipanggil saat transaksi berhasil.
     * 
     * @param jumlah Jumlah ikat yang dibeli
     */
    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
    }
}
