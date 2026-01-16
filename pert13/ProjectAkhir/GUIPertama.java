package pert13.ProjectAkhir;

import javax.swing.*;
import java.awt.*;

public class GUIPertama extends JFrame {

    // Model data untuk daftar sayur
    private DefaultListModel<String> modelSayur;

    // Komponen list untuk menampilkan sayur
    private JList<String> listSayur;

    public GUIPertama() {

        // Judul window
        setTitle("Kasir Penjualan Sayur");

        // Ukuran window
        setSize(900, 520);

        // Menutup aplikasi sepenuhnya saat tombol X ditekan
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menampilkan window di tengah layar
        setLocationRelativeTo(null);

        // Inisialisasi tampilan
        initComponent();

        // Memuat data awal
        loadData();
    }

    private void initComponent() {

        // setLayout untuk menentukan layout secara otomatis, BorderLayout untuk membagi
        // layar menjadi 5(North, West, Center, East, South), angka untuk menentukan gap
        // antara area
        setLayout(new BorderLayout(10, 10));

        // JUDUL
        // Judul Layout
        JLabel lblJudul = new JLabel("KASIR PENJUALAN SAYUR", JLabel.CENTER);

        // Pengaturan Font
        lblJudul.setFont(new Font("Segoe UI", Font.BOLD, 24));
        // Style untuk memberikan jarak pada Judul
        lblJudul.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        // untuk menerapkan style serta judul berada paling atas windows
        add(lblJudul, BorderLayout.NORTH);

        // LIST SAYUR
        // Model data untuk listsayur
        modelSayur = new DefaultListModel<>();
        // Untuk menampilkan data listsayur
        listSayur = new JList<>(modelSayur);
        // Mengatur jenis font, gaya tulisannya normal, dan ukuran font
        listSayur.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        // Untuk mengatur tinggi disetiap item sama
        listSayur.setFixedCellHeight(30);
        // otomatis Scroll jika barang melebihi layar, dan BorderLayout membuat layar
        // berada ditengah
        add(new JScrollPane(listSayur), BorderLayout.CENTER);

        // PANEL BUTTON
        // JPanel untuk mengelompokkan beberapa komponen
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        // Membuat Button
        JButton btnBeli = new JButton("Beli");
        JButton btnTambah = new JButton("Tambah Sayur");
        JButton btnRefresh = new JButton("Refresh");
        JButton btnRiwayat = new JButton("Riwayat");

        // Font Button
        Font fontBtn = new Font("Segoe UI", Font.BOLD, 14);
        // Menerapkan font btn pada btn
        btnBeli.setFont(fontBtn);
        btnTambah.setFont(fontBtn);
        btnRefresh.setFont(fontBtn);
        btnRiwayat.setFont(fontBtn);

        // untuk menerapkan pengelompokkan btn(style)
        panelButton.add(btnBeli);
        panelButton.add(btnTambah);
        panelButton.add(btnRefresh);
        panelButton.add(btnRiwayat);

        // untuk menerakan style btn dan berada di paling bawah halaman
        add(panelButton, BorderLayout.SOUTH);

        // EVENT
        // Untuk ketika diklik btnnyya maka akan menerapkan logika yg berada file
        // KasirPenjualanSayur
        btnRefresh.addActionListener(e -> loadData());
        btnBeli.addActionListener(e -> beliSayur());
        btnRiwayat.addActionListener(e -> tampilkanRiwayat());
        btnTambah.addActionListener(e -> tambahSayurGUI());
    }

    // LOAD DATA
    private void loadData() {
        // Membersihkan data lama pada model list
        modelSayur.clear();
        // Variabel untuk penomoran item
        int no = 1;

        // Melakukan perulangan untuk setiap objek Sayur di dalam daftarSayur
        for (Sayur s : KasirPenjualanSayur.daftarSayur) {
            // Logika untuk mengecek apakah ada diskon atau tidak
            String infoDiskon = s.getDiskon() > 0
                    ? " | Diskon: " + (int) (s.getDiskon() * 100) + "%"
                    : "";

            // Menambahkan teks informasi sayur ke dalam model list untuk ditampilkan di GUI
            modelSayur.addElement(
                    no++ + ". [" + s.getJenis() + "] "
                            + s.getNama()
                            + " | Harga: Rp" + s.getHarga()
                            + " | Stok: " + s.getStok()
                            + infoDiskon);
        }
    }

