package pert10.ProjectAkhir;

import java.util.ArrayList;
import java.util.Scanner;

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

public class KasirPenjualanSayur {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Sayur> daftarSayur = new ArrayList<>();

    static ArrayList<String> transaksiSayur = new ArrayList<>();
    static ArrayList<Integer> transaksiJumlah = new ArrayList<>();
    static ArrayList<Integer> transaksiTotal = new ArrayList<>();

    public static void initAwal() {
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

        for (Sayur s : daftarSayur) {
            if (s.getStok() > 0) {
                adaStok = true;

                String infoDiskon = (s.getDiskon() > 0)
                        ? " (Diskon " + (int)(s.getDiskon() * 100) + "%, Harga Asli: Rp" + s.getHargaAsli() + ")"
                        : "";

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
        System.out.print("Nama sayur: ");
        String nama = input.nextLine();

        System.out.print("Harga per ikat: ");
        int harga = input.nextInt();

        System.out.print("Stok awal: ");
        int stok = input.nextInt();
        input.nextLine();

        System.out.println("\nPilih jenis sayur:");
        System.out.println("1. Sayur Daun");
        System.out.println("2. Sayur Buah (Cabe)");
        System.out.println("3. Sayur Buah (Tomat)");
        System.out.println("4. Sayur Akar");
        System.out.print("Pilihan: ");
        int jenisPilihan = input.nextInt();
        input.nextLine();

        Sayur sayurBaru;

        switch (jenisPilihan) {
            case 1 -> sayurBaru = new SayurDaun(nama, harga, stok);
            case 2 -> sayurBaru = new Cabe(nama, harga, stok);
            case 3 -> sayurBaru = new Tomat(nama, harga, stok);
            case 4 -> sayurBaru = new SayurAkar(nama, harga, stok);
            default -> {
                System.out.println("Pilihan jenis tidak valid. Default = Sayur.");
                sayurBaru = new Sayur(nama, harga, stok);
            }
        }

        System.out.print("Tambah diskon? (y/n): ");
        String jawab = input.next();

        if (jawab.equalsIgnoreCase("y")) {
            System.out.print("Besar diskon (0.1 = 10%, 0.2 = 20%): ");

            // FIX: diskon menerima koma atau titik
            String inputDiskon = input.next().replace(",", ".");
            double diskon;

            try {
                diskon = Double.parseDouble(inputDiskon);
                sayurBaru.setDiskon(diskon);
            } catch (NumberFormatException e) {
                System.out.println("Format diskon tidak valid! Gunakan contoh: 0.1 atau 0,1");
            }
        }

        input.nextLine();
        daftarSayur.add(sayurBaru);
        System.out.println("Sayur '" + nama + "' berhasil ditambahkan!");
    }

    static void prosesTransaksi(int index) {
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

        transaksiSayur.add(sayurTerpilih.getNama());
        transaksiJumlah.add(jumlahBeli);
        transaksiTotal.add(totalHarga);

        System.out.println("\n====== STRUK PEMBELIAN ======");
        System.out.println("Jenis        : " + sayurTerpilih.getJenis());
        System.out.println("Sayur        : " + sayurTerpilih.getNama());
        System.out.println("Jumlah       : " + jumlahBeli + " ikat");
        System.out.println("Harga Asli   : Rp" + sayurTerpilih.getHargaAsli());

        if (sayurTerpilih.getDiskon() > 0) {
            System.out.println("Diskon       : " + (int)(sayurTerpilih.getDiskon() * 100) + "%");
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
