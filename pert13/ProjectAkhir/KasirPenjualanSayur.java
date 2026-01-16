package pert13.ProjectAkhir;

import java.util.ArrayList;
import java.util.Scanner;

// INHERITANCE
class SayurDaun extends Sayur {
    public SayurDaun(String nama, int harga, int stok) {
        super(nama, harga, stok, "Sayur Daun");
    }
}

class SayurBuah extends Sayur {
    public SayurBuah(String nama, int harga, int stok) {
        super(nama, harga, stok, "Sayur Buah");
    }

    public void rasa() {
        System.out.println("Sayur Buah biasanya memiliki rasa pedas atau manis.");
    }
}

// Polymorphism
class Cabe extends SayurBuah {
    public Cabe(String nama, int harga, int stok) {
        super(nama, harga, stok);
    }
    @Override
    public void rasa() {
        System.out.println("Cabe memiliki rasa pedas.");
    }
}

class Tomat extends SayurBuah {
    public Tomat(String nama, int harga, int stok) {
        super(nama, harga, stok);
    }

    @Override
    public void rasa() {
        System.out.println("Tomat memiliki rasa asam dan sedikit manis.");
    }
}

class SayurAkar extends Sayur {
    public SayurAkar(String nama, int harga, int stok) {
        super(nama, harga, stok, "Sayur Akar");
    }
}

// Java Colections Framework (ArrayList)
public class KasirPenjualanSayur {

    static Scanner input = new Scanner(System.in);
    
    // ArrayList untuk Menyimpan Daftar Sayur, type bisa berisi class juga asal sudah dibuat classnya
    static ArrayList<Sayur> daftarSayur = new ArrayList<>();
    
    // ArrayList untuk Menyimpan Riwayat Transaksi
    static ArrayList<String> transaksiSayur = new ArrayList<>();
    static ArrayList<Integer> transaksiJumlah = new ArrayList<>();
    static ArrayList<Integer> transaksiTotal = new ArrayList<>();

    public static void initAwal() {
        // Menambahkan beberapa sayur awal ke dalam daftar sayur
        daftarSayur.add(new SayurDaun("Bayam", 5000, 50));
        daftarSayur.add(new SayurDaun("Kangkung", 6000, 40));
        daftarSayur.add(new Cabe("Cabe Merah", 20000, 30));
        daftarSayur.add(new Tomat("Tomat", 8000, 20));
        daftarSayur.add(new SayurAkar("Wortel", 7000, 25));
    }

    static void tampilkanMenuSayur() {
        System.out.println("\n===== DAFTAR SAYURAN =====");
        int no = 1;
        boolean adaStok = false;

        // Tampilkan setiap sayur dalam daftar sayur
        for (Sayur s : daftarSayur) {
            // Jika stok sayur lebih dari 0, tampilkan informasinya
            if (s.getStok() > 0) {
                adaStok = true;

                // Informasi tambahan jika ada diskon
                String infoDiskon = (s.getDiskon() > 0)
                        ? " (Diskon " + (int) (s.getDiskon() * 100) + "%, Harga Asli: Rp" + s.getHargaAsli() + ")"
                        : "";

                // Tampilkan informasi sayur
                System.out.println(no + ". [" + s.getJenis() + "] "
                        + s.getNama() + " - Harga: Rp" + s.getHarga()
                        + " (Stok: " + s.getStok() + ")" + infoDiskon);
            }
            no++;
        }

        if (!adaStok) {
            System.out.println("Maaf, semua sayuran sedang habis.");
        }
    }