    // BELI SAYUR
    private void beliSayur() {

        // Mengambil index baris yang dipilih oleh user pada listSayur
        int index = listSayur.getSelectedIndex();
        // Validasi jika user belum memilih item apapun dari list
        if (index == -1) {
            // Menampilkan pesan peringatan pilih sayur
            JOptionPane.showMessageDialog(this, "Pilih sayur terlebih dahulu!");
            return;
        }

        // Memunculkan input dialog untuk memasukkan jumlah pembelian
        String inputJumlah = JOptionPane.showInputDialog(this, "Masukkan jumlah beli:");
        // Jika user menekan tombol cancel pada dialog
        if (inputJumlah == null)
            return;

        try {
            // Mengonversi input teks jumlah menjadi tipe data integer
            int jumlah = Integer.parseInt(inputJumlah);
            // Mengambil objek Sayur yang sesuai dengan index yang dipilih user
            Sayur s = KasirPenjualanSayur.daftarSayur.get(index);

            // Validasi jika jumlah beli kurang dari 1 atau melebihi stok yang tersedia
            if (jumlah <= 0 || jumlah > s.getStok()) {
                // Menampilkan pesan kesalahan jumlah tidak valid
                JOptionPane.showMessageDialog(this, "Jumlah tidak valid!");
                return;
            }

            // Menghitung total harga (harga setelah diskon dikali jumlah beli)
            int total = s.getHarga() * jumlah;
            // Memanggil method untuk mengurangi stok sayur di model data
            s.kurangStok(jumlah);

            // Menyimpan detail transaksi ke dalam list transaksi di class
            // KasirPenjualanSayur
            KasirPenjualanSayur.transaksiSayur.add(s.getNama());
            KasirPenjualanSayur.transaksiJumlah.add(jumlah);
            KasirPenjualanSayur.transaksiTotal.add(total);

            // Menampilkan struk pembelian menggunakan MessageDialog
            JOptionPane.showMessageDialog(this,
                    "STRUK PEMBELIAN\n"
                            + "----------------------\n"
                            + "Sayur      : " + s.getNama() + "\n"
                            + "Harga Asli : Rp" + s.getHargaAsli() + "\n"
                            + "Diskon     : " + (int) (s.getDiskon() * 100) + "%\n"
                            + "Harga Akhir: Rp" + s.getHarga() + "\n"
                            + "Jumlah     : " + jumlah + "\n"
                            + "Total      : Rp" + total);

            // Memperbarui tampilan list sayur setelah stok berubah
            loadData();

        } catch (NumberFormatException e) {
            // Menampilkan pesan error jika input jumlah bukan berupa angka
            JOptionPane.showMessageDialog(this, "Input harus angka!");
        }
    }

