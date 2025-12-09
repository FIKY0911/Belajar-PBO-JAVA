package pert9.Teori;

// Kelas dasar (parent class) untuk semua hewan
class Hewan {
    // Atribut private: hanya bisa diakses melalui getter/setter
    private String nama;
    
    // Atribut protected: bisa diakses oleh subclass (anak kelas)
    protected int harga;
    protected String jenis;
    
    // Atribut package-private (default): bisa diakses dalam package yang sama
    int umur;

    // Konstruktor untuk menginisialisasi jenis dan harga saat objek dibuat
    Hewan(String jenis, int harga) {
        this.jenis = jenis;
        this.harga = harga;
    }

    // Getter untuk mengambil nilai atribut private 'nama'
    public String getNama() { return nama; }
    
    // Getter untuk mengambil nilai 'harga'
    public int getHarga() { return harga; }
    
    // Getter untuk mengambil nilai 'jenis'
    public String getJenis() { return jenis; }
    
    // Getter untuk mengambil nilai 'umur'
    public int getUmur() { return umur; }

    // Setter untuk mengubah nilai atribut 'nama'
    public void setNama(String nama) { this.nama = nama; }
    
    // Setter untuk mengubah nilai 'harga'
    public void setHarga(int harga) { this.harga = harga; }
    
    // Setter untuk mengubah nilai 'jenis'
    public void setJenis(String jenis) { this.jenis = jenis; }
    
    // Setter untuk mengubah nilai 'umur'
    public void setUmur(int umur) { this.umur = umur; }

    // Metode umum: menampilkan pesan bahwa hewan sedang makan
    public void makan() {
        System.out.println(getNama() + " sedang makan");
    }

    // Metode umum: menampilkan pesan bahwa hewan sedang bergerak
    public void bergerak() {
        System.out.println(getNama() + " sedang bergerak");
    }

    // Metode untuk menampilkan harga hewan
    public void harga() {
        System.out.println(getNama() + " dengan harga = " + getHarga());
    }

    // Metode untuk menampilkan jenis hewan
    public void jenis() {
        System.out.println(getNama() + " dengan jenis = " + getJenis());
    }

    // Metode untuk menampilkan umur hewan
    public void umur() {
        System.out.println(getNama() + " dengan umur = " + getUmur());
    }
}

// Kelas Kucing mewarisi (extends) dari Hewan
class Kucing extends Hewan {
    // Konstruktor Kucing memanggil konstruktor parent (Hewan)
    Kucing(String jenis, int harga) {
        super(jenis, harga); // memanggil Hewan(jenis, harga)
    }

    // Override metode umur() dari parent untuk menambahkan satuan "bulan"
    @Override
    public void umur() {
        System.out.println(getNama() + " dengan umur = " + getUmur() + " bulan");
    }
}

// Kelas Kelinci juga mewarisi dari Hewan
class Kelinci extends Hewan {
    // Konstruktor Kelinci memanggil konstruktor parent
    Kelinci(String jenis, int harga) {
        super(jenis, harga);
    }

    // Override metode umur() untuk menambahkan satuan "bulan"
    @Override
    public void umur() {
        System.out.println(getNama() + " dengan umur = " + getUmur() + " bulan");
    }
}

// Anggora adalah jenis khusus dari Kucing
class Anggora extends Kucing {
    // Konstruktor Anggora memanggil konstruktor Kucing
    Anggora(String jenis, int harga) {
        super(jenis, harga);
    }
}

// AnakKucing adalah subclass dari Kucing dengan atribut tambahan
class AnakKucing extends Kucing {
    // Atribut khusus untuk menyimpan warna bulu
    String warnaBulu;

    // Konstruktor AnakKucing: menerima nama, jenis, warna bulu, dan harga
    AnakKucing(String nama, String jenis, String warnaBulu, int harga) {
        super(jenis, harga);        // panggil konstruktor Kucing
        this.warnaBulu = warnaBulu; // simpan warna bulu
        setNama(nama);              // atur nama melalui setter (karena 'nama' private di Hewan)
    }

    // Metode khusus untuk menampilkan warna bulu
    public void warnaBulu() {
        System.out.println(getNama() + " dengan warna bulu = " + warnaBulu);
    }
}

// Kelas utama untuk menjalankan program
class Main {
    public static void main(String[] args) {
        // Membuat objek Kucing dengan jenis dan harga awal
        Kucing k1 = new Kucing("Kucing Lokal", 2500000);
        k1.setNama("Said");      // atur nama
        k1.setJenis("Putih");    // ubah jenis (misal: warna)
        k1.setUmur(5);           // atur umur

        // Membuat objek Kelinci
        Kelinci k2 = new Kelinci("Kelinci Hias", 3000000);
        k2.setNama("Yohan");
        k2.setJenis("Hitam");
        k2.setUmur(10);

        // Membuat objek Anggora (jenis kucing)
        Anggora k3 = new Anggora("Anggora", 4000000);
        k3.setNama("Shobur");
        k3.setUmur(3);

        // Membuat objek AnakKucing dengan warna bulu
        AnakKucing ak = new AnakKucing("Moli", "Persia", "Coklat", 1500000);
        ak.setUmur(2); // atur umur setelah objek dibuat

        // Tampilkan semua info untuk k1 (Kucing)
        k1.makan(); 
        k1.bergerak(); 
        k1.jenis(); 
        k1.harga(); 
        k1.umur(); // menggunakan versi override (dengan "bulan")
        System.out.println(); // baris kosong untuk pemisah

        // Tampilkan semua info untuk k2 (Kelinci)
        k2.makan(); 
        k2.bergerak(); 
        k2.jenis(); 
        k2.harga(); 
        k2.umur(); // juga menggunakan override
        System.out.println();

        // Tampilkan info untuk k3 (Anggora)
        k3.makan(); 
        k3.bergerak(); 
        k3.jenis(); 
        k3.harga(); 
        k3.umur(); // mewarisi override dari Kucing
        System.out.println();

        // Tampilkan info untuk AnakKucing (termasuk warna bulu)
        ak.makan(); 
        ak.bergerak(); 
        ak.jenis(); 
        ak.harga(); 
        ak.umur();      // override dari Kucing
        ak.warnaBulu(); // metode khusus AnakKucing
    }
}
