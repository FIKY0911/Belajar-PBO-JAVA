package pert8.Praktik;

class Satu{
    public void print_pbo(){
        System.out.println("Pemrograman Berbasis Objek");
    }
}

// Child class Dua inherits from class Satu
class Dua extends Satu{
    public void print_for(){
        System.out.println("dengan JAVA");
    }
}

// Child class Tiga inherits from class Dua
class Tiga extends Dua{
    public void print_lastgeek(){
        System.out.println("Pemrograman dengan JAVA");
    }
}

class main{
    public static void main(String[] args){
        Two p = new Two();
        p.print_pbo();
        p.print_for();
        p.print_pbo();
    }
}