    static void tambahSayurBaru() {
        System.out.println("\n===== TAMBAH SAYUR BARU =====");
        String nama = "";
        boolean namaValid = false;
        while (!namaValid) {
            try {
                System.out.print("Nama sayur: ");
                nama = input.nextLine();
                if (!nama.matches("[a-zA-Z\\s]+")) {
                    throw new IllegalArgumentException("Input tidak boleh mengandung angka!");
                }
                namaValid = true;
            } catch (IllegalArgumentException _) {
                System.out.println("Input nama tidak valid! Masukkan teks.");
            }
        }

        int harga = 0;
        boolean hargaValid = false;
        while (!hargaValid) {
            try {
                System.out.print("Harga per ikat: ");
                harga = input.nextInt();
                if (harga <= 0) {
                    System.out.println("Harga harus lebih dari 0!");
                } else {
                    hargaValid = true;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input harga tidak valid! Masukkan angka.");
                input.nextLine();
            }
        }

        int stok = 0;
        boolean stokValid = false;
        while (!stokValid) {
            try {
                System.out.print("Stok awal: ");
                stok = input.nextInt();
                if (stok < 0) {
                    System.out.println("Stok tidak boleh negatif!");
                } else {
                    stokValid = true;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input stok tidak valid! Masukkan angka.");
                input.nextLine();
            }
        }
        input.nextLine();

        System.out.println("\nPilih jenis sayur:");
        System.out.println("1. Sayur Daun");
        System.out.println("2. Sayur Buah (Cabe)");
        System.out.println("3. Sayur Buah (Tomat)");
        System.out.println("4. Sayur Akar");
        
        int jenisPilihan = 0;
        boolean jenisValid = false;
        while (!jenisValid) {
            try {
                System.out.print("Pilihan: ");
                jenisPilihan = input.nextInt();
                if (jenisPilihan >= 1 && jenisPilihan <= 4) {
                    jenisValid = true;
                } else {
                    System.out.println("Pilihan harus 1-4!");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid! Masukkan angka 1-4.");
                input.nextLine();
            }
        }
        input.nextLine();

        Sayur sayurBaru;
        switch (jenisPilihan) {
            case 1 -> sayurBaru = new SayurDaun(nama, harga, stok);
            case 2 -> sayurBaru = new Cabe(nama, harga, stok);
            case 3 -> sayurBaru = new Tomat(nama, harga, stok);
            case 4 -> sayurBaru = new SayurAkar(nama, harga, stok);
            default -> sayurBaru = new Sayur(nama, harga, stok);
        }

        System.out.print("Tambah diskon? (y/n): ");
        String jawab = input.next();

        if (jawab.equalsIgnoreCase("y")) {
            System.out.print("Besar diskon (0.1 = 10%, 0.2 = 20%): ");

            String inputDiskon = input.next().replace(",", ".");
            double diskon = 0;
            boolean diskonValid = false;

            while (!diskonValid) {
                try {
                    diskon = Double.parseDouble(inputDiskon);
                    if (diskon < 0 || diskon > 1) {
                        System.out.println("Diskon harus antara 0-1!");
                        System.out.print("Besar diskon (0.1 = 10%, 0.2 = 20%): ");
                        inputDiskon = input.next().replace(",", ".");
                    } else {
                        sayurBaru.setDiskon(diskon);
                        diskonValid = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Format diskon tidak valid! Gunakan contoh: 0.1 atau 0,1");
                    System.out.print("Besar diskon (0.1 = 10%, 0.2 = 20%): ");
                    inputDiskon = input.next().replace(",", ".");
                }
            }
        }
        
        input.nextLine();
        // Tambahkan sayur baru yang dibuat user ke daftar sayur
        daftarSayur.add(sayurBaru);
        System.out.println("Sayur '" + nama + "' berhasil ditambahkan!");
    }

    static void prosesTransaksi(int index) {
        // Ambil sayur dari daftar berdasarkan nomor pilihan user
        Sayur sayurTerpilih = daftarSayur.get(index);

        System.out.print("Masukkan jumlah ikat yang dibeli: ");
        int jumlahBeli = input.nextInt();
        input.nextLine();

        if (jumlahBeli <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            return;
        }

        if (jumlahBeli > sayurTerpilih.getStok()) {
            System.out.println("Stok tidak cukup. Stok tersedia: " + sayurTerpilih.getStok());
            return;
        }

        int totalHarga = sayurTerpilih.getHarga() * jumlahBeli;

        sayurTerpilih.kurangStok(jumlahBeli);

        // Simpan nama sayur yang dibeli ke riwayat transaksi
        transaksiSayur.add(sayurTerpilih.getNama());
        // Simpan jumlah ikat yang dibeli ke riwayat transaksi
        transaksiJumlah.add(jumlahBeli);
        // Simpan total harga pembelian ke riwayat transaksi
        transaksiTotal.add(totalHarga);

        System.out.println("\n====== STRUK PEMBELIAN ======");
        System.out.println("Jenis        : " + sayurTerpilih.getJenis());
        System.out.println("Sayur        : " + sayurTerpilih.getNama());
        System.out.println("Jumlah       : " + jumlahBeli + " ikat");
        System.out.println("Harga Asli   : Rp" + sayurTerpilih.getHargaAsli());

        if (sayurTerpilih.getDiskon() > 0) {
            System.out.println("Diskon       : " + (int) (sayurTerpilih.getDiskon() * 100) + "%");
        }

        System.out.println("Harga Akhir  : Rp" + sayurTerpilih.getHarga());
        System.out.println("Total Bayar  : Rp" + totalHarga);
        System.out.println("==============================\n");
    }

    static void tampilkanRiwayatTransaksi() {
        System.out.println("\n===== RIWAYAT TRANSAKSI =====");
        if (transaksiSayur.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            // Tampilkan semua transaksi dengan mengakses ketiga daftar secara berurutan
            for (int i = 0; i < transaksiSayur.size(); i++) {
                System.out.println((i + 1) + ". " + transaksiSayur.get(i)
                        + " - Jumlah: " + transaksiJumlah.get(i)
                        + " - Total: Rp" + transaksiTotal.get(i));
            }
        }
    }

    static void mainMenu() {
        int pilihan;

        do {
            System.out.println("\n===== KASIR PENJUALAN SAYUR =====");
            System.out.println("1. Tampilkan Menu Sayuran");
            System.out.println("2. Tambah Sayur Baru");
            System.out.println("3. Proses Transaksi");
            System.out.println("4. Tampilkan Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> tampilkanMenuSayur();
                case 2 -> tambahSayurBaru();
                case 3 -> {
                    tampilkanMenuSayur();
                    System.out.print("Pilih nomor sayur: ");
                    int nomor = input.nextInt();
                    input.nextLine();

                    if (nomor > 0 && nomor <= daftarSayur.size()) {
                        prosesTransaksi(nomor - 1);
                    } else {
                        System.out.println("Nomor sayur tidak valid.");
                    }
                }
                case 4 -> tampilkanRiwayatTransaksi();
                case 5 -> System.out.println("Terima kasih!");
                default -> System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 5);
    }

    public static void main(String[] args) {
        initAwal();
        mainMenu();
    }
}