    // ===================== TAMBAH SAYUR (GUI) =====================
    private void tambahSayurGUI() {

        // Inisialisasi komponen input teks untuk form tambah sayur
        JTextField txtNama = new JTextField();
        JTextField txtHarga = new JTextField();
        JTextField txtStok = new JTextField();
        JTextField txtDiskon = new JTextField();

        // Pilihan jenis sayur untuk ditampilkan pada ComboBox
        String[] jenis = { "Sayur Daun", "Sayur Buah", "Sayur Batang", "Sayur Akar" };
        // Membuat komponen dropdown ComboBox dengan pilihan jenis sayur
        JComboBox<String> cmbJenis = new JComboBox<>(jenis);

        // Menyusun komponen-komponen input ke dalam sebuah array Object untuk
        // ditampilkan di dialog
        Object[] form = {
                "Nama Sayur:", txtNama,
                "Harga:", txtHarga,
                "Stok:", txtStok,
                "Jenis:", cmbJenis,
                "Diskon (0.1 = 10%):", txtDiskon
        };

        // Menampilkan dialog konfirmasi berisi form input yang telah disusun
        int result = JOptionPane.showConfirmDialog(this, form,
                "Tambah Sayur Baru", JOptionPane.OK_CANCEL_OPTION);

        // Jika user tidak menekan tombol OK maka proses dibatalkan
        if (result != JOptionPane.OK_OPTION)
            return;

        try {
            // Mengambil nilai input dari masing-masing komponen form
            String nama = txtNama.getText();
            int harga = Integer.parseInt(txtHarga.getText());
            int stok = Integer.parseInt(txtStok.getText());

            // Deklarasi variabel objek sayur
            Sayur sayur;
            // Menentukan class anak yang akan digunakan berdasarkan pilihan pada ComboBox
            switch (cmbJenis.getSelectedIndex()) {
                case 0 -> sayur = new SayurDaun(nama, harga, stok);
                case 1 -> sayur = new Cabe(nama, harga, stok);
                case 2 -> sayur = new Tomat(nama, harga, stok);
                case 3 -> sayur = new SayurAkar(nama, harga, stok);
                default -> sayur = new Sayur(nama, harga, stok);
            }

            // Mengecek jika input diskon tidak kosong maka nilai diskon akan diterapkan
            if (!txtDiskon.getText().isEmpty()) {
                // Mengubah teks diskon ke double dan mengganti koma menjadi titik agar valid
                double diskon = Double.parseDouble(txtDiskon.getText().replace(",", "."));
                sayur.setDiskon(diskon);
            }

            // Menambahkan objek sayur baru ke dalam daftarSayur di class
            // KasirPenjualanSayur
            KasirPenjualanSayur.daftarSayur.add(sayur);
            // Memperbarui tampilan list agar sayur baru muncul di layar
            loadData();

            // Menampilkan pesan sukses tambah data
            JOptionPane.showMessageDialog(this, "Sayur berhasil ditambahkan!");

        } catch (Exception e) {
            // Menampilkan pesan error jika terjadi kesalahan input data
            JOptionPane.showMessageDialog(this, "Input tidak valid!");
        }
    }

    // ===================== RIWAYAT =====================
    private void tampilkanRiwayat() {

        // Mengecek apakah sudah ada transaksi yang tercatat atau belum
        if (KasirPenjualanSayur.transaksiSayur.isEmpty()) {
            // Menampilkan pesan jika riwayat masih kosong
            JOptionPane.showMessageDialog(this, "Belum ada transaksi.");
            return;
        }

        // Menggunakan StringBuilder untuk menyusun teks riwayat secara efisien
        StringBuilder sb = new StringBuilder("RIWAYAT TRANSAKSI\n\n");

        // Melakukan perulangan untuk mengambil semua data dari list transaksi
        for (int i = 0; i < KasirPenjualanSayur.transaksiSayur.size(); i++) {
            // Menyusun teks detail transaksi baris demi baris menggunakan StringBuilder
            // .append() berfungsi untuk menyambung/menambah teks ke bagian akhir tanpa
            // menghapus teks sebelumnya
            sb.append(i + 1).append(". ") // Menambahkan nomor urut transaksi
                    .append(KasirPenjualanSayur.transaksiSayur.get(i)) // Menambahkan nama sayur dari daftar transaksi
                    .append(" | Jumlah: ") // Menambahkan teks pemisah untuk kolom jumlah
                    .append(KasirPenjualanSayur.transaksiJumlah.get(i)) // Menambahkan angka jumlah yang dibeli
                    .append(" | Total: Rp") // Menambahkan teks pemisah untuk kolom total harga
                    .append(KasirPenjualanSayur.transaksiTotal.get(i)) // Menambahkan nilai nominal total transaksi
                    .append("\n"); // Menambahkan baris baru (Enter) agar transaksi berikutnya dimulai di baris
        }

        // Menampilkan seluruh riwayat transaksi dalam satu pop-up dialog
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    public static void main(String[] args) {
        // Memanggil method untuk inisialisasi data awal (stok barang default)
        KasirPenjualanSayur.initAwal();
        // Membuat instance GUI dan menampilkannya ke layar
        new GUIPertama().setVisible(true);
    }
}
