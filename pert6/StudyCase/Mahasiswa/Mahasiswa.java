package pert6.StudyCase.Mahasiswa;

public class Mahasiswa {
    private String nama;
    private String nim;
    private double ipk;

    // Konstruktor
    public Mahasiswa(String nama, String nim, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.ipk = ipk;
    }

    // Setter dan Getter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    // Setter dan Getter untuk nim
    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    // Setter dan Getter untuk ipk
    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public double getIpk() {
        return ipk;
    }
}
