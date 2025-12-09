package pert4.PraktekFunctionParameter;

public class parameterbyvalue {
    public static void manipulasiValue(int x){
        x = x + 1;
    }

    public static void main(String[] args){
        int number = 5;
        manipulasiValue(number);
        System.out.println(number);
    }
}
