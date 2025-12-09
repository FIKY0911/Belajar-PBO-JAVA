package pert8.Praktik;

class Tata_surya{
}
class Bumi extends Tata_surya{
}
class Mars extends Tata_surya{
}
class Bulan extends Bumi{
    public static void main(String[] args){
        Tata_surya t = new Tata_surya();
        Bumi b = new Bumi();
        Mars m = new Mars();

        System.out.println(t instanceof Tata_surya);
        System.out.println(b instanceof Bumi);
        System.out.println(m instanceof Mars);
    }
}
