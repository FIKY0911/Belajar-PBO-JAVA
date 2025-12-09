package pert7.ManagementMemory.TugasPraktikum;

public class CallSimpleVariables {
    public static double square(double n){
        double temp;
        temp = n*n;
        return temp;
    }
    public static void main(String[] args) {
    double x = 4.5;
    double y;
    y=square(x);//Untuk memanggil fungsi square
    System.out.println("Square of "+x+" is "+y);
    }
}
