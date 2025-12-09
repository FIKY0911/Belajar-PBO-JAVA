package pert4.PraktekFunctionParameter;

public class FungsiReturnValue{
    public static int area (int plong, int pWidth){
        return plong*pWidth;
    }
    public static void main(String[] args){
        int luas = area(4, 5);
        System.out.println("Output Luas: " + luas);
    }
}

