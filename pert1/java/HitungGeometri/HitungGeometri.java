package pert1.java.HitungGeometri;

public class HitungGeometri {

    public static double hitungKelilingLingkaran(double r) {
        return 2 * Math.PI * r;
    }

    public static double hitungLuasPersegiPanjang(double panjang, double lebar) {
        return panjang * lebar;
    }

    public static double hitungLuasSegitiga(double alas, double tinggi) {
        return (alas * tinggi) / 2;
    }
}