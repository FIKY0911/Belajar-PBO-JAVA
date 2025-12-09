package pert7.ManagementMemory.TugasTeori;

public class CallStackExample {
    public static void main(String[] args) {
        methodA();//memanggil methodA
    }
    
    public static void methodA() {
        System.out.println("Memanggil methodB"); //memanggil methodB
        methodB();
    }
    
    public static void methodB() {
        System.out.println("Memanggil methodC"); //memanggil methodC
        methodC();
    }
    
    public static void methodC() {
        System.out.println("In methodC");
        // Saat di sini: stack = [main, methodA, methodB, methodC]
        // Frame selanjutnya: methodD (jika dipanggil)
    }
}
