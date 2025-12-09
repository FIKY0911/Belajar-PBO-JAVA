package pert7.ManagementMemory.TugasPraktikum;

public class CallingSquence {
    public static void m2(){ //Method m2
        System.out.println("Starting m2"); //Awal method m2
        System.out.println("m2 calling m3"); //Memanggil method m3
        m3(); //Memanggil method m3
        System.out.println("m2 calling m4"); //Memanggil method m4
        m4(); ///Memanggil method m4
        System.out.println("Leaving m2");
        return; //Akhir method m2
    }
    public static void m3(){
        System.out.println("Starting m3"); //Awal method m3
        System.out.println("Leaving m3");
        return;
    }
    public static void m4(){
        System.out.println("Starting m4");//Awal method m4
        System.out.println("Leaving m4");
        return;
    }
    public static void main(String[] args) {
        System.out.println("Starting main"); //Awal method main
        System.out.println("main calling m2"); //Memanggil method m2
        m2(); //Memanggil method m2
        System.out.println("Leaving main");
        return; //Akhir method main
    }
}
