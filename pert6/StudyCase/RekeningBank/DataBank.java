package pert6.StudyCase.RekeningBank;

public class DataBank {
    private String norek;
    private double saldo;

    // Konstruktor
    public DataBank(String norek, double saldo) {
        this.norek = norek;
        setSaldo(saldo); // Menggunakan setter untuk validasi saldo
    }

    // Setter dan Getter untuk norek
    public void setNorek(String norek) {
        this.norek = norek;
    }

    public String getNorek() {
        return norek;
    }

    // Setter dan Getter untuk saldo dengan validasi
    public void setSaldo(double saldo) {
        if (saldo < 0) {
            System.out.println("Saldo tidak boleh negatif");
        } else {
            this.saldo = saldo;
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
